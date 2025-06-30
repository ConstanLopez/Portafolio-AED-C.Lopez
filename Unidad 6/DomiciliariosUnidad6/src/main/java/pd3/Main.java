package pd3;

import Medibles.*;
import tdas.Mapa;
import tdas.TArbolArrayy;
import tdas.TArbolTrieHashMap;
import utils.ManejadorArchivosGenerico;

public class Main {

    public static void main(String[] args) throws Exception {
        /*Mapa<String, Integer> mapa=new Mapa<String, Integer>();
        Mapa<String, String> mapa2=new Mapa<String,String>();
        mapa.poner("Juan",4);
        mapa.poner("Carlos",3);
        mapa.poner("Pablo",2);
        */
        //mapa.poner("Alfonso",null);
        //Se imprime antes para ver que Alfonso esa dentro del Map
        //System.out.println(mapa.elementos());
        //Se elimina a Alfonso, que tiene como valor null
        //mapa.eliminarParesConValorNull();
        //System.out.println(mapa.elementos());
        //Se imprime después para ver que Alfonso al tener como valor null, es eliminado del  Map

        //Ejercicio 2
       /* mapa2.poner("Juan","4");
        mapa2.poner("Carlos","6");
        mapa2.poner("Pablo","5");
        Mapa<String, String> mapaInvertido = mapa2.intercambiarClavesConValores(mapa2);
        System.out.println(mapaInvertido.elementos());
        */

        //Ejercicio 3
        String [] cadenas={"hola","chau","sol","luna","playa"};
        Mapa<String,Integer> mapaCadenas=new Mapa<>();
        mapaCadenas.DevolverCaracteresSegunLongitud(cadenas);
    }
}

