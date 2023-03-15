/*Una obra social tiene tres clases de socios:
Los socios tipo ‘A’ abonan una cuota mayor, pero tienen un 50% de descuento en todos los tipos de tratamientos.
Los socios tipo ‘B’ abonan una cuota moderada y tienen un 35% de descuento para los mismos tratamientos que los socios del tipo A.
Los socios que menos aportan, los de tipo ‘C’, no reciben descuentos sobre dichos tratamientos.
Solicite una letra (carácter) que representa la clase de un socio, y luego un valor real que represente el costo del tratamiento (previo al descuento)
y determine el importe en efectivo a pagar por dicho socio.*/
package eggprojects.Guia3.Extras;

import java.util.Scanner;

public class Ejercicio05 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        char tipoSocio;
        do {
            System.out.println("Ingrese el tipo de socio");
            tipoSocio = leer.next().charAt(0);
        } while (tipoSocio != 'A' && tipoSocio != 'B' && tipoSocio != 'C');

        int cuota = 0;
        System.out.println("Ingrese el costo del tratamiento");
        int importe = leer.nextInt();
        int importeTotal;
        switch (tipoSocio) {
            case 'A':
                cuota = 500;
                importe *= 0.5;
                break;
            case 'B':
                cuota = 250;
                importe *= 0.65;
                break;
            case 'C':
                cuota = 100;
                break;
        }
        importeTotal = cuota + importe;
        System.out.println("El costo de tratamiento para el socio de tipo " + tipoSocio + " es de " + importeTotal);
    }
}
