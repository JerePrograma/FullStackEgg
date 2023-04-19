package main;

import java.util.Scanner;
import servicio.AhorcadoServicio;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        AhorcadoServicio as = new AhorcadoServicio();
        char salida = 'a';
        do {
            System.out.println("1- Iniciar Juego");
            System.out.println("2- Salir");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    as.juego();
                    break;
                case 2:
                    System.out.println("Seguro desea salir? (S para confirmar)");
                    salida = leer.next().charAt(0);
                    if (salida == 'S') {
                        System.out.println("Gracias por participar!");
                    }
                    break;
                default:
                    System.out.println("No se reconoce la opcion ingresada");
            }
        } while (salida != 'S');
    }
}
