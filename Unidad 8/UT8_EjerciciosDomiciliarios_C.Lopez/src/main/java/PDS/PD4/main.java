package PDS.PD4;

import tdas.IVertice;
import tdas.TArista;
import tdas.TGrafoNoDirigido;
import tdas.TVertice;

import java.util.LinkedList;

public class main {
    public static  void main (String [] args){
        TVertice f = new TVertice("f");
        TVertice m = new TVertice("m");
        TVertice z = new TVertice("z");
        TVertice c = new TVertice("c");
        TVertice s = new TVertice("s");
        TVertice a = new TVertice("a");

        //Inserto los vertices
        LinkedList<IVertice> vertices = new LinkedList<>();
        vertices.add(f);
        vertices.add(m);
        vertices.add(z);
        vertices.add(c);
        vertices.add(s);
        vertices.add(a);

        //Creo las aristas
        TArista arista1 = new TArista("f", "m", 4);
        TArista arista2 = new TArista("f", "z", 2);
        TArista arista3 = new TArista("m", "z", 1);
        TArista arista4 = new TArista("m", "c", 6);
        TArista arista5 = new TArista("m", "s", 5);
        TArista arista6 = new TArista("c", "a", 3);
        TArista arista7 = new TArista("s", "a", 2);
        TArista arista8 = new TArista("z", "c", 4);
        TArista arista9 = new TArista("z", "a", 7);

        //Inserto las aristas
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(arista1);
        aristas.add(arista2);
        aristas.add(arista3);
        aristas.add(arista4);
        aristas.add(arista5);
        aristas.add(arista6);
        aristas.add(arista7);
        aristas.add(arista8);
        aristas.add(arista9);

        TGrafoNoDirigido grafo= new TGrafoNoDirigido(vertices,aristas);
        Boolean resultado = grafo.conectados(f,m);
        if (resultado){
            System.out.print("esta conectado");
        }
        else {
            System.out.print(" no esta conectado");
        }
    }
}
