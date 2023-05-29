package entidad;

public class Sala {

    private Asiento[][] asientos;
//8 A X | 8 B X | 8 C X | 8 D   | 8 E X | 8 F X
//7 A X | 7 B X | 7 C X | 7 D X | 7 E   | 7 F X
//6 A X | 6 B X | 6 C   | 6 D X | 6 E X | 6 F
//5 A X | 5 B X | 5 C X | 5 D X | 5 E X | 5 F X
//4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
//3 A X | 3 B X | 3 C X | 3 D   | 3 E X | 3 F X
//2 A X | 2 B   | 2 C X | 2 D X | 2 E X | 2 F
//1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X

    public Sala() {
        this.asientos = new Asiento[8][6];
        for (int i = 0; i < asientos.length; i++) {
            int contador = 0;
            for (int j = 0; j < asientos[0].length; j++) {
                String letraJ = "";
                switch (j) {
                    case 0:
                        letraJ = "A";
                        break;
                    case 1:
                        letraJ = "B";
                        break;
                    case 2:
                        letraJ = "C";
                        break;
                    case 3:
                        letraJ = "D";
                        break;
                    case 4:
                        letraJ = "E";
                        break;
                    case 5:
                        letraJ = "F";
                        break;
                }
                Asiento asiento = new Asiento();
                asiento.setNombre(" " + (8 - i) + " " + letraJ + " ");
                asiento.setOcupado(false);
                asientos[i][j] = asiento;
            }
        }
    }

    public Sala(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

}
