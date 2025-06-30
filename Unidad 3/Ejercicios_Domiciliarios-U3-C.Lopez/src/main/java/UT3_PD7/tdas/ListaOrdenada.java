package UT3_PD7.tdas;
import java.util.ArrayList;

public class ListaOrdenada<T extends Comparable<T>> implements ILista<T> {
    protected ArrayList<T> elementos;

    public ListaOrdenada() {
        this.elementos = new ArrayList<>();
    }

    @Override
    public void agregar(T elemento) {
        if (!contiene(elemento)) {
            int i = 0;
            while (i < elementos.size() && elemento.compareTo(elementos.get(i)) > 0) {
                i++;
            }
            elementos.add(i, elemento);
        }
    }

    @Override
    public T obtener(int posicion) {
        return elementos.get(posicion);
    }

    @Override
    public void eliminar(T elemento) {
        elementos.remove(elemento);
    }

    @Override
    public boolean contiene(T elemento) {
        return elementos.contains(elemento);
    }

    @Override
    public int tamanio() {
        return elementos.size();
    }

    @Override
    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    @Override
    public void limpiar() {
        elementos.clear();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}
