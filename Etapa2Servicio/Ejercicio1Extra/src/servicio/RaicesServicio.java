package servicio;

import entidad.Raices;

public class RaicesServicio {

    public static double getDiscriminante(Raices raices) {
        return Math.pow(raices.getB(), 2) - (4 * raices.getA() * raices.getC());
    }

    public static boolean tieneRaices(Raices raices) {
        return getDiscriminante(raices) >= 0;
    }

    public static boolean tieneRaiz(Raices raices) {
        return getDiscriminante(raices) == 0;
    }

    public static void obtenerRaices(Raices raices) {
        if (tieneRaices(raices)) {
            double discriminante = Math.sqrt(getDiscriminante(raices));
            double raiz1 = (-raices.getB() + discriminante) / (2 * raices.getA());
            double raiz2 = (-raices.getB() - discriminante) / (2 * raices.getA());
            System.out.println("Las dos raíces son: " + raiz1 + " y " + raiz2);
        }
    }

    public static void obtenerRaiz(Raices raices) {
        if (tieneRaiz(raices)) {
            double raiz = -raices.getB() / (2 * raices.getA());
            System.out.println("La única raíz es: " + raiz);
        }
    }

    public static void calcular(Raices raices) {
        if (tieneRaices(raices)) {
            obtenerRaices(raices);
        } else if (tieneRaiz(raices)) {
            obtenerRaiz(raices);
        } else {
            System.out.println("No hay solución real para esta ecuación.");
        }
    }
}
