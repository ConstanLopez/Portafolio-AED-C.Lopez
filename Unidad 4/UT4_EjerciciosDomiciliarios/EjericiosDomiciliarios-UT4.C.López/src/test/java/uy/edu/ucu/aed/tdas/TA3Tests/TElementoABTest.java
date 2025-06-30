package uy.edu.ucu.aed.tdas.TA3Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.tdas.TArbolBB;

import static org.junit.Assert.assertEquals;

class TElementoABTest {

    private TArbolBB<Integer> arbol;
    @BeforeEach
        void init() {arbol = new TArbolBB();}

    @Test
    void obtenerTamanio() {
        //Dado
        arbol.insertar(5,1);
        arbol.insertar(2,2);
        arbol.insertar(7,3);
        //Cuando
        int resultado = arbol.obtenerTamanio();
        //Resultado
        Assertions.assertEquals(3, resultado);
    }
    @Test
    void obtenerTamanioArbolVacio() {
        //Cuando
        int resultado = arbol.obtenerTamanio();
        //Resultado
        Assertions.assertEquals(0, resultado);
    }
    @Test
    void obtenerTamanioArbolConUnSoloNodo() {
        //Dado
        arbol.insertar(5,1);
        //Cuando
        int resultado = arbol.obtenerTamanio();
        //Resultado
        Assertions.assertEquals(1, resultado);
    }
    @Test
    void obtenerAlturaArbolVacio() {
        //Cuando
        int resultado=arbol.obtenerAltura();
        //Resultado
        Assertions.assertEquals(-1,resultado);
    }
    @Test
    void obtenerAlturaArbolConUnSoloNodo() {
        //Dado
        arbol.insertar(5,1);
        //Como
        int resultado=arbol.obtenerAltura();
        //Resultado
        Assertions.assertEquals(0, resultado);
    }
    @Test
    void obtenerAlturaDelArbolEsIgualALaAlturaDeLaRaiz(){
        //Dado
        arbol.insertar(5,1);
        arbol.insertar(2,2);
        arbol.insertar(7,3);
        //Cuando
        int resultado=arbol.obtenerAltura();
        //Resultado
        Assertions.assertEquals(1, resultado);
    }
}