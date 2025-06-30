package PDS.PD3;

import tdas.*;
import utils.ManejadorArchivosGenerico;
import utils.UtilGrafos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class main {
    public static void main (String [] args){
        String[] lineasVertices = ManejadorArchivosGenerico.leerArchivo("src/main/java/PDS/PD3/barrio.txt",false);
        LinkedList<IVertice> vertices = new LinkedList<>();

        for (String nombre : lineasVertices) {
            TVertice vertice = new TVertice(nombre.trim());
            vertices.add(vertice);
        }
        String[] lineasAristas = ManejadorArchivosGenerico.leerArchivo("src/main/java/PDS/PD3/distancias.txt",false);
        LinkedList<TArista> aristas = new LinkedList<>();


        for (String linea : lineasAristas) {
            String[] partes = linea.split(" ");
            partes= linea.split(",");
            String origen = partes[0].trim();
            String destino = partes[1].trim();
            double costo = Double.parseDouble(partes[2]);

            TArista arista = new TArista(origen, destino, costo);
            aristas.add(arista);
        }
        TGrafoRedElectrica grafoRedElectrica = new TGrafoRedElectrica(vertices,aristas);
        TVertice estacionElectrica =  (TVertice) grafoRedElectrica.buscarVertice("CASA1");
        TAristas aristasRed= grafoRedElectrica.mejorRedElectrica(estacionElectrica);
        LinkedList<TArista> arista = aristasRed;
        LinkedList<String> lineas = new LinkedList<>();

        lineas.add("Algoritmo usado: Prim");

        // costo total
        double total = 0;
        for (TArista a : arista) {
            total += a.getCosto();
        }
        lineas.add("Costo total: " + total);

        // conexiones
        Set<String> yaImpresas = new HashSet<>();

        for (TArista a : arista) {
            String ida = a.getEtiquetaOrigen() + "-" + a.getEtiquetaDestino();
            String vuelta = a.getEtiquetaDestino() + "-" + a.getEtiquetaOrigen();

            if (!yaImpresas.contains(ida) && !yaImpresas.contains(vuelta)) {
                yaImpresas.add(ida);
                lineas.add(a.getEtiquetaOrigen() + " → " + a.getEtiquetaDestino() + " (Costo: " + a.getCosto() + ")");
            }
        }

        String[] lineasArray = lineas.toArray(new String[0]);
        ManejadorArchivosGenerico.escribirArchivo("src/main/java/PDS/PD3/redelectrica.txt",lineasArray);
    }
}
