package entidades;

public class Circulo implements calculosFormas {

    private double radio;
    private double diametro;

    public Circulo() {
    }

    public Circulo(double radio, double diametro) {
        this.radio = radio;
        this.diametro = diametro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    @Override
    public void calcularArea() {
        double area = (PI * Math.pow(radio, 2));
        System.out.println("El área del círculo es: " + area);
    }

    @Override
    public void calcularPerimtro() {
        double perimetro = (PI * diametro);
        System.out.println("El perímitro del círculo es: " + perimetro);
    }

}
