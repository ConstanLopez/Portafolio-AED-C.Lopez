package UT12_PD3.tdas;

import java.io.*;

public class ArchivoUtil {

    public static Conjunto leerArchivo(String nombreArchivo) {
        Conjunto conjunto = new Conjunto();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                conjunto.agregarAlumno(new Alumno(codigo, nombre));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return conjunto;
    }

    public static void guardarArchivo(String nombreArchivo, Conjunto conjunto) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Object alumno : conjunto.obtenerAlumnos()) {
                pw.println(alumno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

