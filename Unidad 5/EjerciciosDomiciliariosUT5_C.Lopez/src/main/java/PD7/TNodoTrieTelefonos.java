package PD7;

import java.util.LinkedList;

public class TNodoTrieTelefonos implements INodoTrieTelefonos {
    private static final int DIGITOS = 10;
    public TNodoTrieTelefonos[] hijos = new TNodoTrieTelefonos[DIGITOS];
    private TAbonado abonado;
    public TNodoTrieTelefonos() {

    }
    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {
        TNodoTrieTelefonos nodo = this;
        for (int i = 0; i < primerosDigitos.length(); i++) {
            int digito = primerosDigitos.charAt(i) - '0';
            if (nodo.hijos[digito] == null) {
                return;
            }
            nodo = nodo.hijos[digito];
        }
        nodo.buscarAbonados(abonados);
    }

    @Override
    public void insertar(String telefono, TAbonado abonado) {
        TNodoTrieTelefonos nodo = this;
        for (int i = 0; i < telefono.length(); i++) {
            int digito = telefono.charAt(i) - '0';
            if (nodo.hijos[digito] == null) {
                nodo.hijos[digito] = new TNodoTrieTelefonos();
            }
            nodo = nodo.hijos[digito];
        }
        nodo.abonado = abonado;
    }
    public void buscarAbonados(LinkedList<TAbonado> lista) {
        if (abonado != null) {
            lista.add(abonado);
        }
        for (TNodoTrieTelefonos hijo : hijos) {
            if (hijo != null) {
                hijo.buscarAbonados(lista);
            }
        }
    }
}
