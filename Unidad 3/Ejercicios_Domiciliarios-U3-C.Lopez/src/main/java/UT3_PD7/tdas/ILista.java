package UT3_PD7.tdas;

public interface ILista<T> {
    void agregar(T elemento);              
    T obtener(int posicion);              
    int tamanio();
    boolean contiene(T elemento);
    void eliminar(T elemento);
    void limpiar();
    boolean estaVacia();
}
