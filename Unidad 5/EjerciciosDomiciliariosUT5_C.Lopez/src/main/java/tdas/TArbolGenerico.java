package tdas;


public class TArbolGenerico {
    private TNodoArbolGenerico raiz;

    public boolean insertar(String unaEtiqueta, String etiquetaPadre) {
        if (etiquetaPadre.equals("")) {
            if (raiz == null) {
                raiz = new TNodoArbolGenerico(unaEtiqueta);
                return true;
            } else {
                return false; // ya hay raíz
            }
        } else {
            if (raiz == null) return false;
            return raiz.insertar(unaEtiqueta, etiquetaPadre);
        }
    }

    public boolean buscar(String etiqueta) {
        if (raiz == null) return false;
        return raiz.buscar(etiqueta);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir("");
        } else {
            System.out.println("(árbol vacío)");
        }
    }
}

