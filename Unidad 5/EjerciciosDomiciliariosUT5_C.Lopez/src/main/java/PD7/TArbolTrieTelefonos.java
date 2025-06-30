package PD7;
import PD7.TAbonado;
import PD7.TNodoTrieTelefonos;

import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String codPais, String codArea) {
        LinkedList<TAbonado> resultado = new LinkedList<>();
        String prefijo = codPais + codArea;
        TNodoTrieTelefonos nodo = raiz;
        for (int i = 0; i < prefijo.length(); i++) {
            int digito = prefijo.charAt(i) - '0';
            if (nodo.hijos[digito] == null) {
                return resultado;
            }
            nodo = nodo.hijos[digito];
        }
        nodo.buscarAbonados(resultado);
        resultado.sort((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        return resultado;
    }
    @Override
    public void insertar(String telefono, TAbonado abonado) {
        if (raiz == null) {
            raiz = new TNodoTrieTelefonos();
        }
        raiz.insertar(telefono, abonado);
    }
}
