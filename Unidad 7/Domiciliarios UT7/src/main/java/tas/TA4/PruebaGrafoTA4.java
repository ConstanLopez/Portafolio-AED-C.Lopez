package tas.TA4;

import tdas.IVertice;
import tdas.TGrafoDirigido;
import tdas.UtilGrafos;

import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafoTA4 {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("C:\\Users\\Estudiante UCU\\Documents\\AED\\ut07-aed2025-equipo-9\\src\\main\\java\\uy\\edu\\ucu\\aed\\archivos\\archivosTA4\\aeropuertos_1.txt",
                "C:\\Users\\Estudiante UCU\\Documents\\AED\\ut07-aed2025-equipo-9\\src\\main\\java\\uy\\edu\\ucu\\aed\\archivos\\archivosTA4\\conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd(matriz);
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
//        for (int i = 0; i < etiquetasarray.length; i++) {
//            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
//        }
//        System.out.println();
//        System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        // imprimir etiquetas del bpf de todo el grafo....
        LinkedList<IVertice> recorrido = gd.bpf();
        for (IVertice vertice: recorrido){
             System.out.println(vertice.getEtiqueta());
         }

        //desvisito nodos visitado en .bpf
        gd.desvisitarVertices();
        System.out.println();


        // imprimir etiquetas del bpf desde Asunción....
        LinkedList<IVertice> recorrido_Asuncion = gd.bpf("Asuncion");
         for (IVertice vertice: recorrido_Asuncion){
            System.out.println(vertice.getEtiqueta());
         }

       
       
    }
}
