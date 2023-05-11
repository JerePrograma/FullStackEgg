package main;

import entidad.Cadena;
import servicio.CadenaServicio;

public class Main {

    public static void main(String[] args) {
        CadenaServicio cad = new CadenaServicio();

        Cadena cadena1 = new Cadena("Casa blanca");

        cad.mostrarVocales(cadena1);

        cad.invertirFrase(cadena1);

    }

}
