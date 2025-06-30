package pd5;



import tdas.TNodoTrieHashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {

    private String nombreAbonado;
    private String numeroTelefono;
    private HashMap<Character, TNodoTrieTelefonos> hijos;
    private boolean esNumero;

    public TNodoTrieTelefonos() {
        hijos = new HashMap<>();
        esNumero = false;
    }

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {
        int contador = 0; //Creo contador para ir sumando las busquedas
        int numero;
        TNodoTrieTelefonos nodoActual = this; //Creo nodoActual para ir recorriendo nodos
        String prefijo = pais+area;
        for (int c = 0; c < prefijo.length(); c++) { //Recorro el largo del String s
            char digito = prefijo.charAt(c); //Obtengo la clave del hashmap directamente para ir recorriendo los numeros
            contador++; //Comparo, por lo que incremento el contador
            if (!nodoActual.hijos.containsKey(digito)) {
                System.out.println("El prefijo no está en el árbol.");
                return null;
            }
            nodoActual = nodoActual.hijos.get(digito);
        }
        // Paso 2: Desde el nodo encontrado, recolectar abonados
        LinkedList<TAbonado> abonados = new LinkedList<>();
        recolectarAbonados(nodoActual, prefijo, abonados);

        // Paso 3: Ordenar por nombre
        Collections.sort(abonados);
        return abonados;
    }
    //Se usa este metodo auxiliar, con el prefijo obtenido se busque en el trie los abonados, con ese prefijo
    public void recolectarAbonados(TNodoTrieTelefonos nodo, String numeroAcumulado, LinkedList<TAbonado> numerosConElPrefijo) {
        System.out.println("Visitando nodo: acumulado=" + numeroAcumulado + ", esNumero=" + nodo.esNumero + ", nombre=" + nodo.nombreAbonado);
        if (esNumero) {
            System.out.println("AGREGADO: " + nodo.nombreAbonado + " - " + numeroAcumulado);
            numerosConElPrefijo.add(new TAbonado(nombreAbonado, numeroTelefono));
        }

        for (Map.Entry<Character, TNodoTrieTelefonos> entry : nodo.hijos.entrySet()) {
            recolectarAbonados(entry.getValue(), numeroAcumulado + entry.getKey(), numerosConElPrefijo);
        }
        System.out.println("Agregado: " + nodo.nombreAbonado + " - " + numeroAcumulado);
    }


    @Override
    public void insertar(TAbonado unAbonado) {
        TNodoTrieTelefonos nodo = this;
        for (int i = 0; i < unAbonado.getTelefono().length(); i++) {
            char digito = unAbonado.getTelefono().charAt(i);
            nodo.hijos.putIfAbsent(digito, new TNodoTrieTelefonos());
            nodo = nodo.hijos.get(digito);
        }
        nodo.esNumero = true;
        nodo.nombreAbonado = unAbonado.getNombre();
        nodo.numeroTelefono = unAbonado.getTelefono();

    }
}


