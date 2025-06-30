package UT3_PD7.tdas;

public class TAlumno implements Comparable<TAlumno> {
    private int cedula;
    private String nombre;
    private String apellido;

    public TAlumno(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TAlumno)) return false;
        TAlumno otro = (TAlumno) o;
        return this.cedula == otro.cedula;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(cedula);
    }

    @Override
    public int compareTo(TAlumno otro) {
        return Integer.compare(this.cedula, otro.cedula);
    }

    @Override
    public String toString() {
        return cedula + " - " + nombre + " " + apellido;
    }
}

