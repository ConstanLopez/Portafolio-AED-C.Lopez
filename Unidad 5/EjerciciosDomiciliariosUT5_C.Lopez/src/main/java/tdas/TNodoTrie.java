package tdas;

import interfaces.INodoTrie;

import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas = null;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
                
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s+(char)(c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    @Override
    public void imprimir() {
        
        imprimir("", this);
    }
    
    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodoActual = this;
        for(int c = 0; c < s.length(); c++){
            int indice = s.charAt(c) - 'a';
            TNodoTrie unHijo = nodoActual.hijos[indice];
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
        TNodoTrie nodoActual = this; //Creo nodoActual para ir recorriendo nodos
        for(int c = 0; c < s.length(); c++){ //Recorro el largo del String s
            int indice = s.charAt(c) - 'a'; //Obtengo el indice c
            contador++; //Comparo, por lo que incremento el contador

            if(nodoActual.hijos[indice] == null){ //Si nodo actual no tiene hijos con ese indice
                System.out.println("La clave no está en el árbol."); //Devuelvo 0 ya que la clave no esta en el arbol
                return 0;
            }
            nodoActual = nodoActual.hijos[indice]; //Actualizo nodoActual para continuar recorriendo los nodos
        }
        System.out.println("La clave está en el árbol, se realizaron "+ contador + " comparaciones.");
        return contador; //Devuelvo el contador con la cantidad de busquedas realizadas
    }

    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
     // implementar
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoActual = buscarNodoTrie(prefijo);

        for(TNodoTrie hijo: nodoActual.hijos){
            if(esPalabra){
                palabras.add(prefijo + this);
            }
            hijo.predecir(prefijo + hijo, palabras);
        }

        for(String palabra: palabras){
            System.out.println(palabra);
        }
    }
    public void registrarPagina(String palabra, int pagina) {
        TNodoTrie nodo = this;
        for (char ch : palabra.toCharArray()) {
            int i = ch - 'a';
            if (i < 0 || i >= CANT_CHR_ABECEDARIO || nodo.hijos[i] == null) return;
            nodo = nodo.hijos[i];
        }
        if (nodo.esPalabra) {
            if (nodo.paginas == null) {
                nodo.paginas = new LinkedList<>();
            }
            if (!nodo.paginas.contains(pagina)) {
                nodo.paginas.add(pagina);
            }
        }
    }
    public void imprimirIndice(String prefijo) {
        if (esPalabra && paginas != null) {
            System.out.print(prefijo + ": ");
            for (int p : paginas) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < hijos.length; i++) {
            if (hijos[i] != null) {
                hijos[i].imprimirIndice(prefijo + (char)(i + 'a'));
            }
        }
    }

    public int buscarEnIndice(String palabra) {
        TNodoTrie nodoActual = this;
        int comparaciones = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char ch = palabra.charAt(i);
            int indice = ch - 'a';
            comparaciones++;

            if (indice < 0 || indice >= CANT_CHR_ABECEDARIO || nodoActual.hijos[indice] == null) {
                System.out.println("La palabra"+ " " + palabra + " " + " no está en el índice.");
                System.out.println("Comparaciones realizadas: " + comparaciones);
                return comparaciones;
            }

            nodoActual = nodoActual.hijos[indice];
        }

        if (nodoActual.esPalabra) {
            System.out.print(palabra + ": ");
            if (nodoActual.paginas != null && !nodoActual.paginas.isEmpty()) {
                for (int p : nodoActual.paginas) {
                    System.out.print(p + " ");
                }
                System.out.println();
            } else {
                System.out.println("(no aparece la palabra");
            }
        } else {
            System.out.println("La palabra"+" " + palabra + " "+ "no está en el índice.");
        }

        System.out.println("Comparaciones realizadas: " + comparaciones);
        return comparaciones;
    }
}
