package eggprojects.Ayudas;

import java.util.Scanner;

public class ASd {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int cont = 0;
        int suma = 0;

        int num;
        do {
            System.out.println("Ingrese números: ");
            num = leer.nextInt();

            if (num > 0 && num <= 20) {
                cont++;
                suma += num;
            } else {
                num = 0;

            }
        } while (num == 0);
        System.out.println("se ha capturado el cero");
        System.out.println("La suma de los números es " + suma);
        System.out.println("Se ingresaron " + cont + " numeros");
    }
}
