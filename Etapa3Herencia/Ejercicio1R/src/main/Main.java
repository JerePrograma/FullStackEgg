package main;

import entidad.Animal;
import entidad.Caballo;
import entidad.Gato;
import entidad.Perro;
import java.util.ArrayList;
//Tenemos una clase padre Animal junto con sus 3 clases hijas Perro, Gato, Caballo.
//La clase Animal tendrá como atributos el nombre, alimento, edad y raza del Animal.
//Crear un método en la clase Animal a través del cual cada clase hija deberá mostrar luego un
//mensaje por pantalla informando de que se alimenta. Generar una clase Main que realice lo
//siguiente:

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList();
        Animal p1 = new Perro("Stich", "Carnivoro", 15, "Doberman");
        animales.add(p1);
        Animal p2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
        animales.add(p2);
        Animal g1 = new Gato("Pelusa", "Galletas", 15, "Siamés");
        animales.add(g1);
        Animal c1 = new Caballo("Spark", "Pasto", 25, "Fino");
        animales.add(c1);

        for (Animal animal : animales) {
            animal.alimento();
        }
    }
}
