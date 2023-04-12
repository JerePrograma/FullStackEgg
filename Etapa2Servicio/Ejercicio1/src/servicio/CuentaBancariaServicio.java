package servicio;

import entidad.CuentaBancaria;
import java.util.Scanner;

public class CuentaBancariaServicio {

    private Scanner leer = new Scanner(System.in);

    public CuentaBancaria crearCuenta() {
        System.out.println("Ingrese el número de cuenta:");
        int numeroCuenta = leer.nextInt();
        System.out.println("Ingrese el DNI del cliente:");
        long dniCliente = leer.nextLong();
        System.out.println("Ingrese el saldo inicial:");
        double saldoActual = leer.nextDouble();

        return new CuentaBancaria(numeroCuenta, dniCliente, saldoActual);
    }

    public void depositar(CuentaBancaria cuenta, double cantidad) {
        cuenta.setSaldoActual(cuenta.getSaldoActual() + cantidad);
    }

    public void retirar(CuentaBancaria cuenta, double cantidad) {
        double saldoActual = cuenta.getSaldoActual();
        double retiro = (saldoActual >= cantidad) ? cantidad : saldoActual;
        cuenta.setSaldoActual(saldoActual - retiro);
    }

    public void extraccionRapida(CuentaBancaria cuenta) {
        System.out.println("Se extrajo " + (cuenta.getSaldoActual() * 0.2));
        cuenta.setSaldoActual(cuenta.getSaldoActual() * 0.8);
    }

    public void consultarSaldo(CuentaBancaria cuenta) {
        System.out.println("Saldo actual: " + cuenta.getSaldoActual());
    }

    public void consultarDatos(CuentaBancaria cuenta) {
        System.out.println("Número de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("DNI del cliente: " + cuenta.getDniCliente());
        System.out.println("Saldo actual: " + cuenta.getSaldoActual());
    }
}
