package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ModuleDescriptor;
import java.lang.reflect.Parameter;
import java.util.List;

@RestController
//@RequestMapping("/auctions")
public class AuctionController {
    private AuctionDao auctionDao;
    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(defaultValue = "") String title_like,
                              @RequestParam(defaultValue = "0")Double currentBid_lte){
        if(!title_like.isEmpty() && currentBid_lte > 0){
                return auctionDao.getAuctionsByTitleAndMaxBid(title_like, currentBid_lte);
        }else if(!title_like.isEmpty() && currentBid_lte == 0){
            return auctionDao.getAuctionsByTitle(title_like);
        }else if (title_like.isEmpty() && currentBid_lte > 0){
            return auctionDao.getAuctionsByMaxBid(currentBid_lte);
        }
        return auctionDao.getAuctions();
    };

    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id){
        return auctionDao.getAuctionById(id);
    };

    @RequestMapping(path = "/auctions", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction auction){
        return auctionDao.createAuction(auction);
    };

}
