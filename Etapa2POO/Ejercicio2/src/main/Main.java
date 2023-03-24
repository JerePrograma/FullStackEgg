package main;

import entidad.Circunferencia;

/*Declarar una clase llamada Circunferencia que tenga como atributo privado el radio de tipo real. 
A continuación, se deben crear los siguientes métodos:
Método constructor que inicialice el radio pasado como parámetro.
Métodos get y set para el atributo radio de la clase Circunferencia.
Método para crearCircunferencia(): que le pide el radio y lo guarda  en el atributo del objeto.
Método area(): para calcular el área de la circunferencia (Area=〖π*radio〗^2).
Método perimetro(): para calcular el perímetro (Perimetro=2*π*radio).*/
public class Main {
    public static void main(String[] args) {
        Circunferencia circulo1 = new Circunferencia();
        
        
        Circunferencia.crearCircunferencia(circulo1);
        Circunferencia.area(circulo1);
        Circunferencia.perimetro(circulo1);
        
        
    }
}
