package UT3_PD6;


import java.util.LinkedList;

public class Sucursales {

    private LinkedList<Sucursal> sucursales;

    public Sucursales() {
        sucursales = new LinkedList<>();
    }

    public String[] listarSucursales() {
        String[] lista = new String[sucursales.size()];
        int i = 0;
        for (Sucursal sucursal : sucursales) {
            lista[i] = "- " + sucursal.toString() + " -";
            i++;
        }
        return lista;
    }


    public boolean agregarSucursal(Sucursal sucursal) {
        if (sucursal != null) {
            return sucursales.add(sucursal);
        }
        return false;
    }


    public Sucursal buscarSucursal(String nombreSucursal) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equals(nombreSucursal)) {
                return sucursal;
            }
        }
        return null;
    }


    public Sucursal quitarSucursal(String nombreSucursal) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equals(nombreSucursal)) {
                sucursales.remove(sucursal);
                return sucursal;
            }
        }
        return null;
    }


    public int cantidadDeSucursales() {
        if (sucursales != null) {
            return sucursales.size();
        }
        return 0;
    }


    public boolean estaVacio() {
        return sucursales.isEmpty();
    }



    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        for (String nombre : listarSucursales()) {
            sb.append(nombre).append(separador);
        }
        return sb.toString();
    }


    public String obtenerSiguiente(String nombreSucursal) {
        for (int i = 0; i < sucursales.size() - 1; i++) {
            if (sucursales.get(i).getNombre().equals(nombreSucursal)) {
                return sucursales.get(i + 1).getNombre();
            }
        }
        return null;
    }
}

