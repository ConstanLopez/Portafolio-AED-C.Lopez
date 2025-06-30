package tdas;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TGrafoKevinBacon extends TGrafoDirigido implements IGrafoKevinBacon{
    protected TAristas lasAristas = new TAristas();

    public TGrafoKevinBacon(Collection<IVertice> vertices, Collection<TArista> aristas){
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);
    }


    @Override
    public int numBacon(Comparable actor) {
        Collection<IVertice> actoresBacon = this.bea();

        for(IVertice vertice: actoresBacon){
            if(vertice.getEtiqueta().equals(actor)){
                return ((TVerticeKevinBacon) vertice).getBacon();
            }
        }
        return -1;
    }

    @Override
    public Collection<IVertice> bea() {
        LinkedList<IVertice> list = new LinkedList<>();

        IVertice vertice = getVertices().get("Kevin_Bacon");

        if(vertice instanceof TVerticeKevinBacon){
            TVerticeKevinBacon verticeKevinBacon = (TVerticeKevinBacon) vertice;

            if(!verticeKevinBacon.getVisitado()){
                verticeKevinBacon.setBacon(0);
                verticeKevinBacon.bea(list);
            }
        }

        return list;
    }

    @Override
    public Collection<IVertice> bea(Comparable etiquetaOrigen) {
        return List.of();
    }

    @Override
    public boolean esConexo() {
        return false;
    }

    @Override
    public boolean conectados(TVertice origen, TVertice destino) {
        return false;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        return null;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        return null;
    }
}
