package PD4;

import tdas.IVertice;
import tdas.TCaminos;
import tdas.TGrafoDirigido;
import tdas.UtilGrafos;

public class Main {
    public static void main(String[] args) {
        // Cargo el grafo, con  los archivos dados
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/PD4/aeropuertos_2.txt", "src/main/java/PD4/conexiones_2.txt",false, TGrafoDirigido.class);
        // Busco los vertices según su etiqueta
        IVertice florianopolis = grafo.buscarVertice("Florianopolis");
        IVertice rio = grafo.buscarVertice("Rio_de_Janeiro");

        Comparable etiquetaFlorianopolis = florianopolis.getEtiqueta();
        Comparable etiquetario = rio.getEtiqueta();

        // Imprimo todos los caminos de Florianopolis a Rio
        TCaminos camino = grafo.todosLosCaminos(etiquetaFlorianopolis,etiquetario);
        camino.imprimirCaminosConsola();
    }
}
