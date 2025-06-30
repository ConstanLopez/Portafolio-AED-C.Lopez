package PD6;

import tdas.*;

import java.util.*;

public class Main {
    public static void main (String [] args) {
        /*
        //EJERCICIO 1 MATERIAS
        TVertice matematica01 = new TVertice<>("matematica01");
        TVertice discreta1 = new TVertice<>("discreta1");
        TVertice discreta2 = new TVertice<>("discreta2");
        TVertice discreta3 = new TVertice<>("discreta3");
        TVertice discreta4 = new TVertice<>("discreta4");

        Collection<IVertice> vertices = new ArrayList<>();
        vertices.add(matematica01);
        vertices.add(discreta1);
        vertices.add(discreta2);
        vertices.add(discreta3);
        vertices.add(discreta4);

        Collection<IArista> aristas = new ArrayList<>();
        aristas.add(new TArista("matematica01", "discreta1", 1));
        aristas.add(new TArista("discreta1", "discreta2", 1));
        aristas.add(new TArista("discreta2", "discreta3", 1));
        aristas.add(new TArista("discreta3", "discreta4", 1));

        TGrafoDirigido grafoMaterias = new TGrafoDirigido(vertices, aristas);
        grafoMaterias.desvisitarVertices();
        // Ejecutar el cálculo de mínimo número de semestres
        int cantidadSemestres = grafoMaterias.ordenCursos(matematica01);
        System.out.println("Cantidad mínima de semestres: " + cantidadSemestres);
        */

        //EJERCICIO 2 REDES
        // Creo los  vértices
        TVertice a = new TVertice<>("A");
        TVertice b = new TVertice<>("B");
        TVertice c = new TVertice<>("C");
        TVertice d = new TVertice<>("D");

        // Creo la lista de vértices
        Collection<IVertice> vertices = Arrays.asList(a, b, c, d);

        // Creo las  aristas con probabilidades, como si fueran el costo
        Collection<IArista> aristas = new ArrayList<>();
        aristas.add(new TArista("A", "B", 0.9));
        aristas.add(new TArista("A", "C", 0.5));
        aristas.add(new TArista("B", "C", 0.7));
        aristas.add(new TArista("B", "D", 0.6));
        aristas.add(new TArista("C", "D", 0.95));

        // Creo el  grafo
        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        // Ejecuto Dijkstra modificado
        Map<Comparable, Double> probabilidades = new HashMap<>();
        Map<Comparable, List<Comparable>> caminos = grafo.dijkstraFiabilidadConCaminos("A", probabilidades);

        // Muestro los  resultados
        System.out.println("Probabilidades máximas desde A:");
        for (Map.Entry<Comparable, Double> entrada : probabilidades.entrySet()) {
            System.out.println("A -> " + entrada.getKey() + " = " + entrada.getValue());
        }

        System.out.println("\nCaminos más fiables desde A:");
        for (Map.Entry<Comparable, List<Comparable>> entrada : caminos.entrySet()) {
            System.out.println("A -> " + entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
