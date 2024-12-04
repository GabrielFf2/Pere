package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class TalkerEnglishImpl implements ITalker{
    @Override
    public void talk() {
        System.out.println("Hi I'm talking in english");
    }
}
