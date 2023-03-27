package entidad;

import java.util.Scanner;

/*Crear una clase Rectángulo que modele rectángulos por medio de un atributo privado base y un atributo privado altura. 
La clase incluirá un método para crear el rectángulo con los datos del Rectángulo dados por el usuario. 
También incluirá un método para calcular la superficie del rectángulo y un método para calcular el perímetro del rectángulo. 
Por último, tendremos un método que dibujará el rectángulo mediante asteriscos usando la base y la altura. 
Se deberán además definir los métodos getters, setters y constructores correspondientes.
Superficie = base * altura / Perímetro = (base + altura) * 2. */
public class Rectangulo {

    private int base;
    private int altura;

    public Rectangulo() {
    }

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void crearRectangulo() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese la base");
        this.base = (leer.nextInt());
        System.out.println("Ingrese la altura");
        this.altura = (leer.nextInt());
    }

    public void calcularSuperficie() {
        int superficie = this.base * this.altura;
        System.out.println("La superficie del rectángulo es: " + superficie);
    }

    public void calcularPerimetro() {
        int perimetro = (this.base + this.altura) * 2;
        System.out.println("La superficie del rectángulo es: " + perimetro);
    }
}
