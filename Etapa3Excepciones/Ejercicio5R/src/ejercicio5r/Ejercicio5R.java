package ejercicio5r;

import java.util.Random;
import java.util.Scanner;
//Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora
//debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo. Para
//ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
//número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. Cuando
//consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
//ha intentado adivinar el número. Si el usuario introduce algo que no es un número, se debe
//controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el
//carácter fallido como un intento.

public class Ejercicio5R {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int ran = random.nextInt(500) + 1;
        System.out.println(ran);
        int contador = 0;
        do {
            try {
                System.out.println("Ingrese un número entre 1 y 500");
                int adivinar = leer.nextInt();
                if (adivinar == ran) {
                    System.out.println("Adivinaste!!");
                    break;
                } else if (adivinar < ran) {
                    System.out.println("El número es mayor");
                } else {
                    System.out.println("El número es menor");
                }
            } catch (Exception e) {
                System.out.println("Ojo! No pusiste un número, intentalo devuelta");
                leer.next();
            }finally{
                contador++;
            }
        } while (true);
        System.out.println("Se intentó adivinar " + contador + " veces");
    }

}
