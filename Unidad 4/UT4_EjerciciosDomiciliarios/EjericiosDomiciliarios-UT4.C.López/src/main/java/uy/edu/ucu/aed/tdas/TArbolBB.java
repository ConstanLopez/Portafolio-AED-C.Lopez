package uy.edu.ucu.aed.tdas;

import java.util.LinkedList;
import java.util.List;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;
    private int contadorInserciones = 0;
    private int contadorBusquedas = 0;
    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }
    public void setRaiz(TElementoAB<T> unaRaiz) {
        this.raiz = unaRaiz;
    }

    @Override
    public boolean insertar(Comparable etiqueta, T unDato) {
        //Reinicio contador de inserciones
        contadorInserciones = 0;
        //Instancio el elemento con los datos pasados como parametros
        TElementoAB<T> elemento = new TElementoAB<>(etiqueta, unDato);
        if(raiz == null){ //Si no tengo raiz
            raiz = elemento; //El elemento creado pasa a ser la raiz
            System.out.println("El metodo se llamo a si mismo " + contadorInserciones + " veces.");
            return true;
        }else { //Si ya tengo raiz
            //Guardo el resultado para poder contar cuantas veces inserté.
            boolean resultado = raiz.insertar(elemento, this);
            System.out.println("El metodo se llamo a si mismo " + contadorInserciones + " veces.");
            return resultado; //Llamo recursivamente al metodo
        }
    }

    public void incrementarContador(){
        contadorInserciones++;
    }

    public int getContadorInserciones(){
        return this.contadorInserciones;
    }

    public void incrementarBusquedas() {
        contadorBusquedas++;
    }

    public int getContadorBusquedas(){
        return this.contadorBusquedas;
    }

    @Override
    public T buscar(Comparable unaEtiqueta) {
        contadorBusquedas = 0;
        if(esVacio()){ //Si es vacio devuelvo null
            return null;
        }
        IElementoAB<T> elemento = raiz.buscar(unaEtiqueta); //Creo el elemento
        if(elemento != null){ //Verifico que no sea null
            return elemento.getDatos(); //Si no es, lo devuelvo
        }else {
            return null; //Si no existe el elemento, devuelvo null
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(raiz != null){ //Si la raiz no es null
             raiz = (TElementoAB<T>) raiz.eliminar(unaEtiqueta); //Llamo recursivamente al metodo
        }else { //Si es null, muestro por consola que está vacío
            System.out.println("El árbol está vacío.");
        }
    }

    @Override
    public List<T> preOrden() {
        List<T> lista = new LinkedList<>(); //Creo la lista donde se van a almacenar las etiquetas
        if(raiz != null){ //Si la raiz no es null
            raiz.preOrden((LinkedList<T>) lista); //Llamo recursivamente al metodo
        }else {
            System.out.println("El árbol está vacío."); //Si es null, muestro por consola
        }
        return lista; //Devuelvo la lista
    }

    @Override
    public List<T> inOrden() {
        List<T> lista = new LinkedList<>();
        if(raiz != null){
            raiz.inOrden((LinkedList<T>) lista);
        }else {
            System.out.println("El árbol está vacío");
        }
        return lista;
    }

    @Override
    public List<T> postOrden() {
        List<T> lista = new LinkedList<>();
        if(raiz != null){
            raiz.postOrden((LinkedList<T>) lista);
        }else {
            System.out.println("El árbol está vacío.");
        }
        return lista;
    }

    @Override
    public boolean esVacio() {
        return raiz == null; //Devuelve true si la raiz esta vacia; sino devuelve false
    }

    @Override
    public boolean vaciar() {
        if(raiz != null){ //Si el arbol no está vacío
            raiz = null; //La raíz pasa a estar vacía
            return true; //Devuelvo true si lo pude vaciar
        }
        return false; //Devuelvo false si no lo pude vaciar
    }

    public int obtenerAltura(){
        if(raiz == null){ //Si el arbol esta vacio
            return -1; //Devuelvo -1
        }else { //Sino
            return raiz.obtenerAltura(); //Llamo al metodo recursivamente
        }
    }

    public int cantidadHojas(){
        if(raiz == null){ //Si el arbol esta vacio
            return 0; //Devuelvo 0
        }else { //Sino
            return raiz.cantidadHojas(); //Obtengo la cantidad de hojas recursivamente
        }
    }

    public int obtenerTamanio() {
        if (raiz == null) {
            return 0; // Si el árbol está vacío, el tamaño es 0
        }
        return raiz.obtenerTamanio(); // Llama al método recursivo en la raíz
    }

    public int obtenerNivel(Comparable clave) {
        if (raiz == null) {
            return -1; // Si el árbol está vacío, retorna -1
        }
        return raiz.obtenerNivel(clave, 0); // Inicia la búsqueda desde el nivel 0
    }


    //ejercicio3.4
    public List<Comparable> getClaves(){ //metodo para encontrar todas las claves
        LinkedList<Comparable> lista = new LinkedList<>();
        if(raiz != null){
            raiz.getClaves(lista); //llama al metodo del TElemento AB
        }
        else{
            System.out.println("El árbol está vacío."); //Si es null, muestro por consola
        }
        return lista;
    }

    public int cantidadXNivel(int nivel) {
        List<Comparable> lista = getClaves(); //consigo todas las claves del árbol
        int contador = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (nivel == obtenerNivel(lista.get(i))) { //si el nivel de la clave es igual al nivel que pasé
                contador++;                           //aumento el ontador
            }
        }
        return contador;
    }


    public Comparable claveMenor(){
        if(raiz == null){ //Si la raiz esta vacía
            return null; //Devuelvo null
        }
        return raiz.claveMenor(); //Sino llamo recursivamente al metodo
    }

    public Comparable claveMayor(){
        if(raiz == null){
            return null;
        }
        return raiz.claveMayor();

    }
    public void imprimirExpresion(IElementoAB nodo){
        if (nodo.getHijoIzq() != null) {
            System.out.println("(");
        }
        imprimirExpresion(nodo.getHijoIzq());

        System.out.println(nodo.getEtiqueta());

        if (nodo.getHijoIzq() != null) {
            System.out.println(")");
        }
        imprimirExpresion(nodo.getHijoDer());

    }

    public double evaluarExpresion() {
        if (raiz == null) {
            return 0;
        }
        return raiz.evaluarExpresion();
    }



}