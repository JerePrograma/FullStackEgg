//Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
//La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
//Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
//mensaje por pantalla informando de que se alimenta. Generar una clase Main que realice lo
//siguiente:
package main;

import entidad.Animal;
import entidad.Gato;
import entidad.Perro;

public class Main {

    public static void main(String[] args) {
        //Declaración del objeto Perro
        Animal perro1 = new Perro("Stich", "Carnivoro", 15, "Doberman");
        perro1.alimentarse();
        //Declaración del objeto Perro
        Animal perro2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
        perro2.alimentarse();
        //Declaración del objeto Gato
        Animal gato1 = new Gato("Pelusa", "Galletas", 15, "Siamés");
        gato1.alimentarse();
        //Declaración del objeto Caballo
        Animal caballo1 = new Perro("Spark", "Pasto", 25, "Fino");
        caballo1.alimentarse();
    }
}
