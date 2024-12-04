package org.example.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.service.Comparable;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor


public abstract class ElementApi implements Comparable {
    protected Integer id;
    protected String name;
    protected LocalDateTime dataCreacio;

    public int compareTo(ElementApi o){
        return this.dataCreacio.compareTo(o.getDataCreacio())*-1;
    };


}
