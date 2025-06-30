package pd5;

import utils.ManejadorArchivosGenerico;

import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();

        // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT


        String[] lineas = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\Estudiante UCU\\Desktop\\UCU\\UCU 2025\\Algoritmos y Estructuras de Datos\\UT6\\DomiciliariosUnidad6\\src\\main\\java\\pd5\\abonados.txt");
        for (String linea : lineas) {
            String[] partes = linea.split(",");
                String numero = partes[0].trim();
                String nombre = partes[1].trim();
                TAbonado abonado = new TAbonado(nombre, numero);
                trieAbonados.insertar(abonado);
            System.out.println("Insertando: " + nombre + " - " + numero); // en el for que lee el archivo

        }

        String codigoPais = "596" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "96" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);

        // crear el archivo "salida.txt", con los abonados (1 por linea)
        // correspondientes al pais y area
        // imprimir Nombre y teléfono,
        // ordenados alfabeticamente por nombre
        if (ab == null || ab.isEmpty()) {
            System.out.println("No se encontraron abonados con ese prefijo.");
            return;
        }
        String[] salida = new String[ab.size()];
        for (int i = 0; i < ab.size(); i++) {
            TAbonado a = ab.get(i);
            salida[i] = a.getNombre() + "," + a.getTelefono();
        }
        System.out.println("Cantidad de abonados encontrados: " + ab.size());

        ManejadorArchivosGenerico.escribirArchivo("salida.txt", salida);



    }
}
