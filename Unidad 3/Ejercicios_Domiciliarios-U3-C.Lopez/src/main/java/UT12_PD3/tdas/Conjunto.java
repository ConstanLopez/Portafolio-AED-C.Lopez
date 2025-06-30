package UT12_PD3.tdas;
import UT12_PD3.tdas.TAlumno;

import java.util.LinkedList;
import java.util.List;

public class Conjunto<T extends Comparable<T>> extends ListaOrdenada<T> implements IConjunto<T> {
    private List<Alumno> alumnos;
    public Conjunto() {
        alumnos = new LinkedList<>();
    }

    @Override
    public void agregarAlumno(Alumno alumno) {
        if (!alumnos.contains(alumno)) {
            alumnos.add(alumno);
        }
    }
    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    @Override
    public IConjunto<T> unionConjuntos(IConjunto<T> otroConjunto) {
        Conjunto<T> union = new Conjunto<>();

        for (Alumno alumno : this.alumnos) {
            union.agregarAlumno(alumno);
        }
        for (Alumno alumno : otroConjunto.obtenerAlumnos()) {
            union.agregarAlumno(alumno);
        }
        return union;
        }

    @Override
    public IConjunto<T> interseccionConjuntos(IConjunto<T> otroConjunto) {
        Conjunto resultado = new Conjunto();
        for (Alumno alumno : this.alumnos) {
            if (otroConjunto.obtenerAlumnos().contains(alumno)) {
                resultado.agregarAlumno(alumno);
            }
        }
        return resultado;
    }
}

