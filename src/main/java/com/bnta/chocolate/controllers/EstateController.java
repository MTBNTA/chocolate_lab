package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> estates = estateService.getAllEstates();
        return new ResponseEntity<>(estates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}") // SHOW GET localhost:8080/2
    public ResponseEntity<Estate> getEstateById(@PathVariable long id){

        Optional<Estate> estate = estateService.getEstateById(id);
        if(estate.isPresent()){
            return new ResponseEntity<>(estate.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Estate> createNewEstate(@RequestBody Estate estate){
        Estate createdEstate = estateService.saveEstate(estate);
        return new ResponseEntity<>(createdEstate, HttpStatus.CREATED);
    }

}
