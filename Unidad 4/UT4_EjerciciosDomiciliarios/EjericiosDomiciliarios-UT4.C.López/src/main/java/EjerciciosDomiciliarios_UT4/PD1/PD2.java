package EjerciciosDomiciliarios_UT4.PD1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PD2 {
    public static int factorial(int n)
    {
        if(n==0||n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int sumaLineal(int[] A, int n){
        if(n==0){
            return A[0];
        }
        else {
            return(sumaLineal(A,n-1)+A[n-1]);
        }
        //Si el parametro n es negativo, daría un error de IndexOutofBounds
        //Si el array está vació, habra un error al intntar acceder a sus elementos.


    }

    public static int calcularPotencia(int n,int exponente){
        if(exponente==1)
            return n;
        else{
            return n* calcularPotencia(n,exponente-1);
        }
    }
}
