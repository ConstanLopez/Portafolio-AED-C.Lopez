package pd7;

import java.util.Objects;

public class Alumno extends Object {
    private int ID;
    private String fullName;
    private String email;

    //Se calcula el hash, usando uno o más campos del objeto, con objects.hash
    public int Hashcode(){
        return Objects.hash(ID, fullName, email);
    }
    /*
    El método equals()
        Compara si es el mismo objeto en memoria.
        Verifica si el objeto es null o de otra clase.
        Compara campo por campo (con Objects.equals() para strings).


     */
    public boolean equals(Object o) {
        if (this == o) return true;                    // Mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) return false; // Tipo diferente

        Alumno alumno = (Alumno) o;

        return ID == alumno.ID &&
                Objects.equals(fullName, alumno.fullName) &&
                Objects.equals(email, alumno.email);
    }
}

//Para respetar el contrato  de hashCode, debe garantizarse que si dos
// objetos son iguales (usando el mpetodo equals), entonces su hashCode también debe ser igual y no distinto