package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateService estateService;

    public Chocolate saveChocolate(Chocolate chocolate){
         chocolateRepository.save(chocolate);
         return chocolate;
    }

    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getChocolateById(long id){
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getCocoaGreaterThanOrEqualTo(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageGreaterThanEqual(cocoaPercentage);
    }

    public Chocolate createNewChocolate(ChocolateDTO chocolateDTO) throws Exception{
        Optional<Estate> estate = estateService.getEstateById(chocolateDTO.getEstateId());
        if(estate.isPresent()){
            Chocolate chocolate = new Chocolate(chocolateDTO.getName(), chocolateDTO.getCocoaPercentage(), estate.get());
            chocolateRepository.save(chocolate);
            return chocolate;
        }
        throw new Exception("Invalid estate id.");
    }
}
