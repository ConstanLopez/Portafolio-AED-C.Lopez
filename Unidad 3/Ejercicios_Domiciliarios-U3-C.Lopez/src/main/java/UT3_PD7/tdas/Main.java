package UT3_PD7.tdas;

public class Main {
    public static void main(String[] args) {
        IConjunto<TAlumno> SO = new Conjunto<>();
        IConjunto<TAlumno> AED = new Conjunto<>();

        TAlumno a1 = new TAlumno(1597, "Carlos", "Palacios");
        TAlumno a2 = new TAlumno(7531, "Miguel", "Merentiel");
        TAlumno a3 = new TAlumno(2486, "Pablo", "Perez");
        //Agregamos los alumnos a los cursos
        AED.agregar(a1);
        AED.agregar(a2);
        AED.agregar(a3);

        //Agregamos
        SO.agregar(a3);

        //Union
        IConjunto<TAlumno> union = AED.unionConjuntos(SO);
        System.out.println("Matriculados en AED1 o PF:");
        System.out.println(union);

        //Interseccion
        IConjunto<TAlumno> interseccion = AED.interseccionConjuntos(SO);
        System.out.println("Alumnos que estan en ambos cursos:");
        System.out.println(interseccion);
    }
}

