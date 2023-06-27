package servicio;

import entidad.Alquiler;
import entidad.BarcoAMotor;
import entidad.BarcoVelero;
import entidad.BarcoYate;
import java.util.Date;
import java.util.Scanner;

public class AlquilerService implements AlquierInter {

    @Override
    public void crearAlquiler(Alquiler alquiler) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese su nombre");
        alquiler.setNombre(leer.next());
        System.out.println("Ingrese su documento");
        alquiler.setDocumento(leer.nextInt());
        System.out.println("Ingrese la fecha de alquiler (dd/mm/aaaa");
        String fecha = leer.next();
        alquiler.setFechaAlquiler(new Date(Integer.parseInt(fecha.substring(6, 10)) - 1900, Integer.parseInt(fecha.substring(3, 4)) - 1, Integer.parseInt(fecha.substring(0, 2))));
        System.out.println("Ingrese la fecha de devolucion (dd/mm/aaaa");
        fecha = leer.next();
        alquiler.setDevolucion(new Date(Integer.parseInt(fecha.substring(6, 10)) - 1900, Integer.parseInt(fecha.substring(3, 4)) - 1, Integer.parseInt(fecha.substring(0, 2))));
        System.out.println("Ingrese la posición del amarre (1 a 10)");
        alquiler.setPosicionAmarre(leer.nextInt());
        System.out.println("Elija el barco que desea alquilar");
        System.out.println("1- Barco Velero");
        System.out.println("2- Barco a Motor");
        System.out.println("3- Yate");
        int opcion = leer.nextInt();
        System.out.println("Ingrese la matricula");
        String matricula = leer.next();
        System.out.println("Ingrese la eslora");
        int eslora = leer.nextInt();
        System.out.println("Ingrese la año de fabricacion");
        int anio = leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese la cantidad de mastiles");
                int mastiles = leer.nextInt();
                alquiler.setBarco(new BarcoVelero(mastiles, matricula, eslora, anio));
                break;
            case 2:
                System.out.println("La potencia del motor");
                int potenciaMotor = leer.nextInt();
                alquiler.setBarco(new BarcoAMotor(potenciaMotor, matricula, eslora, anio));
                break;
            case 3:
                System.out.println("La potencia del motor");
                potenciaMotor = leer.nextInt();
                System.out.println("La cantidad de camarotes");
                int cantidadCamarotes = leer.nextInt();
                alquiler.setBarco(new BarcoYate(cantidadCamarotes, potenciaMotor, matricula, eslora, anio));
                break;
        }

        System.out.println("El alquiler del barco es un total de " + (calculoAlquiler(alquiler)));

    }

    @Override
    public double calculoAlquiler(Alquiler alquiler) {
        int dias = (int) diasOcupacion(alquiler);
        double costoAlquiler;
        System.out.println("El barco se alquiló por " + dias + " dias");
        if (alquiler.getBarco() instanceof BarcoYate) {
            BarcoYate barcoy = (BarcoYate) alquiler.getBarco();
            costoAlquiler = dias * (barcoy.getEslora() + barcoy.getNumeroCamarotes() + barcoy.getPotenciaMotor()) * 10;
        } else if (alquiler.getBarco() instanceof BarcoVelero) {
            BarcoVelero barcov = (BarcoVelero) alquiler.getBarco();
            costoAlquiler = dias * (barcov.getEslora() + barcov.getCantidadMastiles()) * 10;
        } else if (alquiler.getBarco() instanceof BarcoAMotor) {
            BarcoAMotor barcom = (BarcoAMotor) alquiler.getBarco();
            costoAlquiler = dias * (barcom.getEslora() + barcom.getPotenciaMotor()) * 10;
        } else {
            System.out.println("El barco está mal instanciado :|");
            costoAlquiler = 0;
        }
        return costoAlquiler;
    }

    @Override
    public double diasOcupacion(Alquiler alquiler) {
        return ((alquiler.getDevolucion().getTime() - alquiler.getFechaAlquiler().getTime()) / (24 * 60 * 60 * 1000));

    }
}
