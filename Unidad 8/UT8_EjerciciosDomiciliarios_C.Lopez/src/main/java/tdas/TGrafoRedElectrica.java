package tdas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TGrafoRedElectrica extends TGrafoNoDirigido {
    public TGrafoRedElectrica(LinkedList<IVertice> vertices, LinkedList<TArista> aristas) {
        super(vertices, aristas);
    }

    // SE PUEDE RESOLVER CON PRIM, PORQUE RESUELVE DANDO EL AAM , LA MEJOR OPTIMIZACION DEL CABLE,
    // ENTRE LAS CASAS Y LA SUB ESTACIÓN
    public TAristas mejorRedElectrica(TVertice origen) {
        LinkedList<TVertice> U = new LinkedList<>();

        // creo el V, con los vertices del grafo
        LinkedList<TVertice> V = new LinkedList<>();
        for (IVertice vertice : this.getVertices().values()) {
            V.add((TVertice) vertice);
        }

        //Aristas para el arbol abarcador de costo minimo
        TAristas aristasAAM = new TAristas();
        Set<String> conexionesAgregadas = new HashSet<>();

        //Añado el primero de u (origen ) a U y lo saco de V
        U.add(origen);
        V.remove(origen);

        //Mientras que U !=V
        while (!V.isEmpty()) {
            //Etiquetas de los vertices
            LinkedList<Comparable> etiquetasU = new LinkedList<>();
            LinkedList<Comparable> etiquetasV = new LinkedList<>();

            for (TVertice v : U) etiquetasU.add(v.getEtiqueta());
            for (TVertice v : V) etiquetasV.add(v.getEtiqueta());
            //Busca la arista de costo minimo
            TArista tempArista = lasAristas.buscarMin(etiquetasU, etiquetasV);

            if (tempArista == null) {
                System.out.println("No se encontró arista válida entre U y V. El grafo puede no ser conexo.");
                break;
            }

            //Se agrega la arista, si no esta ninguna, tanto la normal y la inversa
            String idArista = tempArista.getEtiquetaOrigen() + "-" + tempArista.getEtiquetaDestino();
            String idInversa = tempArista.getEtiquetaDestino() + "-" + tempArista.getEtiquetaOrigen();

            if (!conexionesAgregadas.contains(idArista) && !conexionesAgregadas.contains(idInversa)) {
                conexionesAgregadas.add(idArista);
                aristasAAM.add(tempArista);

                // Agregar vértice a U
                for (TVertice v : V) {
                    if (v.getEtiqueta().equals(tempArista.getEtiquetaDestino())) {
                        U.add(v);
                        V.remove(v);
                        break;
                    }
                }
            }
        }

        return aristasAAM;
    }
}
