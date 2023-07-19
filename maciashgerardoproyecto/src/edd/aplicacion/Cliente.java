package edd.aplicacion;

public class Cliente {
    private String nombre;
    private String telefono;
    private String estacion;

    public Cliente(String nombre, String telefono, String estacion){
        this.nombre = nombre;
        this.telefono = telefono;
        this.estacion = estacion;
    }

    public Cliente(String numero){
        this.nombre = null;
        this.telefono = numero;
        this.estacion = null;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getTelefono(){
        return this.telefono;
    }

    public String getEstacion(){
        return this.estacion;
    }

    public String toString(){
        return "[" + this.telefono + " " + this.nombre + " " + this.estacion + "]";
    }
}
