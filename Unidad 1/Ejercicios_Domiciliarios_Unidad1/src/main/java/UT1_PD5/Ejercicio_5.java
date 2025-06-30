package UT1_PD5;

public class Ejercicio_5 {
    public static class ToStringDemo {
        public static void main(String[] args) {
            double d = 888.51;
            String s = Double.toString(d);
            int dot = s.indexOf('.');
            System.out.println(dot + " digits " +
                    "before decimal point.");
            System.out.println( (s.length() - dot - 1) +
                    " digits after decimal point.");
        }
    }
    /*      1)Indicar cuál es la salida obtenida al ejecutarlo

                La salida al ejecutar el código es esta:
                -3 digits before decimal point.
                -2 digits after decimal point.

            2)Indicar por qué se imprime cada uno de los datos y la razón de su forma
                -La primer salida, ocurre, ya que el método indexOf devuelve el índice de la primer aparición del
                    parámtro pasado (".")  en este caso en 888.51 el punto aparece en el índice 3

                -La segunda salida es el largo de la cadena, menos el método de la salida anterior que devuelve el numero 3,
                    que corresponde al índice y se le resta 1, ya que el método .length arranca a contar desde el 1 y indexOf
                    desde el cero, por lo tanto restando 1, queda la correcta cifra de números después de la coma
    */
}
