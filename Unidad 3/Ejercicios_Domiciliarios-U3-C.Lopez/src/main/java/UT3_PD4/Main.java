package UT3_PD4;


import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();
        supermercado.listaDeProductos = new LinkedList<>();

        Producto producto1 = new Producto(1001, "Espuma de Afeitar", 45, 10);
        Producto producto2 = new Producto(1002, "Jabón", 35, 20);
        Producto producto3 = new Producto(1003, "Shampoo", 50, 15);
        Producto producto4 = new Producto(1001, "Curitas", 45, 5);

        supermercado.insertarOActualizarProductos(producto1);
        supermercado.insertarOActualizarProductos(producto2);
        supermercado.insertarOActualizarProductos(producto3);
        supermercado.insertarOActualizarProductos(producto4);

        supermercado.reducirStockProducto(1005, 2);

        System.out.println(" Lista de productos Disponibles  en el Supermercado:");
        supermercado.listarProductos();
    }
}
