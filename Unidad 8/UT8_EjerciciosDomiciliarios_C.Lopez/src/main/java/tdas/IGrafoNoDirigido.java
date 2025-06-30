package tdas;

import java.util.Collection;

public interface IGrafoNoDirigido {

    public Collection<IVertice> bea();


    public Collection<IVertice> bea(Comparable etiquetaOrigen);

    boolean esConexo();

    public boolean conectados(TVertice origen, TVertice destino);

    public TGrafoNoDirigido Prim();

    public TGrafoNoDirigido Kruskal();
}
