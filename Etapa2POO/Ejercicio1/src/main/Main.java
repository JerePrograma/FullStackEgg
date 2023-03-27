package main;

import entidad.Libro;

public class Main {

/*Crear una clase llamada Libro que contenga los siguientes atributos: ISBN, Título, Autor, Número de páginas,
y un constructor con todos los atributos pasados por parámetro y un constructor vacío. 
Crear un método para cargar un libro pidiendo los datos al usuario y luego 
informar mediante otro método el número de ISBN, el título, el autor del libro y el número de páginas.*/
    public static void main(String[] args) {
        Libro primerLibro = new Libro(12321, "Esta noche digo adios", "Jeremias", 234);
        Libro segundoLibro = new Libro();
        
        segundoLibro.cargarLibro();
        segundoLibro.mostrarLibro();
        primerLibro.mostrarLibro();
    }
}