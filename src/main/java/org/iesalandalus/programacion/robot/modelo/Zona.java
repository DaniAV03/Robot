package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public record Zona(int ancho, int alto) {
    static final int MINIMO_ANCHO = 10;
    static final int MINIMO_ALTO = 10;
    static final int MAXIMO_ANCHO = 100;
    static final int MAXIMO_ALTO = 100;

    public Zona {
        validarAlto(alto);
        validarAncho(ancho);
    }

    public Zona() {
        this(MINIMO_ANCHO, MINIMO_ALTO);
    }

    private void validarAlto(int alto) {
        if (alto < MINIMO_ALTO || alto > MAXIMO_ALTO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }

    private void validarAncho(int ancho) {
        if (ancho < MINIMO_ANCHO || ancho > MAXIMO_ANCHO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }

    public boolean pertenece(Coordenada coordenada) {
        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        return perteneceX(coordenada.x()) && perteneceY(coordenada.y());
    }

    private boolean perteneceY(int y) {
        return y >= 0 && y < alto;
    }

    private boolean perteneceX(int x) {
        return x >= 0 && x < ancho;
    }
}



