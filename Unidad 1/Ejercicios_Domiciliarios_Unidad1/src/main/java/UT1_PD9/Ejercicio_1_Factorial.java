package UT1_PD9;

public class Ejercicio_1_Factorial {
    public static int factorial (int numero)
    {
        int factorial=1;
        if (numero == 0||numero==1)
            return factorial;
        for(int i=1;i<=numero;i++)
        {
            factorial=factorial*i;
        }
        return factorial;
    }
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }
}
