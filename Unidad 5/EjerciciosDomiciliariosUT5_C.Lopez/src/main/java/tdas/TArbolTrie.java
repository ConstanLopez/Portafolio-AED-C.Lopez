package tdas;


import interfaces.IArbolTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        palabra = palabra.toLowerCase();
        if (raiz == null) {
            raiz = new TNodoTrie();
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
        if(raiz == null){
            return 0;
        }
        else {
            return raiz.buscar(palabra);
        }
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> unaLista = new LinkedList<>();
        if(raiz != null){
            raiz.predecir(prefijo, unaLista);
        }
        return unaLista;
    }
    public void indizarLibro(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                int pagina = (numeroLinea - 1) / 50 + 1;

                linea = linea.toLowerCase().replaceAll("[^a-z]", " ");
                String[] palabras = linea.split("\\s+");

                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        if (raiz != null) {
                            raiz.registrarPagina(palabra, pagina);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el libro: " + e.getMessage());
        }
    }
    public void imprimirIndice() {
        if (raiz != null) {
            raiz.imprimirIndice("");
        }
    }
}
