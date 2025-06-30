package UT3_PD9;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Corchetes SecuenciaCorchetes = new Corchetes();

        // Secuencia de corchetes bien formada
        System.out.println(SecuenciaCorchetes.controlCorchetes(Arrays.asList('{', '}', '{', '}')));

        // Secuencia de corchetes mal formada
        System.out.println(SecuenciaCorchetes.controlCorchetes(Arrays.asList('{', '{','{', '}')));
    }
}
