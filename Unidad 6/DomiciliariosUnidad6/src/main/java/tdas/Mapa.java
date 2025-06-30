package tdas;

import utils.ManejadorArchivosGenerico;

import java.util.Collection;
import java.util.*;

import static utils.ManejadorArchivosGenerico.leerArchivo;

public class Mapa<K, V> {
    private Map<K, V> datos = new HashMap<>();

    public int tamano() {
        return datos.size();
    }

    public boolean estaVacio() {
        return datos.isEmpty();
    }

    public V recuperar(K clave) {
        return datos.get(clave);
    }

    public void poner(K clave, V valor) {
        datos.put(clave, valor);
    }

    public void eliminar(K clave) {
        datos.remove(clave);
    }

    public boolean contieneClave(K clave) {
        return datos.containsKey(clave);
    }

    public boolean contieneValor(V valor) {
        return datos.containsValue(valor);
    }

    //Devuelve todas las claves del mapa
    public Set<K> claves() {
        return datos.keySet();
    }

    //Devuelve todos los valores del mapa
    public Collection<V> valores() {
        return datos.values();
    }

    //Devuelve todos los pares (clave,valor) del mapa
    public Set<Map.Entry<K, V>> elementos() {
        return datos.entrySet();
    }

    public void eliminarParesConValorNull() {
        Set<Map.Entry<K, V>> pares = this.elementos();
        pares.removeIf(par -> par.getValue() == null);
    }

    public Mapa<String, String> intercambiarClavesConValores(Mapa<String, String> mapa) throws Exception {
        Mapa<String, String> mapaInvertido = new Mapa<>();

        for (Map.Entry<String, String> par : mapa.elementos()) {
            String claveMapa = par.getKey();
            String valorMapa = par.getValue();
            if (mapaInvertido.contieneClave(valorMapa)) {
                throw new Exception("Se ingreso como paramétro un Map, con calves repetidas");
            }
            mapaInvertido.poner(valorMapa, claveMapa);
        }
        return mapaInvertido;
    }

    public void DevolverCaracteresSegunLongitud(String[] palabras) {
        //El treeMap ordena los elementos por clave, y el TreeSet, lo hace lexiocgraficamente si tiene que.
        TreeMap<Integer, TreeSet<String>> mapaPalabras = new TreeMap<>();
        for (String cadena : palabras) {
            int longitud = cadena.length();
            mapaPalabras.putIfAbsent(longitud, new TreeSet<>());
            mapaPalabras.get(longitud).add(cadena);
        }
        //Se imprime el mapa, ordenado por la longitud de la cadena, y luego lexicograficamente
        for (Map.Entry<Integer, TreeSet<String>> entrada : mapaPalabras.entrySet()) {
            for (String cadena : entrada.getValue()) {
                System.out.println(cadena);
            }
        }
    }

    public void ocurrenciaPalabras(String rutaArchivo) {
        String[] lineasLibro = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        Mapa<String, Integer> palabras = new Mapa<>();
        for (String renglon : lineasLibro) {
            String[] palabrasRenglon = renglon.toLowerCase().replaceAll("[^a-záéíóúüñ\\s]", "").split("\\s+");
            //Sacamos los caracteres para evitar errores, el \\s+ es para evitar espacioes en blanco, o saltos de pagina
                //Si no hya palabra sigue
            for (String palabra : palabrasRenglon) {
                if (palabra.isEmpty()) continue;
                //Si la palabra ya esta, le suma 1
                if (palabras.contieneClave(palabra)) {
                    int contador = palabras.recuperar(palabra);
                    palabras.poner(palabra, contador + 1);
                } else {
                    //Si la plaabra no esta todavia, se agrega y se le pon de valor 1
                    palabras.poner(palabra, 1);
                }
            }
        }
        //Se convierte el Map a una lista, para poder ordenarlo, ya que el map no tiene un orden
        List<Map.Entry<String, Integer>> listaFrecuencias = new ArrayList<>(palabras.elementos());

        // Ordenamos por valor  descendente usando sort, que compara dos valores
        // en este caso, lo que va a hacer es obtener la frecuencia de dos valores
        // y compararlas con compareTo
        listaFrecuencias.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Mostramos las 10 palabras más frecuentes
        System.out.println("Las 10 palabras más frecuentes son:");
        for (int i = 0; i <10; i++) {
            Map.Entry<String, Integer> entrada = listaFrecuencias.get(i);
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}


