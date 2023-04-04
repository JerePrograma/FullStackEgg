package main;

import entidad.Cuenta;

public class Main {

    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta(1000, "Jeremias");

        cuenta.retirar_dinero();
        cuenta.retirar_dinero();
    }
}
