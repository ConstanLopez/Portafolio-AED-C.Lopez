package tdas;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, IVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        for (IVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    @Override
    public LinkedList<IVertice> bpf() {
        LinkedList<IVertice> list = new LinkedList<>();

        for (IVertice vertice: vertices.values()){
            if(!vertice.getVisitado()){
                vertice.bpf(list);
            }
        }
        return list;
    }

    @Override
    public LinkedList<IVertice> bpf(IVertice vertice) {
        LinkedList<IVertice> list = new LinkedList<>();
        if(!vertice.getVisitado()){
            vertice.bpf(list);
        }
        return list;
    }
    public LinkedList<IVertice> bpfFuertementeConexo() {
        LinkedList<IVertice> list = new LinkedList<>();
        for (IVertice vertice: vertices.values()){
            if(!vertice.getVisitado()){
                vertice.bpf(list);
            }
        }
        return list;
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        IVertice origen = buscarVertice(etiquetaOrigen);

        TCamino camino = new TCamino(origen);
        TCaminos caminos = new TCaminos();

        origen.todosLosCaminos(etiquetaDestino, camino, caminos);

        return caminos;
    }

    @Override
    public LinkedList<IVertice> bpf(Comparable etiquetaOrigen) {
        LinkedList<IVertice> list = new LinkedList<>();
        IVertice vertice = buscarVertice(etiquetaOrigen);
        if(!vertice.getVisitado()){
            vertice.bpf(list);
        }
        return list;
    }


    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            IVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        IVertice vertOrigen = buscarVertice(etiquetaOrigen);
        IVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    public IVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            IVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(IVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, IVertice> getVertices() {
        return vertices;
    }

    public String centroDelGrafo(Double [][] matriz, Object [] ordenEtiquetas) {
        List <Double> listaMaximos = new ArrayList<>();
        List <Double> listaFilas = new ArrayList<>();
        for (int i =0; i<matriz.length;i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (!matriz[i][j].equals(Double.MAX_VALUE)) {
                    listaFilas.add(matriz[i][j]);
                }
            }
            listaMaximos.add(max(listaFilas));
        }
        int centroGrafo = 0;
        Double valorMinimo = listaMaximos.get(0);

        for (int i = 1; i < listaMaximos.size(); i++) {
            if (listaMaximos.get(i) < valorMinimo) {
                valorMinimo = listaMaximos.get(i);
                centroGrafo = i;
            }
        }

         return ((Comparable) ordenEtiquetas[centroGrafo]).toString();

    }

    public Double [][] Dijkstra(Double[][] matrizCostos, IVertice origen){
        Set<Comparable> V = this.getVertices().keySet();
        Set<Comparable> S = new HashSet<>();
        Set<Comparable> restantes = new HashSet<>();
        S.add(origen.getEtiqueta());
        Double [] distancia = new Double[matrizCostos.length-1];
        for(int i=1;i<= distancia.length-1;i++){
            distancia[i]=matrizCostos[(int) origen.getEtiqueta()][i];
        }
        while (V.size() != S.size()){
            //int w =
        }
        return  null;
    }

    public Double[][] floyd(Double[][] matrizCostos) {
        //Hacemos A[I,J]= C[i,j] que le pasamos por parametro, como matrizCostos
        Double[][] matrizGrafo = new Double[matrizCostos.length][matrizCostos.length];
        for(int i = 0; i <= matrizGrafo.length - 1; i++) {
            for(int j = 0; j <= matrizGrafo.length - 1; j++){
                matrizGrafo[i][j] = matrizCostos[i][j];
            }
        }
            for(int i = 0 ; i <= matrizGrafo.length - 1; i++) {
                matrizGrafo[i][i] = 0.0;
            }

            for(int k = 0; k <= matrizGrafo.length - 1; k++){
                for(int i = 0; i <= matrizGrafo.length - 1; i++){
                    for(int j = 0; j<= matrizGrafo.length - 1; j++){
                        if( matrizGrafo[i][k] + matrizGrafo[k][j] < matrizGrafo[i][j]){
                            matrizGrafo[i][j] = matrizGrafo[i][k] + matrizGrafo[k][j];
                        }
                    }
                }
            }
        return matrizGrafo;
    }

    public Comparable obtenerExcentricidad(Comparable etiquetaVertice, Double[][] matriz) {
        Object[] ordenEtiquetas = this.getEtiquetasOrdenado();
        int indice = -1;

        for (int i = 0; i < ordenEtiquetas.length; i++) {
            if (ordenEtiquetas[i].equals(etiquetaVertice)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            return -1;
        }

        double max = 0;

        for (int j = 0; j < matriz.length; j++) {
            double valor = matriz[indice][j];

            if (valor == Double.MAX_VALUE) {
                return -1;
            }

            if (valor > max) {
                max = valor;
            }
        }

        return (int) max;
    }


    public boolean[][] warshall() {
        Double [] [] matrizCosto = UtilGrafos.obtenerMatrizCostos(this.getVertices());
        boolean [] [] matrizBooleana = new boolean[matrizCosto.length][matrizCosto.length];
        for(int i=0; i<= matrizCosto.length-1;i++){
            for(int j=0; j<= matrizCosto.length-1;j++){
                //Se compara si es menor a infinto (si hay camino), y se pone true o false
                matrizBooleana[i][j] = (matrizCosto[i][j] < Double.MAX_VALUE);
            }
        }
        for (int k =0; k< matrizCosto.length-1;k++){
            for (int i =0; i< matrizCosto.length-1;i++){
                for (int j =0; j< matrizCosto.length-1;j++){
                    if (!matrizBooleana[i][j]){
                        matrizBooleana[i][j] =  matrizBooleana[i][k] && matrizBooleana[k][j];
                    }
                }
            }
        }
        return matrizBooleana;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desvisitarVertices() {
        for(IVertice vertice: vertices.values()){
            vertice.setVisitado(false);
        }
    }

    public Boolean tieneCiclo(){
        for (IVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {

                TCamino camino = new TCamino(vertice);
                if (vertice.tieneCiclo(camino)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void ordenacionTopologica(IVertice origen){
        IVertice origenGrafo = this.buscarVertice(origen.getEtiqueta());
        origenGrafo.ordenTopologico(origen);
    }

    public LinkedList<IVertice> esFuertementeConexo(){
        LinkedList<IVertice> pila = new LinkedList<>();
        this.desvisitarVertices();

        for (IVertice v : vertices.values()) {
            if (!v.getVisitado()) {
                ((TVertice) v).bpfFuertementeConexo(pila);
            }
        }
        return pila;
    }

    public boolean esConexo() {
        List<List<IVertice>> componentes = this.obtenerComponentesFuertementeConexos();
        return componentes.size() == 1;
    }

    public List<List<IVertice>> obtenerComponentesFuertementeConexos() {
        //Basado en el algoritmo presentado en la pagina 225 de Aho, Hopcroft, Ullman.
        // Capitulo componentes fuertes
        desvisitarVertices();
        LinkedList<IVertice> pila = new LinkedList<>();

        // Hago bpf  en el grafo  y guardo los vértices en el orden que se ejecutan
        for (IVertice v : vertices.values()) {
            if (!v.getVisitado()) {
                ((TVertice) v).bpfFuertementeConexo(pila);
            }
        }

        // Creo el grafo invertido
        TGrafoDirigido grafoInvertido = UtilGrafos.InvertirGrafo(this);

        // Hago Bpf en el grafo invertido según el orden de la pila
        grafoInvertido.desvisitarVertices();
        List<List<IVertice>> componentes = new ArrayList<>();

        for (IVertice v : pila) {
            IVertice verticeGrafoInvertido = grafoInvertido.buscarVertice(v.getEtiqueta());
            if (!verticeGrafoInvertido.getVisitado()) {
                List<IVertice> componente = new ArrayList<>();
                // Realizo una búsqueda en profundidad desde el vértice del grafo invertido
                // Este recorrido explora un árbol completo dentro del bosque abarcador del grafo invertido
                // Ese árbol corresponde a un componente fuertemente conexo del grafo original
                verticeGrafoInvertido.bpf(componente);
                // Agregamos ese árbol (el componente fuerte) a la lista de componentes encontrados
                componentes.add(componente);
            }
        }

        return componentes;
    }

    public int ordenCursos(IVertice materiaSinPrevias) {
        LinkedList<TVertice> listaNueva = new LinkedList<>();
        Map<Comparable, Integer> niveles = new HashMap<>();

        this.desvisitarVertices();

        TVertice origen = (TVertice) this.buscarVertice(materiaSinPrevias.getEtiqueta());
        LinkedList<TVertice> lista = origen.ordenCursos(origen, listaNueva);

        for (TVertice materia : lista) {
            niveles.put(materia.getEtiqueta(), 0);
        }

        for (TVertice materia : lista) {
            for (Object adyacente : materia.getAdyacentes()) {
                IAdyacencia ady = (IAdyacencia) adyacente;
                Comparable destino = ady.getDestino().getEtiqueta();
                Comparable origenEtiqueta = materia.getEtiqueta();

                int nivelActual = niveles.getOrDefault(destino, 0);
                int nivelNuevo = niveles.getOrDefault(origenEtiqueta, 0) + 1;

                niveles.put(destino, Math.max(nivelActual, nivelNuevo));
            }
        }

        int maxNivel = 0;
        for (int nivel : niveles.values()) {
            if (nivel > maxNivel) {
                maxNivel = nivel;
            }
        }

        return maxNivel + 1;
    }

    public Map<Comparable, List<Comparable>> dijkstraFiabilidadConCaminos(Comparable etiquetaOrigen, Map<Comparable, Double> probabilidades) {
        // la implementacion de este algoritmo, es muy parecido a dijkstra, solo que
        //no se compara si es un minimo, sino que multiplicando por los distintos costos de las aristas
        // se ve que tan fiable es el camino para la comunicación de las computadoras.
        Map<Comparable, Comparable> predecesores = new HashMap<>();
        Set<Comparable> visitados = new HashSet<>();
        PriorityQueue<Comparable> cola = new PriorityQueue<>(Comparator.comparingDouble(probabilidades::get).reversed());


        for (Comparable etiqueta : this.getVertices().keySet()) {
            probabilidades.put(etiqueta, 0.0);
        }
        probabilidades.put(etiquetaOrigen, 1.0);
        cola.add(etiquetaOrigen);

        while (!cola.isEmpty()) {
            Comparable actual = cola.poll();
            if (visitados.contains(actual)) continue;
            visitados.add(actual);

            IVertice verticeActual = this.buscarVertice(actual);
            for (IAdyacencia ady : verticeActual.getAdyacentes()) {
                Comparable vecino = ady.getDestino().getEtiqueta();
                double probNueva = probabilidades.get(actual) * ady.getCosto();

                if (probNueva > probabilidades.get(vecino)) {
                    probabilidades.put(vecino, probNueva);
                    predecesores.put(vecino, actual);
                    cola.add(vecino);
                }
            }
        }

        // Reconstruyo los caminos
        Map<Comparable, List<Comparable>> caminos = new HashMap<>();
        for (Comparable destino : this.getVertices().keySet()) {
            List<Comparable> camino = reconstruirCamino(predecesores, etiquetaOrigen, destino);
            caminos.put(destino, camino);
        }

        return caminos;
    }

    private List<Comparable> reconstruirCamino(Map<Comparable, Comparable> predecesores, Comparable origen, Comparable destino) {
        LinkedList<Comparable> camino = new LinkedList<>();
        Comparable actual = destino;
        while (actual != null && !actual.equals(origen)) {
            camino.addFirst(actual);
            actual = predecesores.get(actual);
        }
        if (actual != null) {
            camino.addFirst(origen);
        }
        return camino;
    }

    public LinkedList<IVertice> ordenParcial() {
        LinkedList<IVertice> listaOrden = new LinkedList<>();

        // Marco todos los vértices como no visitados
        for (IVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }

        // Recorro  los vértices y aplico ordenParcial recursivo
        for (IVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.ordenParcial(listaOrden);
            }
        }

        // Invierto  la lista para  que el orden sea de primero a último
        Collections.reverse(listaOrden);

        return listaOrden;
    }

    public void ClasificarArcos(TVertice verticeOrigen,
                                List<TArista> arcosArbol,
                                List<TArista> arcosRetroceso,
                                List<TArista> arcosAvance,
                                List<TArista> arcosCruzados) {

        this.desvisitarVertices();

        int[] tiempo = new int[]{0};
        LinkedList<IVertice> visitados = new LinkedList<>();

        // Hago bpf desde el  vertice origen
        verticeOrigen.bpfClasificados(visitados, arcosArbol, tiempo);

        // Hago bpf para vertices fuera del bosque abarcador
        for (IVertice v : this.getVertices().values()) {
            if (!v.getVisitado()) {
                ((TVertice) v).bpfClasificados(visitados, arcosArbol, tiempo);
            }
        }

        // Clasifico los tipos de arcos
        for (IVertice u : this.getVertices().values()) {
            for (IAdyacencia ady : u.getAdyacentes()) {
                IVertice v = ady.getDestino();

                boolean yaEsArbol = arcosArbol.stream()
                        .anyMatch(a -> a.getEtiquetaOrigen().equals(u.getEtiqueta()) &&
                                a.getEtiquetaDestino().equals(v.getEtiqueta()));
                if (yaEsArbol) continue;

                int dU = ((TVertice) u).getTiempoDescubrimiento();
                int fU = ((TVertice) u).getTiempoFinalizacion();
                int dV = ((TVertice) v).getTiempoDescubrimiento();
                int fV = ((TVertice) v).getTiempoFinalizacion();

                if (dV < dU && fU < fV) {
                    arcosRetroceso.add(new TArista(u.getEtiqueta(), v.getEtiqueta(), 1));
                }
                else if (dU < dV && fV < fU) {
                    arcosAvance.add(new TArista(u.getEtiqueta(), v.getEtiqueta(), 1));
                }
                else {
                    arcosCruzados.add(new TArista(u.getEtiqueta(), v.getEtiqueta(), 1));
                }
            }
        }
    }

}
