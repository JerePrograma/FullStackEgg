package main;

import entidad.Persona;
import servicio.PersonaService;

public class Main {

    public static void main(String[] args) {
        PersonaService personaService = new PersonaService();

        Persona persona = personaService.crearPersona();

        int edad = personaService.calcularEdad(persona);
        System.out.println("La edad de " + persona.getNombre() + " es: " + edad + " años");

        int edadComparar = 30;
        boolean esMenor = personaService.menorQue(persona, edadComparar);
        System.out.println(persona.getNombre() + (esMenor ? " es" : " no es") + " menor que " + edadComparar + " años");

        System.out.println("Información de la persona:");
        personaService.mostrarPersona(persona);
    }
}
