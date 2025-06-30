package UT3_PD7.tdas;

public class Conjunto<T extends Comparable<T>> extends ListaOrdenada<T> implements IConjunto<T> {

    @Override
    public IConjunto<T> unionConjuntos(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        int i = 0, j = 0;
        while (i < this.tamanio() && j < otroConjunto.tamanio()) {
            T elemA = this.obtener(i);
            T elemB = otroConjunto.obtener(j);

            int cmp = elemA.compareTo(elemB);
            if (cmp < 0) {
                resultado.agregar(elemA);
                i++;
            } else if (cmp > 0) {
                resultado.agregar(elemB);
                j++;
            } else {
                resultado.agregar(elemA);
                i++;
                j++;
            }
        }

        while (i < this.tamanio()) {
            resultado.agregar(this.obtener(i));
            i++;
        }

        while (j < otroConjunto.tamanio()) {
            resultado.agregar(otroConjunto.obtener(j));
            j++;
        }

        return resultado;
    }

    @Override
    public IConjunto<T> interseccionConjuntos(IConjunto<T> otroConjunto) {
        Conjunto<T> resultado = new Conjunto<>();

        int i = 0, j = 0;
        while (i < this.tamanio() && j < otroConjunto.tamanio()) {
            T elemA = this.obtener(i);
            T elemB = otroConjunto.obtener(j);

            int cmp = elemA.compareTo(elemB);
            if (cmp == 0) {
                resultado.agregar(elemA);
                i++;
                j++;
            } else if (cmp < 0) {
                i++;
            } else {
                j++;
            }
        }

        return resultado;
    }
}

