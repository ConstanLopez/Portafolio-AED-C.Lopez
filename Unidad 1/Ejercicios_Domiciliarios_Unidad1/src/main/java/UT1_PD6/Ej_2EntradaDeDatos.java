package UT1_PD6;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej_2EntradaDeDatos {
    public static void leerEntradaArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        int numero=0;
        float numFloat=0.F;
        String cadena="";
        try (FileReader fr = new FileReader(archivo)){
            BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null)
        {
                    //tratar de castear a tipos de datos
                    try {
                        //trata de castear de texto a int
                        try {
                            numero = Integer.parseInt(linea.trim());
                            continue;
                        } catch (NumberFormatException e) {
                            System.out.print("No se pudo castear la variable a int");
                        }
                        //Tratar de castear de texto a float
                        try {
                            numFloat = Float.parseFloat(linea.trim());
                            continue;
                        } catch (NumberFormatException e1) {
                            System.out.print("No se pudo castear la variable a float");
                        }
                        //Si la linea es texto y se mantiene a string, la dejamos igual
                        cadena = linea.trim();
                    } catch (Exception e) {
                        System.out.print("Error al leer la línea");
                    }
                }

                }
        catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());

        }
        float suma= numFloat+numero;
        int division=(int) (numFloat/numero);
        float resto= numFloat%numero;
        System.out.println("El entero leído es "+ numero);
        System.out.println("El número de punto flotante es: "+ numFloat);
        System.out.println("La cadena léida es  "+ cadena);
        System.out.println("Hola "+ cadena+ " La suma de "+numero+" y "+numFloat+ " es "+suma);
        System.out.println(" La división entera de "+numFloat+" y "+numero+ " es "+division+" y su resto es "+resto);

    }
    public static void leerEntradaStdin()
    {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Ingrese el radio de la circunferencia: ");
        int radio= Integer.parseInt(scanner.nextLine());
         double area=Math.PI*radio;
         double perimetro=2*Math.PI*radio;
         System.out.println("El area de la circunferencia de radio "+radio+" es "+ area+" y el perímetro es "+perimetro);
    }

    public static void main(String[] args) {
        //leerEntradaArchivo("C:\\Users\\Estudiante UCU\\Desktop\\UCU\\UCU 2025\\Algoritmos y Estructuras de Datos\\Ejercicios_Domiciliarios_Unidad1\\src\\main\\java\\UT1_PD6\\entrada.txt");
        leerEntradaStdin();
    }
}
