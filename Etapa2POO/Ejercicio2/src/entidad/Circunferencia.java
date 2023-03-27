package entidad;

import java.util.Scanner;

/*Declarar una clase llamada Circunferencia que tenga como atributo privado el radio de tipo real. 
A continuación, se deben crear los siguientes métodos:
Método constructor que inicialice el radio pasado como parámetro.
Métodos get y set para el atributo radio de la clase Circunferencia.
Método para crearCircunferencia(): que le pide el radio y lo guarda en el atributo del objeto.
Método area(): para calcular el área de la circunferencia (Area = π*〖radio^2〗).
Método perimetro(): para calcular el perímetro (Perimetro = 2*π*radio).*/
public class Circunferencia {

    private double radio;

    public Circunferencia() {
    }

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void crearCircunferencia() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el radio del objeto");
        this.radio = (leer.nextDouble());
    }

    public void area() {
        double area = Math.PI * (Math.pow(this.radio, 2));
        System.out.println("El área del círculo es: " + area);
    }

    public void perimetro() {
        double perimetro = Math.PI * this.radio * 2;
        System.out.println("El área del círculo es: " + perimetro);
    }
}
