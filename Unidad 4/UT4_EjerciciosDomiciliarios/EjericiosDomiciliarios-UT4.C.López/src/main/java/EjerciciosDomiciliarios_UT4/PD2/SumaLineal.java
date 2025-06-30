package EjerciciosDomiciliarios_UT4.PD2;

public class SumaLineal {
    public static int  SumaLineal(int[] A,int n){
        if (n==1){ //caso base O (1)
            return A[0]; // O(1)
        }
        else{
            return SumaLineal(A,n-1)+ A[n-1]; //caso recursivo  O(n)
        }
    }
    public static void main (String [] args){
        int [] A = {1,2,3};
        //System.out.println(SumaLineal(A,-2)); //Si usamos un negativo se peorduce un  StackOverflow
        int [] B = {};
        System.out.println(SumaLineal(B,2)); //Se prodcue un array index out of bounds
    }
}
