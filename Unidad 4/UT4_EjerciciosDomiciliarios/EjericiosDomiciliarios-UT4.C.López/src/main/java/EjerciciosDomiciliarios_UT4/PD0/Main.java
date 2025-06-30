package EjerciciosDomiciliarios_UT4.PD0;

import uy.edu.ucu.aed.tdas.TArbolBB;
import uy.edu.ucu.aed.tdas.TElementoAB;

public class Main {
    public static void main(String[] args) {
        TElementoAB<String> nodo2 = new TElementoAB<>("a", "2");
        TElementoAB<String> nodo5 = new TElementoAB<>("b", "5");
        TElementoAB<String> nodo3 = new TElementoAB<>("c", "3");

        TElementoAB<String> nodoMul = new TElementoAB<>("m", "*");
        nodoMul.setHijoIzq(nodo2);
        nodoMul.setHijoDer(nodo5);

        TElementoAB<String> nodoSuma = new TElementoAB<>("r", "+");
        nodoSuma.setHijoIzq(nodoMul);
        nodoSuma.setHijoDer(nodo3);

        TArbolBB<String> arbol = new TArbolBB<>();
        arbol.setRaiz(nodoSuma);

        double resultado = arbol.evaluarExpresion();
        System.out.println("Resultado: " + resultado);
    }
}