package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Estate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateService {

    @Autowired
    EstateService estateService;

    public Estate saveEstate(Estate estate){
        estateService.saveEstate(estate);
        return estate;
    }

}
