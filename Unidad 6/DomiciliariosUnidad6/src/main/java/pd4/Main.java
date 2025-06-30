package pd4;

import tdas.Mapa;

public class Main {
    public static void main(String[] args) throws Exception {
        Mapa<String,Integer> mapaOcurrencias=new Mapa<>();
        mapaOcurrencias.ocurrenciaPalabras("src/main/java/archivos/libro.txt");
    }
}
