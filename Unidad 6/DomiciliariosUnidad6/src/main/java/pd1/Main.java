package pd1;

import Medibles.*;
import tdas.TArbolArrayy;
import tdas.TArbolTrieHashMap;
import utils.ManejadorArchivosGenerico;

public class Main {
    private static final int REPETICIONES = 20;
    public static void main(String[] args) {
//LOS RESULTADOS ESTÁN ABAJO
        TArbolTrieHashMap trie=new TArbolTrieHashMap();
        TArbolArrayy trieArray=new TArbolArrayy();
        String [] palabras= ManejadorArchivosGenerico.leerArchivo("src/main/java/archivos/palabras.txt");
        for (String p : palabras){
            trie.insertar(p);
            trieArray.insertar(p);
        }
        // Crear un arreglo de objetos Medible para almacenar las mediciones
        Medible[] medibles = new Medible[2];
        int i = 0;
        medibles[i++] = new MedicionBuscarTrie(trie); // Es el trie, que implementa HashMap en el nodo
        medibles[i++] = new MedicionBuscarTrieArray(trieArray);
        Medicion mi;
        i = 0;
        Object[] params = {REPETICIONES,palabras};
        String[] lineas = new String[medibles.length+1];
        lineas[i++] = "algoritmo,tiempo,memoria";
        for (Medible m: medibles){
            mi= m.medir(params);
            System.out.println(mi.toString());
            lineas[i++] = mi.getTexto()+","+mi.getTiempoEjecucion().toString()+","+mi.getMemoria().toString();
        }

        ManejadorArchivosGenerico.escribirArchivo("./src/salida.csv",lineas);
    }
    /*
    EL RESULTADO DE EJECUTAR LOS METODOS DA LO SIGUIENTE;
        Archivo leido satisfactoriamente
Medicion: MedicionBuscarTrie - Consumo de memoria=2023 Bytes , tiempo de ejecución =13800 nanosecs
Medicion: MedicionBuscarTrieArray - Consumo de memoria=2152 Bytes , tiempo de ejecución =26700 nanosecs
    POR LO QUE PODEMOS CONLUIR, QUE ES MAS EFICIENTE LA IMPLEMENTACIÓN CON EL HASHMAP,
    YA QUE OCUPA MENOS MEMORIA Y TIEMPO DE EJECUCIÓN
     */
}

