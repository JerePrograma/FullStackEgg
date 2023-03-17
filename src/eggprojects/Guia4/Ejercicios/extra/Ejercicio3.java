/*3. Diseñar un procedimiento que permita convertir coordenadas polares (radio, ángulo) 
en cartesianas (x,y). NOTA: x=radio*cos(ángulo) e y=radio*sen(ángulo). */
package eggprojects.Guia4.Ejercicios.extra;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingresa el radio y el ángulo");
        double radio = leer.nextDouble();
        double angulo = leer.nextDouble();

        double x = 0;
        double y = 0;

        char palabra = leer.next().charAt(0);
        System.out.println(palabra);
    }

    public static void polarACartesiano(double radio, double angulo, double x, double y) {
        double anguloEnRadianes = Math.toRadians(angulo);
        x = radio * Math.cos(anguloEnRadianes);
        y = radio * Math.sin(anguloEnRadianes);
    }
}
