package PDS.PD1.EJ2;

import tdas.IVertice;
import tdas.TArista;
import tdas.TGrafoNoDirigido;
import tdas.TVertice;

import java.util.Collection;
import java.util.LinkedList;

public class main {
    public static void main(String[] args) {

    //Creo Vertices
    TVertice b = new TVertice("b");
    TVertice a = new TVertice("a");
    TVertice e = new TVertice("e");
    TVertice d = new TVertice("d");
    TVertice c = new TVertice("c");
    TVertice f = new TVertice("f");
    TVertice g = new TVertice("g");

    //Inserto los vertices
    LinkedList<IVertice> vertices = new LinkedList<>();
    vertices.add(a);
    vertices.add(b);
    vertices.add(e);
    vertices.add(c);
    vertices.add(d);
    vertices.add(f);
    vertices.add(g);

    //Creo las aristas
    TArista arista1 = new TArista("b", "d", 4);
    TArista arista2 = new TArista("b", "e", 2);
    TArista arista3 = new TArista("b", "a", 1);
    TArista arista4 = new TArista("e", "c", 6);
    TArista arista5 = new TArista("c", "f", 5);
    TArista arista6 = new TArista("c", "g", 3);
    TArista arista7 = new TArista("a", "e", 3);

        //Inserto las aristas
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(arista1);
        aristas.add(arista2);
        aristas.add(arista3);
        aristas.add(arista4);
        aristas.add(arista5);
        aristas.add(arista6);
        aristas.add(arista7);

    TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices,aristas);
    Collection<IVertice> listaBea = grafo.bea("b");
    for(IVertice vertice : listaBea ){
        System.out.println(vertice.getEtiqueta());
    }
    //El orden eseprado es b→d→e→a→c→f→g y dio el mismo resultado, haciendo bea arrancando por b

}
}

