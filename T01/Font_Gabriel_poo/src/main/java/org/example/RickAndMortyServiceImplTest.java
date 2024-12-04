package org.example;

import org.example.model.Episodi;
import org.example.model.Genere;
import org.example.model.Personatge;
import org.example.service.RickAndMortyServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RickAndMortyServiceImplTest {

    RickAndMortyServiceImpl servei = new RickAndMortyServiceImpl();
    InfoWeb<Personatge> infoWeb = new InfoWeb<>();

    @org.junit.jupiter.api.Test
    void pjByGenere() {
        List<Personatge> femelles =  servei.pjByGenere(Genere.FEMELLA);
        assertEquals(13, femelles.size());
        assertEquals("Annie", femelles.get(3).getNom());

        List<Personatge> mascles =  servei.pjByGenere(Genere.MASCLE);
        assertEquals(58, mascles.size());
        assertEquals("Agency Director", mascles.get(5).getNom());
    }

    @org.junit.jupiter.api.Test
    void findAliveAlienNames() {
        List<String> alienNames = servei.findAliveAlienNames();
        assertEquals(13, alienNames.size());
        assertEquals("Armagheadon", alienNames.get(1));
    }

    @org.junit.jupiter.api.Test
    void episodisPerTemporada() {
        List<Episodi> epis = servei.episodisPerTemporada(2);
        assertEquals(10, epis.size());
        assertEquals("Get Schwifty", epis.get(4).getNom());
    }

    @org.junit.jupiter.api.Test
    void mesNous() {
        List<String> nous = infoWeb.mesNous(servei.getElementApi());
        assertEquals("Cousin Nicky", nous.get(4));
    }

    @org.junit.jupiter.api.Test
    void rickRick() {
        List<Personatge> ricks = infoWeb.rickRick(servei.getElementApi());
        assertEquals("Bootleg Portal Chemist Rick", ricks.get(6).getNom());
    }

}