package org.example.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TalkerMallorquiImpl implements ITalker{
    @Override
    public void talk() {
        System.out.println("Hola estic xerrant en mallorquí");
    }
}
