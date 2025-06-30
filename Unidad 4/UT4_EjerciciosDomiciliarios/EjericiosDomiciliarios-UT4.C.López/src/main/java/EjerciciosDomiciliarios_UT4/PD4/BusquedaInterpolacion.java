package EjerciciosDomiciliarios_UT4.PD4;

public class BusquedaInterpolacion {

    public static boolean contains(int[][] m, int val) {
        int N = m.length;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < m[r].length; c++) {
                if (m[r][c] == val) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matriz = {
                {4, 6, 8},
                {5, 9, 11},
                {7, 11, 14}
        };
        int valorBuscado = 9;

        boolean resultado = contains(matriz, valorBuscado);
        System.out.println("¿Está el valor " + valorBuscado + "? " + resultado);
    }
}
