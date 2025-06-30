package EjerciciosDomiciliarios_UT4.PD2;

public class InvertirArray {
    public static void invertirArray(int A[],int i,int j){
        if (i<j){
            int temp;
            temp= A[i];
            A[i]=A[j];
            A[j]=temp;
            invertirArray(A,i+1,j-1);
        }

    }
    public static void main(String [] args){
        int[] array={1,2,3,4,5};
        invertirArray(array,0,4);

        for (int n : array){
            System.out.println(n);
        }
    }
}
