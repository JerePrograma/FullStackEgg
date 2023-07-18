package servicio;

import entidad.Persona;
import java.util.Scanner;

public class PersonaServicio {

    public boolean esMayorDeEdad(Persona persona) throws NullPointerException {
        if (persona == null) {
            throw new NullPointerException("No se puede calcular la edad");
        }
        return persona.getEdad() >= 18;
    }

    public void crearPersona(Persona persona) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad:");
        int edad = scanner.nextInt();

        System.out.println("Ingrese el sexo (H - hombre, M - mujer, O - otro):");
        char sexo = scanner.next().toUpperCase().charAt(0);

        while (sexo != 'H' && sexo != 'M' && sexo != 'O') {
            System.out.println("Sexo inválido, ingrese nuevamente (H - hombre, M - mujer, O - otro):");
            sexo = scanner.next().toUpperCase().charAt(0);
        }

        System.out.println("Ingrese el peso (en kg):");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese la altura (en metros):");
        double altura = scanner.nextDouble();
        persona = new Persona(nombre, edad, sexo, peso, altura);
    }

    public int calcularIMC(Persona persona) throws NullPointerException {
        if (persona == null) {
            throw new NullPointerException("No se puede calcular el IMC");
        }
        double imc = persona.getPeso() / Math.pow(persona.getAltura(), 2);

        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }
}
