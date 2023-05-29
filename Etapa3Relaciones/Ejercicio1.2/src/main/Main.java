package main;

/*Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.*/
import entidad.Perro;
import entidad.Persona;

public class Main {

    public static void main(String[] args) {
        Persona[] personas = new Persona[2];
        personas[0] = new Persona("Jeremias", "Rivelli", 28, 12345, null);
        personas[1] = new Persona("Jorge", "Lanatta", 21312, 123, null);
        Perro[] perros = new Perro[2];
        perros[0] = new Perro("Chiquito", "Rotwailer", 2, "chiquito");
        perros[1] = new Perro("Cartucho", "Chihuahua", 1, "grande");

        for (int i = 0; i < personas.length; i++) {
            personas[i].setPerro(perros[i]);
        }

        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }
}
