package entidad;

public class NIF {

    private long dni;
    private char letra;

    public static final char[] LETRAS_DNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    public NIF() {
    }

    public NIF(long dni) {
        this.dni = dni;
        this.letra = calcularLetra(dni);
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    private char calcularLetra(long dni) {
        int resto = (int) (dni % 23);
        return LETRAS_DNI[resto];
    }

    public String mostrar() {
        String dniStr = String.format("%08d", dni);
        return dniStr + "-" + Character.toUpperCase(letra);
    }
}
