package entidad;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private int documento;
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public String getInfoPerro() {
        String info = "";
        if (perro != null) {
            info += "Nombre del perro: " + perro.getNombre() + "\n";
            info += "Raza del perro: " + perro.getRaza() + "\n";
            info += "Edad del perro: " + perro.getEdad() + "\n";
            info += "Tamaño del perro: " + perro.getTamaño() + "\n";
        } else {
            info += "No tiene perro asignado.";
        }
        return info;
    }

    @Override
    public String toString() {
        return "Persona: \n" + "Nombre=" + nombre + "\nApellido=" + apellido + "\nEdad=" + edad + "\nDocumento=" + documento;
    }

}
