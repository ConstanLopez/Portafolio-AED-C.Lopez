package pd5;

import tdas.TNodoTrieHashMap;

import java.util.LinkedList;


public class TArbolTrieTelefonos implements IArbolTrieTelefonos {

    private TNodoTrieTelefonos raiz;

    @Override
    public LinkedList<TAbonado> buscarTelefonos(String pais, String area) {

            if(raiz == null){
                return null;
            }
            else {
               return raiz.buscarTelefonos(pais,area);
            }
    }

    @Override
    public void insertar(TAbonado unAbonado) {
            if (raiz == null) {
                raiz = new TNodoTrieTelefonos();
            }
            raiz.insertar(unAbonado);
    }



}

