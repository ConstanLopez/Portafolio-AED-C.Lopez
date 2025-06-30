package tdas;

import java.util.Objects;

public class THash<K, V> implements IHash<K, V> {
    private int tamanio;
    private Integer [] tablaHash;
    private K clave;
    private V valor;
    public THash(int tamanioArray){
        this.tamanio=tamanioArray;
        this.tablaHash=new Integer [tamanioArray];
    }
    // Implementación de la tabla hash
    // Aquí se pueden definir los atributos necesarios, como un array de buckets, etc.

    @Override
    public int buscar(K unaClave) {
        int i = 0;
        int comp = 0;
        int j;

        while (i < tablaHash.length) {
            j = (funcionHashing(unaClave) + i) % tablaHash.length;
            comp++;

            if (tablaHash[j] == null) {
                // Si hay una celda vacía, la clave no puede estar
                return comp;
            }

            if (Objects.equals(tablaHash[j], (Integer) unaClave)) {
                System.out.println("Se encontró la clave " + unaClave);
                return comp;
            }

            i++;
        }

        System.out.println("Error sobrecarga tabla hash");
        return comp;
    }

    @Override
    public int insertar(K clave,V unValor) {
        int i=0;
        int comp=0;
        int j;
        do {
            j = (funcionHashing(clave)+i) % tablaHash.length;
            if (tablaHash[j]==null){
                tablaHash[j]= (Integer) clave;
                return comp+=1;
            }
            else {
                i+=1;
                comp+=1;
            }
        }
        while (tablaHash[j] !=null || i<tablaHash.length);
        return comp;
    }
    
    /**
     * Función de hashing que convierte una clave en un índice de la tabla hash.
     * 
     * @param unaClave la clave a convertir en índice.
     * @return el índice correspondiente a la clave.
    */
    protected int funcionHashing(K unaClave) {
        return unaClave.hashCode();
        // Implementar una función de hashing adecuada para las claves
        // Por ejemplo, se puede usar el método hashCode() de la clave y aplicar un módulo con el tamaño de la tabla

    }
}
