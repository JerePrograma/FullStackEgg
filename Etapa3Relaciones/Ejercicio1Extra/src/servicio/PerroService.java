package servicio;

import entidad.Perro;
import java.util.ArrayList;
import java.util.Scanner;

public class PerroService {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public ArrayList<Perro> crearPerros() {
        ArrayList<Perro> perros = new ArrayList();
        String op;
        do {

            System.out.println("Ingrese el nombre del perro");
            String nombre = leer.next();
            System.out.println("Ingrese la raza del perro");
            String raza = leer.next();
            System.out.println("Ingrese la edad del perro");
            int edad = leer.nextInt();
            System.out.println("Ingrese el tamaño del perro");
            String tamanio = leer.next();
            Perro pe = new Perro(nombre, raza, edad, tamanio);
            perros.add(pe);
            System.out.println("Desea seguir ingresando perros s/n");
            op = leer.next();
        } while (op.equalsIgnoreCase("s"));

        return perros;
    }
}
