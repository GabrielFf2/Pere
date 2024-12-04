package org.example.service;

import com.google.gson.JsonObject;
import org.example.model.Episodi;
import org.example.model.Genere;
import org.example.model.Personatge;
import org.example.model.getJason;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RickAndMortyServiceImpl implements IRickAndMortyService , Classificator {

    private List<Personatge> personatges;
    private List<Episodi> episodis;



    private Genere obtenirGenere(String genereString){
        switch (genereString) {
            case "Male":
                return Genere.MASCLE;
            case "Female":
                return Genere.FEMELLA;
            case "Genderless":
                return Genere.SENSE_GENERE;
            default:
                return Genere.DESCONEGUT;
        }
    }


    private List<Personatge> findAll
    @Override
    public List<Personatge> pjByGenere(Genere genere) {
        List<Personatge> per =  new ArrayList<>();
        List<JsonObject> result = getJason.getAllPersonatges();

        Predicate<Personatge> filGenere = x -> x.getGenere().equals(genere);

        return per.stream().filter(filGenere).toList();
    }

    @Override
    public List<String> findAliveAliensNames() {
        return List.of();
    }

    @Override
    public List<Episodi> episodisPerTemporada(Integer temporada) {
        return List.of();
    }
}















