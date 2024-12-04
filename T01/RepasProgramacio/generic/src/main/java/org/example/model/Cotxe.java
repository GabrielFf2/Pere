package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cotxe{
    private String matricula;
    private String model;

    @Override
    public String toString(){
        return this.matricula + " -  " + this.model;
    }
}
