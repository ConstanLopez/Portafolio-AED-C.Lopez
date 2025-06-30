package Medibles;

import tdas.TArbolArrayy;

public class MedicionBuscarTrieArray extends Medible{

    private TArbolArrayy trie;

    public MedicionBuscarTrieArray(TArbolArrayy trie) {
        this.trie = trie;
    }
    @Override
    public void ejecutar(Object... params) {
        if (params.length != 2 || !(params[0] instanceof Integer) || !(params[1] instanceof String[])) {
            throw new IllegalArgumentException("Parámetros inválidos. Se esperan: (int repeticion, String[] palabras)");
        }

        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for (int i = 0; i < repeticion; i++) {
            for (String palabra : palabras) {
                trie.equals(palabra);
            }
        }
    }
    @Override
    public Object getObjetoAMedirMemoria(){
        return this.trie;
    }
}


