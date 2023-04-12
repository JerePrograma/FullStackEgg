package main;

import entidad.Raices;
import servicio.RaicesServicio;

class Main {

    public static void main(String[] args) {
        Raices ecuacion = new Raices(1, 2, 1);
        RaicesServicio.calcular(ecuacion);
    }
}
