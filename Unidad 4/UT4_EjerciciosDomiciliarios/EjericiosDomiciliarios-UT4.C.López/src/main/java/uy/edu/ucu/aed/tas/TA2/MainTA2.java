package uy.edu.ucu.aed.tas.TA2;

import uy.edu.ucu.aed.tdas.TArbolBB;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.ArrayList;
import java.util.List;


public class MainTA2 {
    public static void main(String[] args) {
        cargar("src/main/java/uy/edu/ucu/aed/archivosTexto/TA2/clavesPrueba.txt",
                "src/main/java/uy/edu/ucu/aed/archivosTexto/TA2/clavesInsertadas.txt");
        TArbolBB<String> arbolBB = new TArbolBB<>();
        arbolBB.insertar("1", "1");
        arbolBB.insertar("2", "2");
        arbolBB.insertar("3", "3");

        System.out.println(preOrdenString(arbolBB));
        System.out.println(preOrdenString(arbolBB).getClass()); //Deberia ser de tipo String.

        System.out.println(postOrdenString(arbolBB));
        System.out.println(postOrdenString(arbolBB).getClass());
        System.out.println(inOrdenString(arbolBB));
        System.out.println(inOrdenString(arbolBB).getClass());

        //Ejercicio 2 Paso 2 Sub-Equipo A a)
        System.out.println("El árbol tiene una altura de " + arbolBB.obtenerAltura() + ".");
        //Ejercicio 2 Paso 2 Sub-Equipo A b)
        System.out.println("El árbol tiene " + arbolBB.cantidadHojas() + " hoja/s.");
        //Ejercicio 2 Paso 2 Sub-Equipo B a)
        System.out.println("El árbol tiene un tamanio de " + arbolBB.obtenerTamanio() + ".");
        //Ejercicio 2 Paso 2 Sub-Equipo B b)
        System.out.println("El nodo es de nivel " + arbolBB.obtenerNivel("3") + ".");
        //Ejercicio 2b sub equipo b
        System.out.println(consultas("src/main/java/uy/edu/ucu/aed/archivosTexto/TA2/clavesPrueba.txt","src/main/java/uy/edu/ucu/aed/archivosTexto/TA2/clavesConsulta",arbolBB));
        //Ejercicio 3 1.
        System.out.println(arbolBB.claveMenor());
        //Ejercicio 3 2.
        System.out.println(arbolBB.claveMayor());
    }

    //Ejercicio 1 Paso 2 Sub-Equipo A b)
    public static void cargar(String archivoALeer, String archivoAEscribir){
        String[] listaLineasALeer; //Creo arreglo de String para guardar las lineas leidas
        List<String> listaLineasAEscribir = new ArrayList<>(); //Creo Lista para guardar las lineas a escribir
        listaLineasALeer = ManejadorArchivosGenerico.leerArchivo(archivoALeer); //Leo el archivo

        TArbolBB<String> arbol = new TArbolBB<>(); //Creo el arbol para insertar los elementos

        for(String linea: listaLineasALeer){ //Por cada linea leida
            boolean insertado = arbol.insertar(linea, linea); //Inserto la linea como elemento en el arbol
            if(insertado){ //Si se inserto, agrego el elemento mas la cantidad de veces que el metodo hizo recursion
                listaLineasAEscribir.add(linea + " " + arbol.getContadorInserciones());
            }else {
                listaLineasAEscribir.add(linea + " 0");//Si no lo pude insertar, lo mismo pero con 0
            }
        }
        ManejadorArchivosGenerico.escribirArchivo(archivoAEscribir, //Escribo el archivo transformando la lista de
                listaLineasAEscribir.toArray(new String[0]));      //arreglos en un arreglo de Strings
    }

    //Ejercicio 1 Paso 2 Sub-Equipo A c)
    public static String preOrdenString(TArbolBB<String> arbolARecorrer){
        StringBuilder mensaje = new StringBuilder(); //Creo StringBuilder para poder modificarlo con el recorrido
        List<String> lista; //Creo la lista para guardar las claves en preOrden
        lista = arbolARecorrer.preOrden(); //Recorro el arbol en preOrden
        for(String elemento: lista){ //Por cada elemento guardado
            mensaje.append(elemento).append(" "); //Agrego el elemento al mensaje
        }
        return mensaje.toString(); //Regreso el mensaje como String
    }


    //Ejercicio 1 Paso 2 Sub-Equipo B b)
    // NO ESTÁ TERMINADO
    public static List consultas(String archivoALeer, String archivoAEscribir, TArbolBB<String> arbol){
        String[] listaLineasALeer = ManejadorArchivosGenerico.leerArchivo(archivoALeer);
        List<String> listaLineasAEscribir = new ArrayList<>();
        int contador=arbol.getContadorBusquedas();
        for(String linea: listaLineasALeer){
            contador++;
            //Se usa un contador general, que se muestra negativo, cuando no se encuentra y positivo cuando si
            System.out.println(contador);
            String nodo = arbol.buscar(linea);
            if (nodo != null){
                listaLineasAEscribir.add(linea +"Contador Busquedas: "+ contador); //falta el contador

            }
            else {

                listaLineasAEscribir.add(linea +" Contador Busquedas: "+ contador*-1); //agregar el contador con signo negativo si no está
            }
        }
        ManejadorArchivosGenerico.escribirArchivo(archivoAEscribir, listaLineasAEscribir.toArray(new String[0]));
        return listaLineasAEscribir;
    }

    //Ejercicio 1 Paso 2 Sub-Equipo B c)
    public static String postOrdenString(TArbolBB<String> arbolARecorrer){
        StringBuilder recorrido = new StringBuilder();
        List<String> lista = arbolARecorrer.postOrden();
        for (String elemento: lista){
            recorrido.append(elemento).append(" ");
        }
        return recorrido.toString();
    }

    //Ejercicio 1 Paso 2 Sub-Equipo B d)
    public static String inOrdenString(TArbolBB<String> arbolARecorrer){
        StringBuilder recorrido = new StringBuilder();
        List<String> lista = arbolARecorrer.inOrden();
        for (String elemento: lista){
            recorrido.append(elemento).append(" ");
        }
        return recorrido.toString();
    }
}
