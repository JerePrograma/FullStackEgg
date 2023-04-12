package servicio;

import entidad.Cafetera;

public class CafeteraServicio {

    public void llenarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(cafetera.getCapacidadMaxima());
    }

    public void servirTaza(Cafetera cafetera, int taza) {
        if (cafetera.getCantidadActual() >= taza) {
            cafetera.setCantidadActual(cafetera.getCantidadActual() - taza);
            System.out.println("La taza se llenó completamente.");
        } else {
            System.out.printf("La taza no se pudo llenar completamente. Quedó con %d ml de café.\n", cafetera.getCantidadActual());
            cafetera.setCantidadActual(0);
        }
    }

    public void vaciarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(0);
    }

    public void agregarCafe(Cafetera cafetera, int cantidadCafe) {
        int nuevaCantidad = cafetera.getCantidadActual() + cantidadCafe;
        if (nuevaCantidad > cafetera.getCapacidadMaxima()) {
            cafetera.setCantidadActual(cafetera.getCapacidadMaxima());
        } else {
            cafetera.setCantidadActual(nuevaCantidad);
        }
    }
}
