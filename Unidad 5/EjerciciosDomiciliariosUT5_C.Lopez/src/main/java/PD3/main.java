package PD3;

import tdas.TArbolTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        TArbolTrie arbolTrie = new TArbolTrie();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/PD3/palabrasIndice.txt"))) {
            String palabra;
            while ((palabra = br.readLine()) != null) {
                palabra = palabra.toLowerCase().replaceAll("[^a-z]", "");
                if (!palabra.isEmpty()) {
                    arbolTrie.insertar(palabra);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo del índice: " + e.getMessage());
        }
        arbolTrie.indizarLibro("src/main/java/PD3/libro.txt");
        System.out.println("Índice:\n");
        arbolTrie.imprimirIndice();
    }
}

