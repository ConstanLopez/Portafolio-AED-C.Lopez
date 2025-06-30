package tdas;

import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<IVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }
    public IVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }


    public TGrafoNoDirigido Prim() {
        LinkedList<TVertice> U = new LinkedList<>();

        // Arreglar error de compilación casteos
        LinkedList<TVertice> V = new LinkedList<>();
        for (IVertice vertice : this.getVertices().values()) {
            V.add((TVertice) vertice);
        }

        double costoPrim = 0;
        TAristas aristasAAM = new TAristas();
        TArista tempArista;

        U.add(V.removeFirst());

        while (!V.isEmpty()){

            LinkedList<Comparable> etiquetasU = new LinkedList<>();
            LinkedList<Comparable> etiquetasV = new LinkedList<>();

            for (TVertice v : U) etiquetasU.add(v.getEtiqueta());
            for (TVertice v : V) etiquetasV.add(v.getEtiqueta());

            tempArista = lasAristas.buscarMin(etiquetasU, etiquetasV);
            aristasAAM.add(tempArista);

            TVertice verticeDestino = null;
            for (TVertice v : V) {
                if (v.getEtiqueta().equals(tempArista.getEtiquetaDestino())) {
                    verticeDestino = v;
                    break;
                }
            }
            V.remove(verticeDestino);
            U.add(verticeDestino);

            costoPrim += tempArista.getCosto();
        }
        TGrafoNoDirigido tGrafoNoDirigido = new TGrafoNoDirigido(new ArrayList<>(U), aristasAAM);
        return tGrafoNoDirigido;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        LinkedList <TArista> aristas =this.getLasAristas();
        //Se ordenan de menor a mayor las aristas
        aristas.sort(Comparator.comparingDouble(TArista::getCosto));
        Collection<IVertice> vertices = this.getVertices().values();
        LinkedList <TArista> aristasKruskal= new LinkedList<>();
        List<Set<Comparable>> verticesGrafo = new LinkedList<>();

        for (IVertice vertice : vertices) {
            Set<Comparable> componentesConexo = new HashSet<>();
            componentesConexo.add(vertice.getEtiqueta());
            verticesGrafo.add(componentesConexo);
        }
        for (TArista arista : aristas) {
            Comparable u = arista.getEtiquetaOrigen();
            Comparable v = arista.getEtiquetaDestino();

            Set<Comparable> conjuntoU = null;
            Set<Comparable> conjuntoV = null;

            for (Set<Comparable> conjunto : verticesGrafo) {
                if (conjunto.contains(u)) conjuntoU = conjunto;
                if (conjunto.contains(v)) conjuntoV = conjunto;
            }

            if (conjuntoU != conjuntoV) {
                aristasKruskal.add(arista);
                conjuntoU.addAll(conjuntoV);
                verticesGrafo.remove(conjuntoV);
            }
        }
        return new TGrafoNoDirigido(vertices,aristasKruskal);
    }

    @Override
    public Collection<IVertice> bea(Comparable etiquetaOrigen) {
        LinkedList<IVertice> list = new LinkedList<>();

        TVertice verticeOrigen = (TVertice) getVertices().get(etiquetaOrigen);

        if(verticeOrigen != null && !verticeOrigen.getVisitado()){
            verticeOrigen.bea(list);
        }
        return list;
    }

    @Override
    public boolean esConexo() {
        return false;
    }


    @Override
    public Collection<IVertice> bea(){
        LinkedList<IVertice> list = new LinkedList<>();
        for(IVertice vertice: getVertices().values()){
            if(!vertice.getVisitado()){
                vertice.bea(list);
            }
        }
        return list;
    }

    public LinkedList<TVertice> puntosArticulacion(Comparable etiquetaOrigen) {
        TVertice origen = (TVertice) getVertices().get(etiquetaOrigen);
        if (origen == null) return new LinkedList<>();

        for (IVertice vertice : getVertices().values()) {
            TVertice t = (TVertice) vertice;
            t.clearVisit();
        }
        LinkedList<TVertice> articulaciones = new LinkedList<>();
        int tiempo = 0;
        Map<TVertice,Integer> descubrimiento = new HashMap<>();
        Map<TVertice,Integer> bajo = new HashMap<>();

        dfsArticulaciones(origen, null, descubrimiento, bajo, articulaciones, tiempo);
        return articulaciones;
    }
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        Collection<TVertice> list = new LinkedList<>();
        IVertice vertice = buscarVertice(etiquetaOrigen);
        if(!vertice.getVisitado()){
            vertice.bpf(list);
        }
        return list;
    }

    private void dfsArticulaciones(TVertice u, TVertice padre,
                                   Map<TVertice,Integer> descubrimiento,
                                   Map<TVertice,Integer> bajo,
                                   LinkedList<TVertice> articulaciones,
                                   int tiempo) {
        u.visit();
        descubrimiento.put(u, tiempo);
        bajo.put(u, tiempo);
        u.setNumBp(tiempo);
        u.setNumBajo(tiempo);
        tiempo++;
        int cantidadHijos = 0;
        boolean esPuntoArt = false;

        for (Object obj : u.getAdyacentes()) {
            TAdyacencia ady = (TAdyacencia) obj;
            TVertice v = (TVertice) ady.getDestino();
            if (!v.isVisited()) {
                cantidadHijos++;
                dfsArticulaciones(v, u, descubrimiento, bajo, articulaciones, tiempo);
                bajo.put(u, Math.min(bajo.get(u), bajo.get(v)));
                u.setNumBajo(bajo.get(u));
                if (padre != null && bajo.get(v) >= descubrimiento.get(u)) {
                    esPuntoArt = true;
                }
            } else if (v != padre) {
                bajo.put(u, Math.min(bajo.get(u),  descubrimiento.get(v)));
                u.setNumBajo(bajo.get(u));
            }
        }

        // Condición especial para la raíz
        if (padre == null && cantidadHijos > 1) {
            esPuntoArt = true;
        }
        if (esPuntoArt) {
            articulaciones.add(u);
        }
    }

    public boolean conectados(TVertice origen,TVertice destino){
        //Si algun vertice de los del grafo, significa que no se puede llegar a cualquier vertice del grafo
        // desde dos vertices cualesquiera, por lo tanto el grafo no esta conectado
        LinkedList <TVertice> listabpf = (LinkedList<TVertice>) this.bpf(origen.getEtiqueta());
        Set <Comparable >  etiquetasBpf = new HashSet<>();

        for (TVertice etiqueta : listabpf){
            etiquetasBpf.add(etiqueta.getEtiqueta());
        }
        return etiquetasBpf.contains(destino.getEtiqueta());
    }

}
