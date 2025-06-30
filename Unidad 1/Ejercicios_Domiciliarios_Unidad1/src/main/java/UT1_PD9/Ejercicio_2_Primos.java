package UT1_PD9;

public class Ejercicio_2_Primos {
    public static boolean numeroPrimo(int numero)
    {
        boolean primo=true;
        int divisores=0;
        if (numero<=0)
        {
            System.out.println("El "+numero+ " no es primo");
            primo=false;
        }
        else
        {
            for (int i = 1; i <= numero; i++)
            {
                if (numero % i == 0)
                {
                    divisores++;
                }
            }
            if (divisores == 2)
            {
                System.out.println("El "+numero+ "  es primo");
                primo=true;

            }
        }
        return primo;
}
    public static int sumaSiSonPrimos(int numero) {
        int suma = 0;
        int contador = 0;
        if (numeroPrimo(numero)) {
            while (contador <= numero) {
                if (contador % 2 == 0) {
                    suma += contador;
                }
                contador++;
            }
        } else {
            while (contador <= numero) {
                if (contador % 2 != 0) {
                    suma += contador;
                }
                contador++;
            }
        }
        System.out.println("La suma total es " + suma);
        return suma;
    }
    public static void main(String[] args) {
        System.out.println(numeroPrimo(2));
        System.out.println(sumaSiSonPrimos(5));
    }
}
