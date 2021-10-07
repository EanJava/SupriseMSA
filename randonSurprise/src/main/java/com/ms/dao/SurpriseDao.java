package com.ms.dao;

import org.springframework.stereotype.Component;
import com.ms.model.Surprise;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class SurpriseDao {
    private List<Surprise> list = Arrays.asList(new Surprise("kettle"), new Surprise("car"), new Surprise("сandies"), new Surprise("crisps"));

    public Surprise random(){
        Random rand = new Random();
        return  list.get(rand.nextInt(list.size()));
    }
}
