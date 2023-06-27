package servicio;

import entidad.Persona;
import java.util.Scanner;

public class PersonaServicio {

    public Persona registrarPersona() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Persona persona = new Persona();
        System.out.println("Ingrese el nombre del asegurado");
        persona.setNombre(leer.next());
        System.out.println("Ingrese el apellido");
        persona.setApellido(leer.next());
        System.out.println("Ingrese el documento");
        persona.setDocumento(leer.nextInt());
        System.out.println("Ingrese el mail");
        persona.setMail(leer.next());
        System.out.println("Ingrese el domicilio");
        persona.setDomicilio(leer.next());
        System.out.println("Ingrese el telefono");
        persona.setTelefono(leer.nextInt());
        return persona;
    }
}
