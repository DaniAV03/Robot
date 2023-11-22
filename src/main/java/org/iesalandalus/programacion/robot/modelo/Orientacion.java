package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE, NORESTE, ESTE, SURESTE, SUR, SUROESTE, OESTE, NOROESTE;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}

