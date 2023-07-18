package main;

import entidad.Persona;
import java.util.Scanner;
import servicio.PersonaServicio;

public class EjercicioPrueba {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaServicio personaServicio = new PersonaServicio();
        Persona[] personas = new Persona[4];
        personas[0] = new Persona();
        personas[1] = null;
        try {
            personaServicio.esMayorDeEdad(personas[1]);
            personaServicio.calcularIMC(personas[0]);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

}
