package UT3_PD9;

import java.util.List;
import java.util.Stack;

public class Corchetes {
    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> pila = new Stack<>();
        for (char c : listaDeEntrada) {
            if (c == '{') {
                pila.push(c); // Se agrega a la pila si es una llave de apertura {
            }
            else if (c == '}') {
                if (pila.isEmpty()) {
                    return false; // Devuelve false si no hay  una llave de apertura { para esta llave de cierre }
                }
                pila.pop(); // Saca de la pila, la  llave de apertura que corresponde
            }
        }
        // Si la pila está vacía, la secuencia de corchetes está bien formada
        return pila.isEmpty();
    }
}