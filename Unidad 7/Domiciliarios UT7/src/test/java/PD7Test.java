
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import tdas.*;

import utils.ManejadorArchivosGenerico;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PD7Test {

    @Test
    public void testOrdenGeneradoCoincideConArchivo() {
        //  Configuración y armado del grafo . Arrange
        HashMap<Comparable, IVertice> verticesGrafo = new HashMap<>();
        String[] lineasTareas = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/tareas.txt", false);
        //Vertices
        for (String linea : lineasTareas) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                String nombreTarea = partes[0].trim();
                verticesGrafo.put(nombreTarea, new TVertice(nombreTarea));
            }
        }

        LinkedList<IArista> aristas = new LinkedList<>();
        String[] lineasPrecedencias = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/precedencias.txt", false);
        //Aristas
        for (String linea : lineasPrecedencias) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                String desde = partes[0].trim();
                String hasta = partes[1].trim();
                aristas.add(new TArista(desde, hasta, 0));
            }
        }

        // Act
        TGrafoDirigido grafo = new TGrafoDirigido(verticesGrafo.values(), aristas);
        LinkedList<IVertice> orden = grafo.ordenParcial();

        //Leer el archivo del main
        List<String> archivoEsperado = new ArrayList<>();
        for (IVertice v : orden) {
            archivoEsperado.add(v.getEtiqueta().toString());
        }

        //Assert
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/orden.txt", false);
        List<String> desdeArchivo = Arrays.asList(archivo);

        assertEquals("La salida del archivo no coincide con el orden parcial generado.", archivoEsperado, desdeArchivo);
    }
}

