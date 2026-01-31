package org.sports.cricket.service;

import org.sports.cricket.model.AuctionPlayerState;
import org.sports.cricket.repository.AuctionPlayerStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionPlayerStatusServiceImpl implements AuctionPlayerStatusService{

    @Autowired
    AuctionPlayerStateRepository auctionPlayerStateRepository;

    @Override
    public boolean isPlayerAuctionFinish(Long playerId) {

        AuctionPlayerState auctionPlayerState = auctionPlayerStateRepository.findTopByPlayerIdOrderByIdDesc(playerId).get();
        System.out.println(auctionPlayerState.toString());

        if(auctionPlayerState.getBidStatus().equals("IN PROGRESS"))
            return false;
        else
            return true;
    }
}
