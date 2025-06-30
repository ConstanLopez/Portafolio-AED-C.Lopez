package pds.pd3;

import tdas.IVertice;
import tdas.TCaminos;
import tdas.TGrafoDirigido;
import tdas.UtilGrafos;

public class Main {
    public static void main(String[] args) {
        //EJERCICIO 1
        TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/pds/pd3/aeropuertos.txt","src/main/java/pds/pd3/conexiones.txt", false,TGrafoDirigido.class);
        Double[] [] matriz = UtilGrafos.obtenerMatrizCostos(grafo.getVertices());
        //UtilGrafos.imprimirMatrizMejorado(matriz,grafo.getVertices(),"matriz costo");
         Double [] [] matrizFloyd = grafo.floyd(matriz);
         //UtilGrafos.imprimirMatrizMejorado(matrizFloyd,grafo.getVertices(),"floyd");

        //EJERCICIO 2
       // boolean [][] matrizBooleana = grafo.warshall();
        //UtilGrafos.imprimirMatrizBooleana(matrizBooleana,grafo.getVertices(),"Warshall");
        //• ¿Existen conexión(es) entre Montevideo y Curitiba?
        //No, con el grafo original no existe conexion entre Montevideo y Curitiba
        //• ¿Existen conexión(es) entre Porto Alegre y Santos?
        //Si, con el grafo original  existe conexion entre Montevideo y Curitiba

        //EJERCICIO 3
        //Parte 1 y 3
        IVertice montevideo = grafo.buscarVertice("Montevideo");
       // grafo.bpf(montevideo);
        //muestra correctamente las etiquetas por consola, una vez que son visitados. y se visitan  los que no fueron visitados, con el origen
        //2. ¿Cuál es el orden del tiempo de ejecución de este algoritmo?
        //El tiempo de pofunidad, es O(a), siendo el tiempo necesario para recorrer cada arco.

        //PARTE 4
        IVertice rioDj = grafo.buscarVertice("Rio_de_Janeiro");
        Comparable montevideoEtiqueta = montevideo.getEtiqueta();
        Comparable riodejaneiro = rioDj.getEtiqueta();
        TCaminos caminos = grafo.todosLosCaminos(montevideoEtiqueta,riodejaneiro);
        caminos.imprimirCaminosConsola();
    }
}
