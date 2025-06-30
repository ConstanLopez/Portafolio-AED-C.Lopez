package UT12_PD3.tdas;

import java.util.List;

public interface IConjunto<T> extends ILista<T> {
    IConjunto<T> unionConjuntos(IConjunto<T> otroConjunto);
    IConjunto<T> interseccionConjuntos(IConjunto<T> otroConjunto);
    void agregarAlumno(Alumno alumno);
    List<Alumno> obtenerAlumnos();
}

