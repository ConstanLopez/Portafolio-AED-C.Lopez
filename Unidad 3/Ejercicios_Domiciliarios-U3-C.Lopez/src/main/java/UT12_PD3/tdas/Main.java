package UT12_PD3.tdas;

public class Main {
    public static void main(String[] args) {
        // 1. Leer los cursos base
        Conjunto basicoIng = ArchivoUtil.leerArchivo("src/main/java/UT12_PD3/tdas/basico-ing.txt");
        Conjunto basicoEmp = ArchivoUtil.leerArchivo("src/main/java/UT12_PD3/tdas/basico-emp.txt");

        // 2. INTEGRADOR 101: unión
        Conjunto integrador = (Conjunto) basicoIng.unionConjuntos(basicoEmp);
        ArchivoUtil.guardarArchivo("src/main/java/UT12_PD3/tdas/Integrador101.txt", (Conjunto) integrador);

        // 3. EXIGENTE 102: intersección
        Conjunto exigente = (Conjunto) basicoIng.interseccionConjuntos(basicoEmp);
        ArchivoUtil.guardarArchivo("src/main/java/UT12_PD3/tdas/Exigente102.txt", (Conjunto) exigente);
    }
}

