package UT3_PD4;
import java.util.List;
public class Supermercado {
    public List<Producto> listaDeProductos;

    public void listarProductos() {
        for (Producto p : listaDeProductos) {
            System.out.println(p.getNombre() + " - " + p.getPrecio() + " - " + p.getCantidad());
        }
    }

    public void insertarOActualizarProductos(Producto nuevoProducto) {
        if (listaDeProductos.contains(nuevoProducto)) {
            int index = listaDeProductos.indexOf(nuevoProducto);
            Producto productoExistente = listaDeProductos.get(index);
            productoExistente.setCantidad(productoExistente.getCantidad() + nuevoProducto.getCantidad());
            listaDeProductos.set(index, productoExistente);
        } else {
            listaDeProductos.add(nuevoProducto);
        }
    }

    public void insertarOActualizar(String archivo) {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineas = manejadorArchivos.leerArchivo(archivo);
        for (String linea : lineas) {
            String[] partes = linea.split(","); // Separamos por comas para obtener los atributos
            int codigo = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            int precio = Integer.parseInt(partes[2]);
            int cantidad = Integer.parseInt(partes[3]);

            Producto nuevoProducto = new Producto(codigo, nombre, precio, cantidad);
            insertarOActualizar(String.valueOf(nuevoProducto));
        }
    }

    public void reducirStockProducto(int codigoProducto, int cantidad) {
        for (Producto p : listaDeProductos) {
            if (p.getCodigo() == codigoProducto) {
                int nuevoStock = Math.max(0, p.getCantidad() - cantidad); // Asegurarse de que no sea negativo el stock
                p.setCantidad(nuevoStock);
                break;
            }
        }
    }
}
