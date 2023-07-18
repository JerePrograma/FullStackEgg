package main;

import entidad.Persona;
import servicio.PersonaServicio;
//Inicializar un objeto de la clase Persona ejercicio 3 de la guía 8 Servicios, a null y tratar
//de invocar el método esMayorDeEdad() a través de ese objeto. Luego, englobe el código
//con una cláusula try-catch para probar la nueva excepción que debe ser controlada.

public class Main {

    public static void main(String[] args) {
        PersonaServicio personaServicio = new PersonaServicio();
        Persona[] personas = new Persona[4];
        personas[0] = null;
        try {
            personaServicio.esMayorDeEdad(personas[0]);
        } catch (NullPointerException e) {
            System.out.println("Error al calcular la masa");
        }
    }
}
