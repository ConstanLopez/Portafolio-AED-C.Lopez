package tas.TA6.Ej2Main;

import tdas.TArista;
import java.util.*;

public class CaminoCriticoDAG {

    static Map<Comparable, List<TArista>> grafo = new HashMap<>();
    static List<List<Comparable>> todosLosCaminos = new ArrayList<>();
    static List<Comparable> nodosFinales = new ArrayList<>();
    static double costoCritico = 0;
    static List<Comparable> caminoCritico = new ArrayList<>();

    public static void main(String[] args) {
        agregarArista("A", "B", 3);
        agregarArista("B", "C", 4);
        agregarArista("B", "D", 2);
        agregarArista("D", "E", 6);
        agregarArista("C", "E", 5);

        Comparable origen = "A";
        encontrarNodosFinales();
        for (Comparable destino : nodosFinales) {
            busquedaProfundidad(origen, destino, new ArrayList<>(), 0);
        }

        System.out.println("Camino Crítico: " + caminoCritico + " | Costo: " + costoCritico);
        System.out.println("\nTodos los caminos y holguras:");
        for (List<Comparable> camino : todosLosCaminos) {
            double costo = calcularCosto(camino);
            double holgura = costoCritico - costo;
            System.out.println("Camino: " + camino + " | Costo: " + costo + " | Holgura: " + holgura);
        }
    }

    static void agregarArista(Comparable origen, Comparable destino, double peso) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new TArista(origen, destino, peso));
    }

    static void encontrarNodosFinales() {
        Set<Comparable> nodosConSalidas = grafo.keySet();
        Set<Comparable> nodosConEntradas = new HashSet<>();
        for (List<TArista> adyacentes : grafo.values()) {
            for (TArista arista : adyacentes) {
                nodosConEntradas.add(arista.getEtiquetaDestino());
            }
        }
        for (Comparable nodo : nodosConEntradas) {
            if (!grafo.containsKey(nodo)) {
                nodosFinales.add(nodo);
            }
        }
    }

    static void busquedaProfundidad (Comparable actual, Comparable destino, List<Comparable> caminoActual, double costoAcumulado) {
        caminoActual.add(actual);

        if (actual.equals(destino)) {
            todosLosCaminos.add(new ArrayList<>(caminoActual));
            if (costoAcumulado > costoCritico) {
                costoCritico = costoAcumulado;
                caminoCritico = new ArrayList<>(caminoActual);
            }
        } else {
            if (grafo.containsKey(actual)) {
                for (TArista arista : grafo.get(actual)) {
                    if (!caminoActual.contains(arista.getEtiquetaDestino())) { // evitar ciclos
                        busquedaProfundidad(arista.getEtiquetaDestino(), destino, caminoActual, costoAcumulado + arista.getCosto());
                    }
                }
            }
        }

        caminoActual.remove(caminoActual.size() - 1); // backtrack
    }

    static double calcularCosto(List<Comparable> camino) {
        double costo = 0;
        for (int i = 0; i < camino.size() - 1; i++) {
            Comparable origen = camino.get(i);
            Comparable destino = camino.get(i + 1);
            for (TArista arista : grafo.get(origen)) {
                if (arista.getEtiquetaDestino().equals(destino)) {
                    costo += arista.getCosto();
                    break;
                }
            }
        }
        return costo;
    }
}