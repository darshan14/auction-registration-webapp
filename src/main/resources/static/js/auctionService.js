let stompClient = null;

connectSocket();

function connectSocket() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {

        stompClient.subscribe('/topic/auction-event', function (message) {
            const event = JSON.parse(message.body);

            const userTeam = document.getElementById("userTeamCode").value;
            const resultBox = document.getElementById("auctionResultBox");
            const title = document.getElementById("auctionResultTitle");
            const msg = document.getElementById("auctionResultMessage");

            console.log(userTeam, playerId);

             // Show result box
             resultBox.style.display = "block";
             updateTeams(event.auctionBidResponseDTO.teamStates);

             if (event.bidStatus === "SOLD") {
                 title.innerText = "Player SOLD 🏏";
                 msg.innerText =
                     "Sold to " +
                     event.auctionBidResponseDTO.cdTeam +
                     " for ₹ " +
                     event.auctionBidResponseDTO.amount.toLocaleString("en-IN");
             } else {
                 title.innerText = "Player UNSOLD";
                 msg.innerText = "No team placed a final bid for this player.";
             }

           if (event.nextPlayerId != null) {
                   setTimeout(() => {
                       window.location.href =
                           "/auction/auctionPlayer?userTeam=" +
                           userTeam +
                           "&playerId=" +
                           event.nextPlayerId;
                   }, 5000);
               } else {
                   window.location.href = "/finalResult";
               }
        });

        stompClient.subscribe('/topic/auction', function (message) {
            const bid = JSON.parse(message.body);
            console.log(bid);
            updateTeams(bid.teamStates);
            addBidHistory(bid);
        });

        stompClient.subscribe('/topic/countdown', function (message) {
            document.getElementById("countdownBox").style.display = "block";
            document.getElementById("countdown").innerText = message.body;
        });
    });
}


function placeBid() {
    const playerId = document.getElementById("playerId").value;
    const userTeam = document.getElementById("userTeamCode").value;
    const lastPlayerId = document.getElementById("lastPlayerId").value;

    fetch('/auction/bid', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ playerId: playerId, cdUserTeam: userTeam, lastPlayerId: lastPlayerId })
    })
    .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
    .then(data => {
            console.log(data, playerId);
            updateTeams(data.teamStates);
            addBidHistory(data);
        })
    .catch(error => console.error('Error:', error));
    /*.then(data => {
        updateTeams(data.teamStates);
        addBidHistory(data.lastBid);
    });*/
}

function updateTeams(teams) {
    teams.forEach(team => {
        const remainingEl = document.getElementById(team.code + "_remaining");
        const usedEl = document.getElementById(team.code + "_used");
        const playersEl = document.getElementById(team.code + "_players");

        if (remainingEl) {
            remainingEl.innerText = team.remainingPurse.toLocaleString("en-IN");
        }

        if (usedEl) {
            usedEl.innerText = team.usedPurse.toLocaleString("en-IN");
        }

        if (playersEl && team.totalPlayers != null) {
            playersEl.innerText = team.totalPlayers;
        }
    });
}


function addBidHistory(bid) {
    const li = document.createElement("li");
    li.innerText = bid.cdTeam + " bid ₹ " + bid.amount;
    document.getElementById("bidHistoryList").appendChild(li);
}