package edd.aplicacion;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edd.estructuras.graficas.NonDirectedGraph;
import edd.estructuras.lineales.ArrayList;
import edd.estructuras.lineales.List;

public class ImplementationNonDirectedGraph<E> implements NonDirectedGraph<E>{
    private List<E> estaciones;
    private boolean[][] matrizDeAdyacencia;
    private int size;
    private int edgeNum;


    public ImplementationNonDirectedGraph(E[] estaciones){
        this.size = estaciones.length;
        //this.edgeNum = 0;
        matrizDeAdyacencia = new boolean[this.size][this.size];
        this.estaciones = (List<E>) new ArrayList<>();
        for(E e : estaciones){
            this.estaciones.add(this.estaciones.size(), e);
        }
    }

    // public void agregarEnlace(int primeraEstacion, int segundaEstacion) {
    //     matrizDeAdyacencia[primeraEstacion][segundaEstacion] = true;
    //     matrizDeAdyacencia[segundaEstacion][primeraEstacion] = true;
    // }

    @Override
    public int size() {
        return estaciones.size();
    }

    @Override
    public E vertex(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index >= estaciones.size()){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return (E)this.estaciones.get(index);
    }

    @Override
    public Iterable<E> vertexSet() {
        ArrayList vertices = new ArrayList();
        for(E e : estaciones){
            vertices.add(estaciones.size(), e);
        }
        return vertices;
    }

    @Override
    public Iterator<E> iterator() {
        return new VertexIterator();
    }

    private class VertexIterator implements Iterator<E>{
        //private int currentIndex = 0;
        Iterator<E> it = ImplementationNonDirectedGraph.this.estaciones.iterator();

        public boolean hasNext(){
            return this.it.hasNext();
        }

        public E next(){
            return this.it.next();
        }
    }

    /**
     * Devuelve el numero de aristas contenidos en esta grafica.
     *
     * @return El tamaño de esta grafica como entero mayor a cero.
     */
    @Override
    public int edgeNum() {
        int numEnlaces = 0;
        int numEstaciones = estaciones.size();
        for(int i = 0; i < numEstaciones; i++){
            for(int j = i+1; j < numEstaciones; j++){
                if(matrizDeAdyacencia[i][j]){
                    numEnlaces++;
                }
            }
        }
        return numEnlaces;
    }

    /**
     * Devuelve true si existe la arista dada por los indices i y j.
     * Si alguno de los indices esta fuera del rango valido de indices de esta grafica lanza
     * una excepcion IndexOutOfBoundsException.
     *
     * @param i Indice a revisar
     * @param j Indice a revisar
     *
     * @return true su la arista existe.
     */
    @Override
    public boolean getEdge(int i, int j) throws IndexOutOfBoundsException {
        if(i < 0 || i >= estaciones.size() || j < 0 || j >= estaciones.size()){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return this.matrizDeAdyacencia[i][j];
    }

    /**
     * Agrega la arista dada por los indices i y j.
     * Si alguno de los indices esta fuera del rango valido de indices de esta grafica lanza
     * una excepcion IndexOutOfBoundsException.
     *
     * @param i Indice a revisar
     * @param j Indice a revisar
     */
    @Override
    public void setEdge(int i, int j) throws IndexOutOfBoundsException {
        if(i < 0 || i >= estaciones.size() || j < 0 || j >= estaciones.size()){
            throw new IndexOutOfBoundsException("Fuera de rango");
        }
        /*
         * Este método establece una arista entre los índices i y j, actualizando tanto matrizDeAdyacencia[i][j] como 
         * matrizDeAdyacencia[j][i] para indicar que hay una conexión bidireccional entre esos nodos.
         */
        matrizDeAdyacencia[i][j] = true;
        matrizDeAdyacencia[j][i] = true;
    }

    /**
     * Devuelve un Iterable de aristas que se encuentran que se encuentran almacenados en esta grafica.
     * Si el indice esta fuera del rango valido de indices de esta grafica lanza
     * una excepcion IndexOutOfBoundsException.
     *
     * @param i Indice a revisar
     *
     * @return Una Iterable con los aristas contenidos por esta grafica.
     */
    @Override
    public Iterable<E> edgeSet(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= estaciones.size()){
            throw new IndexOutOfBoundsException("Fuera de rango");
        }

        List<E> aristas = new ArrayList<>();
        Iterator<E> it = this.estaciones.iterator();
        for(int j = 0; j < estaciones.size(); j++){
            E e = it.next();
            if(this.matrizDeAdyacencia[i][j]){
                aristas.add(estaciones.size(), e);
            }
        }
        return aristas;
    }


}
