package test;
import org.junit.jupiter.api.Test;
import tdas.TArbolGenerico;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TArbolGenericoTest {

    @Test
    public void testImprimirOrganigrama() {
        ByteArrayOutputStream salidaCapturada = new ByteArrayOutputStream();
        PrintStream salidaOriginal = System.out;
        System.setOut(new PrintStream(salidaCapturada));

        //Arrange
        TArbolGenerico arbol = new TArbolGenerico();
        arbol.insertar("RECTORÍA", "");
        arbol.insertar("VICERRECTORÍA DEL MEDIO UNIVERSITARIO", "RECTORÍA");
        arbol.insertar("VICERRECTORÍA ACADÉMICA", "RECTORÍA");
        arbol.insertar("VICERRECTORÍA ADMINISTRATIVA", "RECTORÍA");
        arbol.insertar("FACULTAD DE CIENCIAS EMPRESARIALES", "VICERRECTORÍA DEL MEDIO UNIVERSITARIO");
        arbol.insertar("FACULTAD DE CIENCIAS HUMANAS", "VICERRECTORÍA ACADÉMICA");
        arbol.insertar("FACULTAD DE INGENIERÍA Y TECNOLOGÍAS", "VICERRECTORÍA ACADÉMICA");
        arbol.insertar("FACULTAD DE PSICOLOGÍA", "VICERRECTORÍA ACADÉMICA");
        arbol.insertar("DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        arbol.insertar("DEPARTAMENTO DE INGENIERÍA ELÉCTRICA", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");
        arbol.insertar("DEPARTAMENTO DE MATEMÁTICAS", "FACULTAD DE INGENIERÍA Y TECNOLOGÍAS");

        //Act
        arbol.imprimir();
        System.setOut(salidaOriginal);
        String salidaEsperada = """
                RECTORÍA
                  VICERRECTORÍA DEL MEDIO UNIVERSITARIO
                    FACULTAD DE CIENCIAS EMPRESARIALES
                  VICERRECTORÍA ACADÉMICA
                    FACULTAD DE CIENCIAS HUMANAS
                    FACULTAD DE INGENIERÍA Y TECNOLOGÍAS
                      DEPARTAMENTO DE INFORMÁTICA Y CIENCIAS DE LA COMPUTACIÓN
                      DEPARTAMENTO DE INGENIERÍA ELÉCTRICA
                      DEPARTAMENTO DE MATEMÁTICAS
                    FACULTAD DE PSICOLOGÍA
                  VICERRECTORÍA ADMINISTRATIVA
                """;

        // Assert
        String salidaNormal = salidaCapturada.toString().replaceAll("\r\n", "\n");
        assertEquals(salidaEsperada.trim(), salidaNormal.toString().trim());
    }
}


