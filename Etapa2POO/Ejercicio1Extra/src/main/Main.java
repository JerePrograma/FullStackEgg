package main;

import entidad.Cancion;

/*Desarrollar una clase Cancion con los siguientes atributos: título y autor. 
Se deberá́ definir además dos constructores: uno vacío que inicializa el título y el autor a cadenas vacías y otro que reciba como parámetros el título y el autor de la canción. 
Se deberán además definir los métodos getters y setters correspondientes.*/
public class Main {

    public static void main(String[] args) {
        Cancion cancion1 = new Cancion();
        Cancion cancion2 = new Cancion("Merry Christmas Baby", "Elvis Presley");

        cancion1.setAutor("Arjona");
        cancion1.setTitulo("Señora de 4 decadas");
        System.out.println("El nombre de la primer canción es " + cancion1.getTitulo() + " y su autor es " + cancion1.getAutor());
        System.out.println("El nombre de la primer canción es " + cancion2.getTitulo() + " y su autor es " + cancion2.getAutor());
    }
}
