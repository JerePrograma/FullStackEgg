package main;

import servicio.FechaService;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        FechaService fechaService = new FechaService();

        // Obtener la fecha de nacimiento del usuario
        Date fechaNacimiento = fechaService.fechaNacimiento();

        // Obtener la fecha actual
        Date fechaActual = fechaService.fechaActual();

        // Calcular la diferencia de años (edad del usuario)
        int edad = fechaService.diferencia(fechaNacimiento, fechaActual);

        System.out.println("Tu edad es: " + edad + " años");
    }
}
