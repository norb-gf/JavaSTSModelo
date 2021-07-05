package com.ngf.sp_bkend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngf.sp_bkend.exception.ResourceNotFoundException;
import com.ngf.sp_bkend.model.Coin;
import com.ngf.sp_bkend.repository.CoinRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CoinController {

    @Autowired
    private CoinRepository coinRepository;

    // get all coins
    @GetMapping("/coins")
    public List < Coin> getAllCoins() {
//    	System.out.println("Passei get all coins ...");
        return coinRepository.findAll();
    }

    // get all coins sort
    @GetMapping("/coins/sort_by_id")
    public List < Coin > findAllCoins() {
 //   	System.out.println("Passei find all coins sort");
        return coinRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }
    
    // get coins by family Sort rest api
    @GetMapping("/coins/sort_by_name/{family}")
    public List < Coin > findAllSortById(@PathVariable String family) {
//    	System.out.println("passei sort family " + family);
        return coinRepository.findAllSortById(family);
    }
    
    // create coin rest api
    @PostMapping("/coins")
    public Coin createCoin(@RequestBody Coin coin) {
        return coinRepository.save(coin);
    }

    // get coin by id rest api
    @GetMapping("/coins/id/{id}")
    public ResponseEntity < Coin > getCoinById(@PathVariable Long id) {
        Coin coin = coinRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("Coin not exist with id :" + id));
//        System.out.println("Passei get coin by ID..." + id);
        return ResponseEntity.ok(coin);
    }
    
 
    // update coin rest api

    @PutMapping("/coins/{id}")
    public ResponseEntity < Coin > updateCoin(@PathVariable Long id, @RequestBody Coin coinDetails) {
        Coin coin = coinRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("Coin not exist with id :" + id));

        coin.setFamily(coinDetails.getFamily());
        coin.setFaceValue(coinDetails.getFaceValue());
        coin.setStampYear(coinDetails.getStampYear());
        coin.setImgFile(coinDetails.getImgFile());
        coin.setSigla(coinDetails.getSigla());

        Coin updatedCoin = coinRepository.save(coin);
//        System.out.println("Update ==> data: " + coin.getLogin() + "id= " + coin.getId());
        return ResponseEntity.ok(updatedCoin);
    }

    // delete coin rest api
    @DeleteMapping("/coins/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteCoin(@PathVariable Long id) {
        Coin coin = coinRepository.findById(id)
            .orElseThrow( () -> new ResourceNotFoundException("Coin not exist with id :" + id));

        coinRepository.delete(coin);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
//        System.out.println("passei Delete.....");
        return ResponseEntity.ok(response);
    }
}
