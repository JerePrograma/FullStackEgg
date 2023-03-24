package eggprojects.Guia3.Guia;

import java.util.Scanner;

public class Ejemplo3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String respuesta;

        do {
            System.out.println("Desea continuar?");
            respuesta = leer.nextLine();
        } while (respuesta.equalsIgnoreCase("S"));
    }
}
