package servicio;

import entidad.Persona;
import java.util.Date;
import java.util.Scanner;

public class PersonaService {

    public Date leerFechaNacimiento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el día de su nacimiento:");
        int dia = scanner.nextInt();
        System.out.println("Por favor, ingrese el mes de su nacimiento (1-12):");
        int mes = scanner.nextInt() - 1;
        System.out.println("Por favor, ingrese el año de su nacimiento:");
        int anio = scanner.nextInt() - 1900;

        return new Date(anio, mes, dia);
    }

    public int calcularDiferencia(Date fechaNacimiento, Date fechaActual) {
        long milisegundosPorAnio = 1000L * 60 * 60 * 24 * 365;
        long diferenciaMilisegundos = fechaActual.getTime() - fechaNacimiento.getTime();
        int edad = (int) (diferenciaMilisegundos / milisegundosPorAnio);

        return edad;
    }

    public Persona crearPersona() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el nombre de la persona:");
        String nombre = scanner.nextLine();

        System.out.println("Por favor, ingrese la fecha de nacimiento:");
        Date fechaNacimiento = leerFechaNacimiento();

        return new Persona(nombre, fechaNacimiento);
    }

    public int calcularEdad(Persona persona) {
        Date fechaActual = new Date();
        return calcularDiferencia(persona.getFechaNacimiento(), fechaActual);
    }

    public boolean menorQue(Persona persona, int edad) {
        int edadPersona = calcularEdad(persona);
        return edadPersona < edad;
    }

    public void mostrarPersona(Persona persona) {
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + persona.getFechaNacimiento());
    }
}
