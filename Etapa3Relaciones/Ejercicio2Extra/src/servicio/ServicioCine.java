/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Cine;
import entidad.Espectador;
import entidad.Pelicula;
import java.util.Random;

/**
 *
 * @author Jerem
 */
public class ServicioCine {

    public void sentarEspectadores(Espectador[] espectadores, Cine cine) {
        Pelicula pelicula = cine.getPelicula();
        Espectador[][] sala = cine.getSala();
        double precioEntrada = cine.getPrecioEntrada();
        Random random = new Random();
        for (Espectador espectador : espectadores) {
            if (espectador.getEdad() >= pelicula.getEdadMinima() && espectador.getDinero() >= precioEntrada) {
                int fila, columna;
                do {
                    fila = random.nextInt(sala.length);
                    columna = random.nextInt(sala[0].length);
                } while (sala[fila][columna] != null);

                sala[fila][columna] = espectador;
                espectador.pagar(precioEntrada);
            }
        }
    }

    public void mostrarSala(Cine cine) {
        Espectador[][] sala = cine.getSala();
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[0].length; j++) {
                if (sala[i][j] == null) {
                    System.out.print(" | ");
                } else {
                    System.out.print("X | ");
                }
            }
            System.out.println();
        }
    }
}
