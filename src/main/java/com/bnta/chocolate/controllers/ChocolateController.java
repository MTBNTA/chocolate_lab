package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;


    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> cocoaPercentage){
        List<Chocolate> chocolates;
        if(cocoaPercentage.isPresent()){
            chocolates = chocolateService.getCocoaGreaterThanOrEqualTo(cocoaPercentage.get());
        }else {
            chocolates = chocolateService.getAllChocolates();
        }
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){

        Optional<Chocolate> chocolate = chocolateService.getChocolateById(id);
        if(chocolate.isPresent()){
            return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Chocolate> createNewChocolate(@RequestBody ChocolateDTO chocolateDTO){
        try {
            Chocolate chocolate = chocolateService.createNewChocolate(chocolateDTO);
            return new ResponseEntity<>(chocolate, HttpStatus.CREATED);
        }catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


}
