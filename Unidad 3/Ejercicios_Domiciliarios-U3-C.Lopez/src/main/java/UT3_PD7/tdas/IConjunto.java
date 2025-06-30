package UT3_PD7.tdas;

public interface IConjunto<T> extends ILista<T> {
    IConjunto<T> unionConjuntos(IConjunto<T> otroConjunto);
    IConjunto<T> interseccionConjuntos(IConjunto<T> otroConjunto);
}

