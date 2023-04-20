package servicio;

import entidad.ParDeNumeros;

public class ParDeNumerosService {

    public void mostrarValores(ParDeNumeros par) {
        System.out.println("Número 1: " + par.getNumero1());
        System.out.println("Número 2: " + par.getNumero2());
    }

    public double devolverMayor(ParDeNumeros par) {
        return Math.max(par.getNumero1(), par.getNumero2());
    }

    public double calcularPotencia(ParDeNumeros par) {
        double mayor = devolverMayor(par);
        double menor = (mayor == par.getNumero1()) ? par.getNumero2() : par.getNumero1();
        return Math.pow(Math.round(mayor), Math.round(menor));
    }

    public double calcularRaiz(ParDeNumeros par) {
        double menor = Math.min(par.getNumero1(), par.getNumero2());
        return Math.sqrt(Math.abs(menor));
    }
}
