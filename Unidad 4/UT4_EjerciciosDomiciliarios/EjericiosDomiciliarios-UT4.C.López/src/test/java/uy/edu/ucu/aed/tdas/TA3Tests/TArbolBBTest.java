package uy.edu.ucu.aed.tdas.TA3Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.tdas.IArbolBB;
import uy.edu.ucu.aed.tdas.TArbolBB;


class TArbolBBTest {

    //Creo que tendria que iniciarlo asi pero me da error, preguntar mañana
//    private TArbolBB<Integer> arbol;
//
//    @BeforeEach
//    void init(){
//        TArbolBB<Integer> arbol = new TArbolBB<>();
//        arbol = new TArbolBB<>();
//    }

    @Test
    void dadoArbolVacio_obtenerAltura() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        Assertions.assertEquals(-1, arbol.obtenerAltura());
    }

    @Test
    void dadoArbolSoloConRaiz_obtenerAltura(){
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(1,1);
        Assertions.assertEquals(0, arbol.obtenerAltura());
    }

    @Test
    void dardoArbolConElementos_obtenerAltura(){
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(1,1);
        arbol.insertar(2,2);
        arbol.insertar(3,3);
        Assertions.assertEquals(2, arbol.obtenerAltura());
    }

    @Test
    void dadoArbolVacio_obtenerTamanio() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        Assertions.assertEquals(0, arbol.obtenerTamanio());
    }

    @Test
    void dadoArbolSoloConRaiz_obtenerTamanio(){
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(1,1);
        Assertions.assertEquals(1, arbol.obtenerTamanio());

    }

    @Test
    void dadoArbolConElementos_obtenerTamanio(){
        TArbolBB<Integer> arbol = new TArbolBB<>();
        arbol.insertar(1,1);
        arbol.insertar(2,2);
        arbol.insertar(3,3);
        Assertions.assertEquals(3, arbol.obtenerTamanio());
    }
}