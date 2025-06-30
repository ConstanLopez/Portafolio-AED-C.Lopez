package tdas;

import interfaces.IArbolTrie;

import java.io.Serializable;
import java.util.LinkedList;

public class TArbolArrayy implements IArbolTrie, Serializable {
    private TNodoTrieArray raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieArray();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.buscar(palabra);
        }
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> unaLista = new LinkedList<>();
        if (raiz != null) {
            raiz.predecir(prefijo, unaLista);
        }
        return unaLista;
    }


}


