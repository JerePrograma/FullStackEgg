package entidad;

import java.util.Scanner;

/*Crea una clase "Cuenta" que tenga atributos como "saldo" y "titular". 
Luego, crea un método "retirar_dinero" que permita retirar una cantidad de dinero del saldo de la cuenta. 
Asegúrate de que el saldo nunca sea negativo después de realizar una transacción de retiro. */
public class Cuenta {

    private double saldo;
    private String titular;

    public Cuenta() {
    }

    public Cuenta(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    /*Luego, crea un método "retirar_dinero" que permita retirar una cantidad de dinero del saldo de la cuenta. 
Asegúrate de que el saldo nunca sea negativo después de realizar una transacción de retiro. */
    public void retirar_dinero() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese la cantidad de dinero que desea retirar");
        double dineroARetirar = leer.nextInt();
        if (dineroARetirar <= this.saldo) {
            this.saldo -= dineroARetirar;
            System.out.println("Se retiró " + dineroARetirar);
            System.out.println("Su saldo actual es de " + this.saldo);
        } else {
            System.out.println("Se retiró " + saldo + " y la cuenta quedó en 0");
        }
    }
}
