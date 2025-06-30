package tdas;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVerticeKevinBacon implements IVerticeKevinBacon{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacencias;
    private boolean visitado;
    private int numBacon;

    public Comparable getEtiqueta(){
        return etiqueta;
    }

    public LinkedList<TAdyacencia> getAdyacencias(){
        return adyacencias;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean getVisitado(){
        return visitado;
    }

    @Override
    public int getBacon() {
        return numBacon;
    }

    @Override
    public void setBacon(int newBacon) {
        this.numBacon = newBacon;
    }

    public TVerticeKevinBacon(Comparable actor){
        this.etiqueta = actor;
        adyacencias = new LinkedList<>();
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacencias) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacencias.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacencias.add(ady);
        }
        return false;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public IVertice primerAdyacente() {
        if (this.adyacencias.getFirst() != null) {
            return this.adyacencias.getFirst().getDestino();
        }
        return null;    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {

    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        return null;
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        return false;
    }

    @Override
    public void bea(Collection<IVertice> visitados) {
        Queue<IVertice> cola = new LinkedList<>();

        TVerticeKevinBacon origen = (TVerticeKevinBacon) this;
        origen.setVisitado(true);
        origen.setBacon(0);

        cola.add(origen);
        visitados.add(origen);

        while (!cola.isEmpty()){
            TVerticeKevinBacon x = (TVerticeKevinBacon) cola.poll();
            for (Object o: x.getAdyacencias()){
                TAdyacencia adyacencia = (TAdyacencia) o;
                IVertice destino = adyacencia.getDestino();
                TVerticeKevinBacon y = (TVerticeKevinBacon) destino;

                if(!y.getVisitado()){
                    y.setBacon(x.getBacon() + 1);
                    y.setVisitado(true);
                    cola.add(y);
                    visitados.add(y);
                }
            }
        }
    }

    @Override
    public boolean conectadoCon(TVertice destino) {
        return false;
    }
}
