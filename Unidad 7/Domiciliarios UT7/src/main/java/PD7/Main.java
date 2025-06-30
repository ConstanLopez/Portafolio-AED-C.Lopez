package PD7;

import tdas.*;
import utils.ManejadorArchivosGenerico;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Creo mapa de vértices
        HashMap<Comparable, IVertice> verticesGrafo = new HashMap<>();
        String[] lineasTareas = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/tareas.txt", false);

        for (String linea : lineasTareas) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                String nombreTarea = partes[0].trim();
                verticesGrafo.put(nombreTarea, new TVertice(nombreTarea));
            } else {
                System.out.println("Línea inválida en tareas.txt: " + linea);
            }
        }

        // Creo lista de aristas
        LinkedList<IArista> aristas = new LinkedList<>();
        String[] lineasPrecedencias = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/precedencias.txt", false);

        for (String linea : lineasPrecedencias) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                String desde = partes[0].trim();
                String hasta = partes[1].trim();
                aristas.add(new TArista(desde, hasta, 0)); // Se ignora el tercer campo
            } else {
                System.out.println("Línea inválida en precedencias.txt: " + linea);
            }
        }

        // Creo el grafo
        TGrafoDirigido grafo = new TGrafoDirigido(verticesGrafo.values(), aristas);

        // Obtengo el orden parcial con el metodo de TGrafoDirigido
        LinkedList<IVertice> orden = grafo.ordenParcial();


        // Genero   el  archivo "orden.txt" usando el Manejador de Archivos
        LinkedList<String> salida = new LinkedList<>();
        for (IVertice v : orden) {
            salida.add(v.getEtiqueta().toString());
        }

        ManejadorArchivosGenerico.escribirArchivo("src/main/java/PD7/orden.txt", salida.toArray(new String[0]));
    }
}

