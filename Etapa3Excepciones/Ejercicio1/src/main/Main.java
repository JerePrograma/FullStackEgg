package main;

import entidad.Persona;
import java.util.Scanner;
import servicio.PersonaServicio;
//Inicializar un objeto de la clase Persona ejercicio 3 de la guía Servicios, a null y tratar de invocar el
//método esMayorDeEdad() a través de ese objeto. Luego, englobe el código con una cláusula
//try-catch para probar la nueva excepción que debe ser controlada.

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        PersonaServicio personaServicio = new PersonaServicio();
        System.out.println("Ingrese cuantas personas desea cargar");
        int N = leer.nextInt();
        Persona[] personas = new Persona[N];
        int[] resultadosIMC = new int[N];
        boolean[] mayoresDeEdad = new boolean[N];

        personas[0] = personaServicio.crearPersona();
        personas[1] = null;

        for (int i = 0; i < N; i++) {
            try {
                mayoresDeEdad[i] = personaServicio.esMayorDeEdad(personas[i]);
                resultadosIMC[i] = personaServicio.calcularIMC(personas[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int porDebajoPeso = 0;
        int enPesoIdeal = 0;
        int conSobrepeso = 0;
        int cantidadMayoresDeEdad = 0;

        for (int i = 0; i < N; i++) {
            switch (resultadosIMC[i]) {
                case -1:
                    porDebajoPeso++;
                    break;
                case 0:
                    enPesoIdeal++;
                    break;
                default:
                    conSobrepeso++;
                    break;
            }
            if (mayoresDeEdad[i]) {
                cantidadMayoresDeEdad++;
            }
        }

        System.out.println("Porcentaje de personas por debajo del peso ideal: " + (porDebajoPeso / N) * 100);
        System.out.println("Porcentaje de personas en su peso ideal: " + (enPesoIdeal / N) * 100);
        System.out.println("Porcentaje de personas con sobrepeso: " + (conSobrepeso / N) * 100);
        System.out.println("Porcentaje de personas mayores de edad: " + (cantidadMayoresDeEdad / N) * 100);
        System.out.println("Porcentaje de personas menores de edad: " + ((4 - cantidadMayoresDeEdad) / N) * 100);
    }
}
