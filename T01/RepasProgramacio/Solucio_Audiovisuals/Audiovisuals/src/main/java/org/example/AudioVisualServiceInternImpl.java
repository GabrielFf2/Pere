package org.example;

import org.example.model.Canco;

import java.io.IOException;
import java.util.List;

public class AudioVisualServiceInternImpl implements IAudioVisual{
    @Override
    public List<Canco> findAllCanconsLliures() throws IOException {
        return List.of();
    }

    @Override
    public List<Canco> findAllCancons() throws IOException {
        return List.of();
    }
}
