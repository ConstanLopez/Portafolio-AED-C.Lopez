package tdas;

import java.util.*;

public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<IAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private Set<IVertice> descendientes = new HashSet<>();


    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<IAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    private int tiempoDescubrimiento;
    private int tiempoFinalizacion;

    public void setTiempoDescubrimiento(int t) { this.tiempoDescubrimiento = t; }

    public void setTiempoFinalizacion(int t) { this.tiempoFinalizacion = t; }

    public int getTiempoDescubrimiento() { return this.tiempoDescubrimiento; }

    public int getTiempoFinalizacion() { return this.tiempoFinalizacion; }


    public Set<IVertice> getDescendientes() {
        return this.descendientes;
    }

    @Override
    public void bpf(Collection<IVertice> visitados) {
        this.visitado = true;
        System.out.println(this.etiqueta);
        visitados.add(this);

        for(IAdyacencia adyacencia: this.getAdyacentes()){
            IVertice destino = adyacencia.getDestino();
            if(!destino.getVisitado()) {
                destino.bpf(visitados);
            }
            this.descendientes.add(destino);
            //se agregan todos los descendientes de destino , al vertice de origen
            this.descendientes.addAll(((TVertice) destino).getDescendientes());

        }
    }
    public void bpfFuertementeConexo(LinkedList <IVertice> pila) {
        this.setVisitado(true);

        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                destino.bpfFuertementeConexo(pila);
            }
        }

        // Se Agrega en postorden solo después de explorar a todos los adyacentes
        pila.addFirst(this);
    }

    public void bpfClasificados(Collection<IVertice> visitados, List<TArista> arcosArbol, int[] tiempo) {
        this.setTiempoDescubrimiento(tiempo[0]++);
        this.setVisitado(true);
        visitados.add(this);

        for (IAdyacencia ady : this.getAdyacentes()) {
            IVertice destino = ady.getDestino();

            if (!destino.getVisitado()) {
                arcosArbol.add(new TArista(this.getEtiqueta(), destino.getEtiqueta(), 1));
                ((TVertice) destino).bpfClasificados(visitados, arcosArbol, tiempo);
            }
        }

        this.setTiempoFinalizacion(tiempo[0]++);
    }


    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public IAdyacencia buscarAdyacencia(IVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(IVertice verticeDestino) {
        IAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, IVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public IVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    public IVertice siguienteAdyacente(IVertice w) {
        IAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public IAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaVertDest, TCamino caminoPrevio, TCaminos losCaminos){
        this.setVisitado(true);
        for(IAdyacencia adyacencia: this.getAdyacentes()){
            IVertice destino = adyacencia.getDestino();
            if(!destino.getVisitado()){
                TCamino copia = caminoPrevio.copiar();
                copia.agregarAdyacencia(adyacencia);
                if(destino.getEtiqueta().compareTo(etiquetaVertDest) == 0){
                    losCaminos.getCaminos().add(copia);
                }else {
                    destino.todosLosCaminos(etiquetaVertDest, copia, losCaminos);
                }
            }
        }
        this.setVisitado(false);
        return losCaminos;
    }
    public boolean tieneCiclo(TCamino unCamino) {
        this.setVisitado(true);
        unCamino.getOtrosVertices().add(this.getEtiqueta());

        for (IAdyacencia w : this.adyacentes) {
            IVertice vertice = w.getDestino();

            //  Si el vértice  está en el camino actual entonces hay un ciclo (arco de retroceso)
            if (unCamino.getOtrosVertices().contains(vertice.getEtiqueta())) {
                System.out.println("Tiene un ciclo, ya que hay un arco de retroceso:");
                unCamino.imprimirEtiquetasConsola();
                return true;
            }

            // Si el vertice no fue visitado, seguimos recorriendo el grafo recursivamente
            if (!vertice.getVisitado()) {
                if (vertice.tieneCiclo(unCamino)) {
                    return true;
                }
            }
        }

        //Se  elimina el vértice actual del camino antes de volver
        unCamino.getOtrosVertices().remove(this.getEtiqueta());
        return false;
    }

    public void ordenTopologico(IVertice vertice){
        this.setVisitado(true); //Se marca como visitado
        for (IAdyacencia w : this.adyacentes ){ //Se recorre la lista de adyacentes al vertice
            if(!w.getDestino().getVisitado()){ //Si no esta visitado, se hace la llamada recursiva
                ordenTopologico(w.getDestino());
            }
        }
        System.out.println(this); // Una vez que termina de recorrer sus sucesores, lo imprime
    }

    public LinkedList<TVertice> ordenCursos(IVertice vertice, LinkedList<TVertice> lista) {
        this.setVisitado(true);

        for (IAdyacencia w : this.adyacentes) {
            TVertice destino = (TVertice) w.getDestino();
            if (!destino.getVisitado()) {
                destino.ordenCursos(destino, lista);
            }
        }

        lista.add(this);
        return lista;
    }
    public void ordenParcial(LinkedList <IVertice> previas){
        this.setVisitado(true);
        for (IAdyacencia w : this.adyacentes){
            if (!w.getDestino().getVisitado()){
                w.getDestino().ordenParcial(previas);
            }
        }
        previas.add(this);
    }

    public void ClasificarArcos (List<TArista>  ArcosArbol, TArista ArcosRetroceso, TArista ArcosAvance, TArista ArcosCruzados){
        // se implemento diretamente solo en TGrafo Dirigido
    }
}
