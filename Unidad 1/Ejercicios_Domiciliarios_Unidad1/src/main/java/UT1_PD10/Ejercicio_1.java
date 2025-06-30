package UT1_PD10;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio_1{
    public static void ContadorPalabras(String[] palabras1,String [] palabras2)
    {
        List<String> palabrasComunes= new ArrayList<>();
        for (String palabra:palabras1)
        {
            for(String word:palabras2)
            {
                if (palabra.equals(word)&&!palabrasComunes.contains(word))
                {
                    palabrasComunes.add(palabra);
                }
            }
        }
        System.out.println(palabrasComunes);
    }
    public static void main(String[] args) {
        ContadorPalabras( new String[]{"hola","como" ," estas"}, new String[]{"hola","como","como","estas","vos"});
    }
}
