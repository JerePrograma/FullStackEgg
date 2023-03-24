package eggprojects.guia5.Ejercicios;

import java.util.Random;

/**Recorrer un vector de N enteros contabilizando cuántos números son de 1 dígito, cuántos de 2 dígitos, etcétera (hasta 5 dígitos).
 */
public class Ejercicio3 {
            public static void main(String[] args) {
        Random random = new Random();

        int[] vec = new int[10];
        //LLENAR VECTOR
        for (int i = 0; i < vec.length; i++) {
            vec[i] = random.nextInt(10000 - 1 + 1);

        }
        //MOSTRAR VECTOR
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " - ");

        }
        // CUANTOS DE 1, 2, 3, 4, 5 DIGITOS
        String numApalabra;
        int unDigt = 0;
        int dosDigt = 0;
        int tresDigt = 0;
        int cuatroDigt = 0;
        int cincoDigt = 0;

        for (int i = 0; i < vec.length; i++) {
            numApalabra = String.valueOf(vec[i]);
            switch (numApalabra.length()) {
                case 1:
                    unDigt++;
                    break;
                case 2:
                    dosDigt += 1;
                    break;
                case 3:
                    tresDigt += 1;
                    break;
                case 4:
                    cuatroDigt += 1;
                    break;
                case 5:
                    cincoDigt += 1;
                    break;

            }

        }
        System.out.println("");
        System.out.println("Un Digito: " + unDigt);
        System.out.println("dos Digito: " + dosDigt);
        System.out.println("tres Digito: " + tresDigt);
        System.out.println("cuatro Digito: " + cuatroDigt);
        System.out.println("cinco Digito: " + cincoDigt);

    }
}
