package PD7;
import java.util.LinkedList;
import java.util.List;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();
        String[] lineasAbonados = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/abonados.txt");
        for (String abonado : lineasAbonados) {
            String[] partes = abonado.split(",");
            if (partes.length == 2) {
                String telefonoAbonado = partes[0].trim();
                String nombreAbonado = partes[1].trim();
                TAbonado cliente = new TAbonado(nombreAbonado, telefonoAbonado);
                trieAbonados.insertar(telefonoAbonado, cliente);
            }
        }
        String[] codigos = ManejadorArchivosGenerico.leerArchivo("src/main/java/PD7/codigos1.txt");
        String codigoPais = codigos[0].trim();
        String codigoArea = codigos[1].trim();

        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        String[] salida = new String[ab.size()];
        int i = 0;
        for (TAbonado abonado : ab) {
            salida[i++] = abonado.getNombre() + ", " + abonado.getTelefono();
        }

        ManejadorArchivosGenerico.escribirArchivo("src/main/java/PD7/salida.txt", salida);
    }
}