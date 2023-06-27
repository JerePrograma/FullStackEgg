package servicio;

import entidad.Vehiculo;
import enums.Color;
import enums.Tipo;
import java.util.Scanner;

public class VehiculoServicio {

    public Vehiculo registrarVehiculo() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Vehiculo vehiculo = new Vehiculo();
        System.out.println("Ingrese la marca del vehiculo");
        vehiculo.setMarca(leer.next());
        System.out.println("Ingrese el modelo");
        vehiculo.setModelo(leer.next());
        System.out.println("Ingrese el año");
        vehiculo.setAnio(leer.nextInt());
        System.out.println("Ingrese el numero de motor");
        vehiculo.setNumeroMotor(leer.nextInt());
        System.out.println("Ingrese el chasis");
        vehiculo.setChasis(leer.next());
        System.out.println("Elija el color");
        System.out.println("1- ROJO");
        System.out.println("2- VERDE");
        System.out.println("3- BLANCO");
        System.out.println("4- AMARILLO");
        int color = leer.nextInt() - 1;
        vehiculo.setColor(Color.values()[color]);
        System.out.println("Elija el tipo de vehiculo");
        System.out.println("1- SEDAN");
        System.out.println("2- CAMIONETA");
        System.out.println("3- TRESPUERTAS");
        int tipo = leer.nextInt();
        vehiculo.setTipo(Tipo.values()[tipo]);
        return vehiculo;
    }
}
