package tas.TA6.EJ3Main;

import tdas.*;
import java.util.*;
import utils.ManejadorArchivosGenerico;


public class MainOrdenParcial {

    public static void main(String[] args) {
        String[] lineasTareas = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/archivos/archivosTA6/tareas.txt", false);
        String[] lineasPrecedencias = ManejadorArchivosGenerico.leerArchivo("src/main/java/uy/edu/ucu/aed/archivos/archivosTA6/precedencias.txt", false);

        List<IVertice> vertices = new LinkedList<>();
        List<IArista> aristas = new LinkedList<>();

        // Crear vértices a partir de tareas.txt
        for (String linea : lineasTareas) {
            String[] partes = linea.split(",");
            String etiqueta = partes[0].trim();
            TVertice vertice = new TVertice(etiqueta);
            vertices.add(vertice);
        }

        // Crear aristas a partir de precedencias.txt
        for (String linea : lineasPrecedencias) {
            String[] partes = linea.split(",");
            String desde = partes[0].trim();
            String hasta = partes[1].trim();
            double costo = Double.parseDouble(partes[2].trim());
            aristas.add(new TArista(desde, hasta, costo));
        }

        TGrafoDirigido grafo = new TGrafoDirigido(vertices, aristas);

        LinkedList<IVertice> orden = grafo.ordenParcial();

        System.out.println("Orden parcial de ejecución de tareas:");
        for (IVertice etiqueta : orden) {
            System.out.println("- " + etiqueta);
        }
    }
}
