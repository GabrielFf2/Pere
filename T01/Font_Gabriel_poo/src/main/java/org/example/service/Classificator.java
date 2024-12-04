package org.example.service;

import org.example.model.Episodi;
import org.example.model.Genere;
import org.example.model.Personatge;

import java.util.List;

public interface Classificator {
    List<Personatge> pjByGenere(Genere genere);
    List<String> findAliveAliensNames();
    List<Episodi> episodisPerTemporada(Integer temporada);




}
