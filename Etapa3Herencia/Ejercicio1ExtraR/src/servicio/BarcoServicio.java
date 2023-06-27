package servicio;

import entidades.Barco;
import entidades.BarcoMotor;
import entidades.Velero;
import entidades.Yate;
import java.util.Scanner;

public class BarcoServicio {

    public Barco crearBarco() {
        Barco barco = new Barco();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        do {
            System.out.println("Ingrese el barco que desea alquilar");
            System.out.println("1- Barco velero");
            System.out.println("2- Barco a motor");
            System.out.println("3- Yate");
            opcion = leer.nextInt();
        } while (opcion != 1 && opcion != 2 && opcion != 3);

        System.out.println("Ingrese la matricula del barco");
        String matricula = leer.next();
        System.out.println("Ingrese la eslora del barco");
        int eslora = leer.nextInt();
        System.out.println("Ingrese el año de fabricación");
        int anioBarco = leer.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de mástiles");
                int mastiles = leer.nextInt();
                Velero velero = new Velero(mastiles, matricula, eslora, anioBarco);
                return velero;
            case 2:
                System.out.println("Ingrese la potencia del barco");
                int potencia = leer.nextInt();
                BarcoMotor barcoMotor = new BarcoMotor(potencia, matricula, eslora, anioBarco);
                return barcoMotor;
            case 3:
                System.out.println("Ingrese la potencia del barco");
                int potenciaYate = leer.nextInt();
                System.out.println("Ingrese la cantidad de camarotes del barco");
                int camarotes = leer.nextInt();
                Yate yate = new Yate(camarotes, potenciaYate, matricula, eslora, anioBarco);
                return yate;
            default:
                return barco;
        }
    }

}
