package main;

import entidad.Cadena;
import servicio.CadenaServicio;

public class Main {

    public static void main(String[] args) {
        CadenaServicio cad = new CadenaServicio();

        Cadena c = new Cadena("Casa blanca");

        cad.mostrarVocales(c);

        cad.invertirFrase(c);

    }

}
