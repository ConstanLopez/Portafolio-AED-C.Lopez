package tas.TA3;

import tdas.*;
import utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.Map;

public class MainTA3 {
    public static void main(String[] args)
    {
        ArrayList<IArista> aristas = new ArrayList<>();
        ArrayList<IVertice> vertices = new ArrayList<>();
        TGrafoDirigido tGrafoDirigido = new TGrafoDirigido(vertices, aristas);

        String[] aeropuertos = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Estudiante UCU\\Documents\\AED\\ut07-aed2025-equipo-9\\src\\main\\java\\uy\\edu\\ucu\\aed\\archivos\\aeropuertos.txt", false);
        String[] conexiones = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Estudiante UCU\\Documents\\AED\\ut07-aed2025-equipo-9\\src\\main\\java\\uy\\edu\\ucu\\aed\\archivos\\conexiones.txt", false);

        for(String aeropuerto: aeropuertos){
            tGrafoDirigido.insertarVertice(aeropuerto);
        }

        for(String conexion: conexiones){
            String[] conexionArray = conexion.split(",");
            TArista arista = new TArista(conexionArray[0], conexionArray[1], Double.parseDouble(conexionArray[2]));
            tGrafoDirigido.insertarArista(arista);
        }
        Map<Comparable,IVertice> vertices2 = tGrafoDirigido.getVertices();
        Double [][] matriz = UtilGrafos.obtenerMatrizCostos(vertices2);
        Double [][] matrizConFloyd = tGrafoDirigido.floyd(matriz);
//        UtilGrafos.imprimirMatriz(matriz, vertices2);
        UtilGrafos.imprimirMatriz(matrizConFloyd, vertices2);


    }
}
