package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return 
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        this.etiqueta = unaEtiqueta;
        this.datos = unosDatos;
        this.hijoDer = null;
        this.hijoIzq = null;
    }


    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public IElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public IElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(IElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {

        if(unaEtiqueta.compareTo(etiqueta) == 0){ // Si compareTo es 0, estoy en el nodo que estoy buscando
            return this;
        }else {
            if(unaEtiqueta.compareTo(etiqueta) < 0){ // Si compare To es menor que 0, me voy al hijoIzq por definicion
                if(hijoIzq != null){                // de arbol binario de busqueda
                    return hijoIzq.buscar(unaEtiqueta); // Vuelvo a llamar al metodo de busqueda
                }else {
                    return null; // No existe el elemento que estoy buscando, etiqueta es menor que raiz pero no tengo
                }               // hijoIzq
            }else {
                if (unaEtiqueta.compareTo(etiqueta) > 0){ //Si compare To es mayor que 0, idem anterior
                    if(hijoDer != null){
                        return hijoDer.buscar(unaEtiqueta);
                    }else {
                        return null;
                    }
                }
            }
        }
        return null; //No existe el elemento que estoy buscando
    }

    @Override
    public boolean insertar(IElementoAB<T> elemento, TArbolBB arbolBB) {
        arbolBB.incrementarContador();
        if(elemento.getEtiqueta().equals(etiqueta)){ //Si la etiqueta esta en el arbol devuelve false
            return false;
        }
        if(elemento.getEtiqueta().compareTo(etiqueta) < 0){ //Si la comparacion es menor a 0 me voy al hijoIzq
            if (hijoIzq == null){ //Si no tengo hijoIzq, inserto el elemento
                hijoIzq = elemento;
                return true; //Logre insertar la etiqueta
            }else { //Si ya tengo hijoIzq, llamo al metodo recursivamente
                return hijoIzq.insertar(elemento, arbolBB);
            }
        }else {
            //Idem que hijo hijoIzq, en este caso la comparacion es mayor a 0
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            }else {
                return hijoDer.insertar(elemento, arbolBB);
            }
        }
    }

    @Override
    public void preOrden(LinkedList<T> unaLista) {
        unaLista.add(this.getDatos()); //Visito el nodo actual
        if(hijoIzq != null){ //Si tengo hijo izquierdo
            hijoIzq.preOrden(unaLista); //Llamo recursivamente al metodo
        }
        if(hijoDer != null){ //Si tengo hijo derecho
            hijoDer.preOrden(unaLista); //Llamo recursivamente al metodo
        }
    }

    @Override
    public void inOrden(LinkedList<T> unaLista) {
        if(hijoIzq != null){ //Primero verifico que haya hijo izquierdo
            hijoIzq.inOrden(unaLista); //Si hay, llamo recursivamente al metodo
        }
        unaLista.add(this.getDatos()); //Visito el nodo sabiendo que es el que esta mas a la izquierda
        if(hijoDer != null){ //Si tengo hijo derecho
            hijoDer.inOrden(unaLista); //Llamo recursivamente al metodo
        }
    }

    @Override
    public void postOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null){ //Primero, verifico que haya hijo izquierdo
            hijoIzq.postOrden(unaLista); //Si hay, llamo recursivamente al metodo
        }
        if (hijoDer != null){ //Segundo, verifico que haya hijo derecho
            hijoDer.postOrden(unaLista);//Si hay, llamo recursivamente al metodo
        } unaLista.add(this.getDatos()); //Una vez visitados ambos hijos, visito el nodo actual
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    @Override
    //Con este metodo busco el nodo que quiero eliminar
    public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(etiqueta) < 0){ //Me muevo hacia el lado izquierdo
            if (hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this; //Devuelvo el nodo a eliminar
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0){
            if(hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this; //Devuelvo el nodo a eliminar
        }
        //Llamo recursivamente al metodo encargado de eliminar el nodo
        return quitarNodo();
    }

    //Con este metodo elimino el nodo encontrado
    public IElementoAB<T> quitarNodo(){
        if(hijoIzq == null){ //Si el nodo no tiene hijo izquierdo
            return hijoDer; //Se remplaza a si mismo por el hijo derecho o null (si es hoja)
        }
        if(hijoDer == null){ //Idem anterior pero con hijo derecho
            return hijoIzq;
        }

        //Si el nodo tiene dos hijos
        IElementoAB hijo = hijoIzq;
        IElementoAB padre = this;
        while (hijo.getHijoDer() != null){ //Me muevo hacia la derecha
            padre = hijo; //Padre mas proximo de hijo
            hijo = hijo.getHijoDer(); //hijo es el nodo mas grande del subarbol izq
        }
        if(padre != this){
            padre.setHijoDer(hijo.getHijoIzq());
            hijo.setHijoIzq(hijoIzq);
        }
        hijo.setHijoDer(hijoDer);
        return hijo;
    }

    @Override
    public int obtenerTamanio() {
        int tamanio = 1; //Todos los nodos tienen tamaño 1 como minimo
        if(hijoIzq != null){ //Recorro recursivamente los subarboles izquierdos hasta llegar a una hoja
            tamanio += hijoIzq.obtenerTamanio(); //Voy sumando los tamaños a la variable
        }
        if(hijoDer != null){ //Idem que con hijo izquierdo
            tamanio += hijoDer.obtenerTamanio();
        }
        return tamanio; //Devuelvo tamaño del arbol
    }

    @Override
    public int obtenerAltura(){
        int A = -1, B = -1; //A cuenta la altura del lado izquierdo, B del lado derecho
        if(hijoIzq != null){ //Si tengo hijo izquierdo
            A = hijoIzq.obtenerAltura(); //Obtengo recursivamente su altura
        }if(hijoDer != null){ //Si tengo hijo derecho
            B = hijoDer.obtenerAltura(); //Obtengo recursivamente su altura
        }
        return Math.max(A, B) + 1; //Devuelvo la altura maxima entre ambos subarboles
                                  // y le sumo 1 para ir aumentando la misma
    }

    @Override
    public int cantidadHojas(){
        if(hijoIzq == null && hijoDer == null){ //Si el nodo actual es una hoja
            return 1; //Devuelvo 1
        }
        int total = 0; //Inicio contador en 0
        if(hijoIzq != null){ //Si tengo hijo izquierdo
            total += hijoIzq.cantidadHojas(); //Sumo al total recursivamente
        }
        if(hijoDer != null){ //Si tengo hijo derecho
            total += hijoDer.cantidadHojas(); //Sumo al total recursivamente
        }
        return total; //Devuelvo el total
    }

    public int obtenerNivel(Comparable clave, int nivelActual) {
        if (clave.compareTo(etiqueta) == 0) {
            return nivelActual; // Si la clave coincide, retorna el nivel actual
        } else if (clave.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.obtenerNivel(clave, nivelActual + 1); // Busca en el subárbol izquierdo
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.obtenerNivel(clave, nivelActual + 1); // Busca en el subárbol derecho
            }
        }
        return -1; // Si no se encuentra la clave, retorna -1
    }

    //metodo para facilitar ejrcicio3.4
    public void getClaves(LinkedList<Comparable> unaLista) {     //método para encontrar todas las claves
        unaLista.add(this.getEtiqueta()); //añado etiqueta actual
        if (hijoIzq != null) {
            hijoIzq.getClaves(unaLista); //llamo método recurisvo
        }
        if (hijoDer != null) {
            hijoDer.getClaves(unaLista); //llamo método recurisvo
        }
    }

    public Comparable claveMenor(){
        if(hijoIzq == null){ //Si no tengo hijo izquierdo, estoy en la clave menor
            return this.etiqueta; //Devuelvo la etiqueta
        }
        return hijoIzq.claveMenor(); //Llamo recursivamente al metodo con el hijo izquierdo de this
    }

    public Comparable claveMayor(){
        if(hijoDer == null){ //Si no tengo hijo derecho, estoy en la clave mayor
            return this.etiqueta; //Devuelvo la etiqueta
        }
        return hijoDer.claveMayor(); //Llamo recursivamente al metodo con el hijo derecho de this
    }

    public double evaluarExpresion() {

        if (this.getHijoIzq() == null && this.getHijoDer() == null) {
            return Double.parseDouble((String) this.getDatos());
        }

        // Llamadas recursivas
        double x = this.getHijoIzq().evaluarExpresion();
        double y = this.getHijoDer().evaluarExpresion();
        String operador = (String) this.getDatos();

        return aplicarOperacion(operador, x, y);
    }

    private double aplicarOperacion(String operador, double x, double y) {
        switch (operador) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y;
            default: return 0;
        }
    }
}
