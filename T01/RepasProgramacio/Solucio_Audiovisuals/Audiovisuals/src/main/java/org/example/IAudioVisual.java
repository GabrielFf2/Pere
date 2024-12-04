package org.example;

import org.example.model.Canco;

import java.io.IOException;
import java.util.List;

public interface IAudioVisual {
    List<Canco> findAllCanconsLliures() throws IOException;
    List<Canco> findAllCancons() throws IOException;
}
