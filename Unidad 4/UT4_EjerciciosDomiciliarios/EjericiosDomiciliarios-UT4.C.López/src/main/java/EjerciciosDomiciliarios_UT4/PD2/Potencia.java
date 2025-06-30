package EjerciciosDomiciliarios_UT4.PD2;

public class Potencia {
    public static int potencia(int base,int exponente){
        if (exponente==0){ //O(1)
            return 1; //O(1)
        }
        else{
            return base*(potencia(base,exponente-1));//O(n)
        }
    }
    public static void main(String [] args){
        System.out.println(potencia(4,2));
        System.out.println(potencia(5,2));
        System.out.println(potencia(2,2));
    }
}
