package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private ITalker talker;

    public MyService(ITalker talker){
        this.talker = talker;
    }

    public void exist(){
        System.out.println("Im the service");
        talker.talk();
    }

}
