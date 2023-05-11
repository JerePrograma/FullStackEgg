/*Realiza un programa en donde una clase Persona tenga como atributo nombre, apellido y un
objeto de clase Dni. La clase Dni tendrá como atributos la serie (carácter) y número. Prueba
acceder luego a los atributos del dni de la persona creando objetos y jugando desde el main
 */
package eje.main;

import eje.entidad.Dni;
import eje.entidad.Persona;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Dni dni1 = new Dni();
        dni1.setSerie('B');
        dni1.setNumero(123451);
        persona1.setNombre("Jeremias");
        persona1.setApellido("Rivelli");
        persona1.setDni(dni1);
        System.out.println("El DNI de la " + persona1.getNombre() + " " + persona1.getApellido() + " persona es " + persona1.getDni().getNumero() + persona1.getDni().getSerie());
    }
}
