/*Realiza un programa en donde exista una clase Jugador que contenga nombre, apellido, posición
y número. Luego otra clase Equipo que contenga una colección de jugadores. Una vez hecho
esto, desde el main recorreremos el equipo mostrando la información de cada jugador.
 */
package eje2.main;

import eje2.entidad.Equipo;
import eje2.entidad.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean cargar = true;
        Equipo equipo1 = new Equipo();

        do {
            Jugador jugador = new Jugador();
            System.out.println("Ingrese el nombre del jugador");
            jugador.setNombre(leer.next());
            System.out.println("Ingrese el apellido del jugador");
            jugador.setApellido(leer.next());
            System.out.println("Ingrese la posicion del jugador");
            jugador.setPosicion(leer.nextInt());
            System.out.println("Ingrese el numero del jugador");
            jugador.setNumero(leer.nextInt());
            System.out.println("Desea ingresar otro? S/N");
            if (leer.next().equalsIgnoreCase("N")) {
                cargar = false;
            }
            equipo1.getEquipo().add(jugador);
        } while (cargar);
        for (Jugador jugador : equipo1.getEquipo()) {
            System.out.println(jugador.toString());
        }
    }
}
