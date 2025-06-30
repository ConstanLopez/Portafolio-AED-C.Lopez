package UT2_PD1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2 {

        public static void main(String[] args) {
            String archivo= "src/main/java/UT2_PD1/numeros.txt";
            int contadorIf=0;
            int [] arregloNumeros;
            try{
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                //Leemos la primera linea del archivo numeros.txt
                int N = Integer.parseInt(br.readLine());
                //Establecemos el arreglo, a la cantidad de numeros a leer
                arregloNumeros =new int[N];
                for (int i = 0; i < N; i++) {
                    arregloNumeros[i] = Integer.parseInt(br.readLine());
                }

                br.close(); // Cerrar archivo

                //Algoritmo Ejercicio 1
                for(int i =1;i<N;i++){
                    for(int j=N-1;j>=i;j--){
                        //Se incrementa el contador de los if al evaluar la sentencia
                        contadorIf++;
                        if (arregloNumeros[j]<arregloNumeros[j-1]){
                            //Hacemos el intercambio
                            int temporal=arregloNumeros[j];
                            arregloNumeros[j]=arregloNumeros[j-1];
                            arregloNumeros[j-1]=temporal;

                        }
                    }
                }
                System.out.println("El numero total del arreglo es : " + N);
                System.out.println("El numero del if es: " + contadorIf);
                System.out.println("El numero que esta en la primera posciión del arreglo es : " + arregloNumeros[0]);
                System.out.println("El numero que esta en la última posciión del arreglo es : " + arregloNumeros[N-1]);
            }
            catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir un número: " + e.getMessage());
            }

        }

}
