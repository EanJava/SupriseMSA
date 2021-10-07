package com.ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ms.dao.SurpriseDao;
import com.ms.model.Surprise;

@RestController
public class RandomSurpriseController {

    private final SurpriseDao SurpriseDao;

    public RandomSurpriseController(SurpriseDao SurpriseDao){
        this.SurpriseDao=SurpriseDao;
    }

    @GetMapping("/random")
    public Surprise randomSurprise(){
        Surprise Surprise=SurpriseDao.random();
        System.out.println(Surprise);
        return Surprise;
    }
}
