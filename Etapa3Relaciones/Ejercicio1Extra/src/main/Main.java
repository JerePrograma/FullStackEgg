package main;

import entidad.Perro;
import entidad.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import servicio.PerroService;
import servicio.PersonaService;

public class Main {

    public static void main(String[] args) {

        PersonaService ser = new PersonaService();
        PerroService serv = new PerroService();
        ArrayList<Perro> perros = serv.crearPerros();
        ArrayList<Persona> personas = ser.crearPersona();
        HashMap<Persona, Perro> adoptar = new HashMap<>();
        ser.adoptarPerro(personas, perros, adoptar);
    }
}
