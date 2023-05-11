package servicio;

import entidad.Cadena;

public class CadenaServicio {

    public void mostrarVocales(Cadena frase) {
        int cont = 0;
        for (int i = 0; i < frase.getLongitudFrase(); i++) {
            switch (frase.getFrase().substring(i, i + 1).toLowerCase()) {
                case "a":
                case "e":
                case "i":
                case "o":
                case "u":
                    cont++;
            }
        }
        System.out.println("La cantidad de vocales son: " + cont);
    }

    public void invertirFrase(Cadena frase) {
        String a = "";
        for (int i = frase.getLongitudFrase(); i > 0; i--) {

            a += frase.getFrase().substring(frase.getLongitudFrase(), frase.getLongitudFrase() - i);

        }

        System.out.println(a + frase.getFrase().substring(0, 1));
    }

}
