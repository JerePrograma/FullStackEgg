
package Main;

import entidad.Perro;
import java.util.Scanner;
import servicio.PerroServicio;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerroServicio servicio = new PerroServicio();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Introduce la raza del perro:");
            String raza = scanner.nextLine();

            Perro perro = new Perro(raza);
            servicio.agregarPerro(perro);

            System.out.println("¿Deseas guardar otro perro? (S/N)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }

        servicio.mostrarPerros();
    }
}
