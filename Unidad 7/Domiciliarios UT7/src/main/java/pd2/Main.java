package pd2;

import tdas.TGrafoDirigido;
import tdas.UtilGrafos;
import utils.ManejadorArchivosGenerico;

public class Main {
    public static void main(String[] args){
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/pd2/Ciudades(Aristas).txt","src/main/java/pd2/Aristas.txt", false,TGrafoDirigido.class);
        Double[] [] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        //EJERCICIO 1
        //UtilGrafos.imprimirMatrizMejorado(matriz,grafo.getVertices(),"Conexiones");

        //EJERCICIO 2
        Double [] [] matrizFloyd = grafo.floyd(matriz);
        //UtilGrafos.imprimirMatrizMejorado(matrizFloyd,grafo.getVertices()," floyd");

        //EJERCICIO 3
        Comparable excentricidadMontevideo = grafo.obtenerExcentricidad("Montevideo",matrizFloyd);
        Comparable centroGrafo = grafo.centroDelGrafo(matrizFloyd,  grafo.getEtiquetasOrdenado());

        String[] Salida = new String[2];

        Salida [0] = excentricidadMontevideo.toString();
        Salida [1] = centroGrafo.toString();
        UtilGrafos.imprimirMatrizMejorado(matrizFloyd,grafo.getVertices(),"Excentricidad");
        ManejadorArchivosGenerico.escribirArchivo("src/main/java/pd2/orden.txt", Salida);



    }
}
