package edd.aplicacion;

import edd.estructuras.lineales.List;
import edd.estructuras.lineales.ArrayList;

public class Estacion {
    private String nombre;
    private int codigo;
    private List<Cliente> clientes;

    public Estacion(String nombre, String codigo){
        this.nombre = nombre;
        this.codigo = Integer.parseInt(codigo);
        this.clientes = new ArrayList<>();
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public List<Cliente> getClientes(){
        return this.clientes;
    }

    public String toString(){
        return "[" + nombre + " " + codigo + "]";
    }
}
