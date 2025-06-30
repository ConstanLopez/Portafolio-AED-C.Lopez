package UT1_PD5;

public class Ejercicio_1_ContadorPalabras {
    public String contarPalabras(String frase) {
        int cuentaPalabras = 0;
        int cuentaVocales = 0;
        int cuentaConsonantes = 0;

        frase = frase.toUpperCase();
        boolean enPalabra = false;

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (esVocal(c)) {
                cuentaVocales++;
                enPalabra = true;
            } else if (esConsonante(c)) {
                cuentaConsonantes++;
                enPalabra = true;
            } else if (c == ' ') {
                if (enPalabra) {
                    cuentaPalabras++;
                    enPalabra = false;
                }
            }
        }

        if (enPalabra) {
            cuentaPalabras++;
        }

        return "Palabras: " + cuentaPalabras + " Vocales: " + cuentaVocales + " Consonantes: " + cuentaConsonantes;
    }

    private boolean esVocal(char c) {
        for (Vocales v : Vocales.values()) {
            if (v.getLetra() == c) return true;
        }
        return false;
    }

    private boolean esConsonante(char c) {
        for (Consonantes cons : Consonantes.values()) {
            if (cons.getLetra() == c) return true;
        }
        return false;
    }
}
