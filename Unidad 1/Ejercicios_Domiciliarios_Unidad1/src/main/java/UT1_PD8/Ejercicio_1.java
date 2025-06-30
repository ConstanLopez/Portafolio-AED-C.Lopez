package UT1_PD8;

public class Ejercicio_1 {
    public static void Marcapasos(short presionSan,short frecCar,short azucarSan,long fuerzaMax,float minTiempoLatidos,double batRestante,String codFabricante){
        boolean marcapasos=true;
        if(presionSan<0||presionSan>250)
        {
            System.out.println("El presion no es valido");
            marcapasos = false;
        }
        else if (frecCar<0||frecCar>226)
        {
            System.out.println("La frecuencia cardiaca  no es valido");
            marcapasos = false;
        }
        else if (azucarSan<0||azucarSan>1000)
        {
            System.out.println("El nivel de azucar en sangre ingresado no es valido");
            marcapasos = false;
        }
        else if (fuerzaMax<0||fuerzaMax>3000000000L)
        {
            System.out.println("El nivel de fuerza ingresado no es válido");
            marcapasos = false;
        }
        else if (minTiempoLatidos<0||minTiempoLatidos>100F)
        {
            System.out.println("El tiempo minimo de latidos es incorrecto");
            marcapasos = false;
        }
        else if (batRestante<0||batRestante>100F)
        {
            System.out.println("El nivel de batería  es incorrecto");
            marcapasos = false;
        }
        else if (codFabricante.length()<1||codFabricante.length()>8)
        {
            System.out.println("El codigo del fabricante no es valido");
            marcapasos = false;
        }
        if(marcapasos)
        {
            System.out.println("La frecuencia cardiaca  es "+frecCar);
            System.out.println("La presion sanguinea en sange  es "+presionSan);
            System.out.println("El azucar en sangre  es"+azucarSan);
            System.out.println("La fuerza máxima registrada es "+fuerzaMax);
            System.out.println("El tiempo minimo entre latidos   es "+minTiempoLatidos);
            System.out.println("La batería restante  es "+batRestante);
            System.out.println("El código del fabricante  es "+codFabricante);
        }
    }
    public static void main(String[] args) {
        Marcapasos((short)200,(short)200,(short)200,10000000L,1.0235F,95.022323,"DNDKSN5");
    }
    /*Parte B
    Las variables que son short, consumen 2 bytes cada uno y hay 3 entonces las variables de tipo short consumen 6 bytes
    -Las variables de tipo long consumen 8 bytes
    -Las variables de tipo float consumen 4 bytes
    -Las variables de tipo double consumen 8 bytes
    -La variable string, no tiene un espacio de memoria determinado, pero como son máximo 8 ocpua 40 bytes
    -En total las variables del programa consumen 66 bytes
     */
}
