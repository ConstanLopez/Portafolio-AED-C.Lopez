package PD1;

import tdas.TArbolGenerico;
import tdas.TNodoTrie;


public class Main {
    public static void main(String[] args) {
        TArbolGenerico facultad = new TArbolGenerico();
       facultad.insertar("RECTORÍA","");
        facultad.insertar("VICERRECTORÍA DEL MEDIO UNIVERSITARIO", "RECTORÍA");
        facultad.insertar("VICERRECTORÍA ACADÉMICA", "RECTORÍA");
        facultad.insertar("VICERRECTORÍA ADMINISTRATIVA", "RECTORÍA");
        facultad.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORÍA DEL MEDIO UNIVERSITARIO");
        facultad.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORÍA ACADÉMICA");
        facultad.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "VICERRECTORÍA ACADÉMICA");
        facultad.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORÍA ACADÉMICA");
        facultad.insertar("DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        facultad.insertar("DEPARTAMENTO DE INGENIERÍA ELÉCTRICA", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        facultad.insertar("DEPARTAMENTO DE MATEMÁTICAS", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");

        facultad.imprimir();

    }
}