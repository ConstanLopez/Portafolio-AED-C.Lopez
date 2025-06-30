package UT1_PD6;

public class Ej_1BuclesAnidados {
    public static void BuclesAnidados(int n){
        int contador = 0;
        for (int i=1; i<=n;i++)
        {
            for (int j=1; j<=n;j++)
            {
                System.out.print("#");

            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BuclesAnidados(5);
    }

}
