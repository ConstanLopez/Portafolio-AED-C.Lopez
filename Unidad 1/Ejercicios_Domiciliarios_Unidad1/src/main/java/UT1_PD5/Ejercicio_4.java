package UT1_PD5;

public class Ejercicio_4
 {
     //ESTE ES EL PROGRAMA, CON LOS ERRORES CORREGIDOS, EL ORIGINAL,
     // PROPORCIONADO EN EL PDF ESTA DEBAJO DEL MODIFICADO, HECHO COMENTARIO
    public static void main(String[] args ) {
    // this program requires two
    // arguments on the command line
        if (args.length == 2) {
    // convert strings to numbers
            float a = (Float.valueOf (args[0])).floatValue();
            float b = (Float.valueOf(args[1])).floatValue ();
    // do some arithmetic
            System.out.println("a + b = " +
                    (a + b));
            System.out.println("a - b = " +
                    (a - b));
            System.out.println("a * b = " +
                    (a * b));
            System.out.println("a / b = " +
                    (a / b));
            System.out.println("a % b = " +
                    (a % b));
        } else {
            System.out.println("This program " +
                    "requires two command-line arguments.");
        }
    }
     /* public class ValueOfDemo {
         public static void main(String[] args) {
// this program requires two
// arguments on the command line
             if (args.length == 3) {
// convert strings to numbers
                 float a = (Float.value (args[0])).floatValue();
                 float b = (Float.valueOf(args[1])).float ();
// do some arithmetic
                 System.out.println("a + b = " +
                         (a + b));
                 System.out.println("a - b = " +
                         (a - b));
                 System.out.println("a * b = " +
                         (a * b));
                 System.out.println("a / b = " +
                         (a / b));
                 System.out.println("a % b = " +
                         (a % b));
             } else {
                 System.out.println("This program " +
                         "requires two command-line arguments.");
             }
         }
     }

     1) -El código de la función original no funcionaba correctamente, ya que incorporaba algunos métodos no válidos
        como por ejemplo en la línea 36 el float.value no es válido en Java.
        -También había este mismo problema  para el método float en la linea 37
        - Otro error, esta en el IF, que verifica si la array recibida tiene 3 elementos, cuando dice que el progrma solo requiere 2 comandos

    2) Si los parámetros de línea de comando fueran soamente positvos, habria que cambiar
     a que a y b sean de tipo float a int , y controlar a y b  luego en el código

       */
 }

