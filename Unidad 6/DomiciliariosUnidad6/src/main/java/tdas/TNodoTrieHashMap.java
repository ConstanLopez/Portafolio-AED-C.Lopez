package tdas;

import interfaces.INodoTrie;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TNodoTrieHashMap implements INodoTrie, Serializable {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            char indice = unaPalabra.charAt(c);
            if (nodo.hijos.get(indice) == null) {
                nodo.hijos.put(indice,new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(indice);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (Map.Entry<Character, TNodoTrieHashMap> par : nodo.hijos.entrySet()) {
                char letra = par.getKey();
                TNodoTrieHashMap hijo = par.getValue();
                imprimir(s + letra, hijo);
            }
        }
    }

    @Override
    public void imprimir() {

        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodoActual = this;
        for(int c = 0; c < s.length(); c++){
            char indice = s.charAt(c);
            TNodoTrieHashMap unHijo = nodoActual.hijos.get(indice);
            if(unHijo == null){
                return null;
            }else {
                nodoActual = unHijo;
            }
        }if(nodoActual.esPalabra){
            return nodoActual;
        }else {
            return null;
        }
    }

    @Override
    public int buscar(String s) {
        int contador = 0; //Creo contador para ir sumando las busquedas
        TNodoTrieHashMap nodoActual = this; //Creo nodoActual para ir recorriendo nodos
        for(int c = 0; c < s.length(); c++){ //Recorro el largo del String s
            char letra = s.charAt(c); //Obtengo la clave del hashmap directamente
            contador++; //Comparo, por lo que incremento el contador

            if(nodoActual.hijos.get(letra) == null){ //Si nodo actual no tiene hijos con ese indice
                System.out.println("La clave no está en el árbol."); //Devuelvo 0 ya que la clave no esta en el arbol
                return 0;
            }
            nodoActual = nodoActual.hijos.get(letra); //Actualizo nodoActual para continuar recorriendo los nodos
        }
        System.out.println("La clave está en el árbol, se realizaron "+ contador + " comparaciones.");
        return contador; //Devuelvo el contador con la cantidad de busquedas realizadas
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        // implementar
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodoActual = buscarNodoTrie(prefijo);

        for(Map.Entry<Character , TNodoTrieHashMap> entrada : nodoActual.hijos.entrySet()){
            Character letra =entrada.getKey();
            TNodoTrieHashMap hijo= entrada.getValue();
            if(hijo.esPalabra){
                palabras.add(prefijo + letra);
            }
            hijo.predecir(prefijo + letra, palabras);
        }

        for(String palabra: palabras){
            System.out.println(palabra);
        }
    }
}
