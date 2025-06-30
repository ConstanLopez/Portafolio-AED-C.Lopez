package tdas;
import java.util.LinkedList;

public class TNodoArbolGenerico {
    private String etiqueta;
    private LinkedList<TNodoArbolGenerico> hijos;

    public TNodoArbolGenerico(String etiqueta) {
        this.etiqueta = etiqueta;
        this.hijos = new LinkedList<>();
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public LinkedList<TNodoArbolGenerico> getHijos() {
        return hijos;
    }

    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (this.etiqueta.equals(etiquetaPadre)) {
            hijos.add(new TNodoArbolGenerico(unaEtiqueta));
            return true;
        }
        for (TNodoArbolGenerico hijo : hijos) {
            if (hijo.insertar(unaEtiqueta, etiquetaPadre)) {
                return true;
            }
        }
        return false;
    }

    public boolean buscar(String unaEtiqueta) {
        if (this.etiqueta.equals(unaEtiqueta)) {
            return true;
        }
        for (TNodoArbolGenerico hijo : hijos) {
            if (hijo.buscar(unaEtiqueta)) {
                return true;
            }
        }
        return false;
    }

    public void imprimir(String prefijo) {
        System.out.println(prefijo + etiqueta);
        for (TNodoArbolGenerico hijo : hijos) {
            hijo.imprimir(prefijo + "  ");
        }
    }
}

