/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta1;

import tdas.THash;
import utils.ManejadorArchivosGenerico;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        THash <Integer, String> tHash = new THash<>(203);
        int totalComparacionesInsercion = 0;
        int totalComparacionesBusqueda = 0;


        String[] palabras = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/tas/ta1/claves_insertar.txt");
        for(String palabra: palabras){
            Integer palabraNum = Integer.parseInt(palabra);
            int comparaciones = tHash.insertar(palabraNum, palabra);
            totalComparacionesInsercion += comparaciones;
            //System.out.println("Se realizaron " + tHash.insertar(palabraNum, palabra) + " comparaciones");

        }

        String[] clavesBuscar = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/tas/ta1/claves_buscar.txt");
        for(String clave: clavesBuscar){
            Integer palabraNum = Integer.parseInt(clave);
            int comparaciones = tHash.buscar(palabraNum);
            totalComparacionesBusqueda += comparaciones;
            //System.out.println("Se realizaron " + tHash.buscar(palabraNum) + " comparaciones");
        }
        System.out.println("\n== RESUMEN FINAL ==");
        System.out.println("Total comparaciones en inserción: " + totalComparacionesInsercion);
        System.out.println("Promedio inserción: " + (totalComparacionesInsercion * 1.0 / palabras.length));

        System.out.println("Total comparaciones en búsqueda: " + totalComparacionesBusqueda);
        System.out.println("Promedio búsqueda: " + (totalComparacionesBusqueda * 1.0 / clavesBuscar.length));
    }
}
