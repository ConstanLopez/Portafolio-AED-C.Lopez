package UT3_PD6;


public class Main {

    public static void main(String Args[]) {
        // ======= 1. Levantar sucursales.txt y ver cantidad de elementos
        System.out.println("Test 1:");
        String[] lineas1 = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc1.txt");
        Sucursales suc1 = new Sucursales();

        for (String linea : lineas1) {
            Sucursal sucursal = new Sucursal(linea);
            suc1.agregarSucursal(sucursal);
        }

        System.out.println("Cantidad de elementos: " + suc1.cantidadDeSucursales());

        System.out.println("Lista de ciudades:");
        for (String s : suc1.listarSucursales()) {
            System.out.println(s);
        }

        // 2. Eliminar Chicago y verificar que  ciudad es la siguiente a Hong Kong
        System.out.println("\nTest 2:");
        suc1.quitarSucursal("Chicago");
        System.out.println("Lista de ciudades después de eliminar Chicago:");
        for (String ciudades : suc1.listarSucursales()) {
            System.out.println(ciudades);
        }

        String siguiente = suc1.obtenerSiguiente("Hong Kong");
        System.out.println("Ciudad siguiente a Hong Kong: " + siguiente);

        //  3. Levantar el archivo suc2.txt y eliminar Shenzen y Tokio
        System.out.println("\nTest 3:");
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc2.txt");
        Sucursales suc2 = new Sucursales();

        for (String linea : lineas2) {
            Sucursal s = new Sucursal(linea);
            suc2.agregarSucursal(s);
        }

        suc2.quitarSucursal("Shenzhen");
        suc2.quitarSucursal("Tokio");

        System.out.println("Cantidad restante: " + suc2.cantidadDeSucursales());
        System.out.println("Lista:");
        for (String s : suc2.listarSucursales()) {
            System.out.println(s);
        }

        // 4. Levantar el archivo suc3.txt e invocar al método imprimir
        System.out.println("\nTest 4:");
        String[] lineas3 = ManejadorArchivosGenerico.leerArchivo("src/main/java/UT3_PD6/suc3.txt");
        Sucursales suc3 = new Sucursales();

        for (String linea : lineas3) {
            Sucursal s = new Sucursal(linea);
            suc3.agregarSucursal(s);
        }

        System.out.println(suc3.imprimir(";_"));
    }

}
