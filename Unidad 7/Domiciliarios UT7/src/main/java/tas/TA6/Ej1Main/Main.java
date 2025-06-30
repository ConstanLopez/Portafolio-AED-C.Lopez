package tas.TA6.Ej1Main;

import tdas.TGrafoDirigido;
import tdas.UtilGrafos;
import utils.ManejadorArchivosGenerico;

public class Main {
    public static void main(String[] args) {
    TGrafoDirigido grafo = UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed/archivos/archivosTA6/aeropuertos_2", "src/main/java/uy/edu/ucu/aed/archivos/archivosTA6/conexiones_2", false, TGrafoDirigido.class);
    Boolean resultado = grafo.tieneCiclo();
}
}
