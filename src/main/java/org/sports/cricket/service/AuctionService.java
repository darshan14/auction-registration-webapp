package org.sports.cricket.service;

import org.sports.cricket.dto.AuctionBidRequestDTO;
import org.sports.cricket.dto.AuctionBidResponseDTO;

public interface AuctionService {

    AuctionBidResponseDTO processUserBid(AuctionBidRequestDTO request);
    void processAiBidding(AuctionBidRequestDTO request);
}
