package edd.aplicacion;

import edd.readerwriter.ReaderWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import edd.estructuras.lineales.ArrayList;
import edd.estructuras.lineales.List;
import edd.colors.Colors;

public class RedTelefonica {

    public static String FILENAME = "red.xml";
    private List<Cliente> clientes;
    private List<Estacion> estaciones;
    private Estacion[] estaciones1;
    private int numEstaciones;
    private String numEnlaces;
    private ImplementationNonDirectedGraph<Cliente> grafo;

    public RedTelefonica(){
        cargaDatos(FILENAME);
    }

    public void cargaDatos(String datos){
        estaciones = new ArrayList<>();
        clientes = new ArrayList<>();
        String nombreCliente = null;
        String telefono = null;
        String id = null;
        this.grafo = null;

        String lineOne;
        String[] tmp;
        String step;
        String nombreEstacion;
        String[] step_arr;
        String[] step_arr2;
        String[] step_arr3;
        List<String> red_text = null;

        try{
            red_text = ReaderWriter.readLines(datos);
            Iterator<String> it = red_text.iterator();
            lineOne = it.next();
            tmp = lineOne.split("\"");
            numEstaciones = Integer.parseInt(tmp[1]);
            numEnlaces = tmp[3];
            this.estaciones1 = new Estacion[this.numEstaciones];
            this.grafo = new ImplementationNonDirectedGraph(estaciones1);
            

            while(it.hasNext()){
                step = it.next().trim();
                //<Estacion
                if(step.contains("nombreEstacion")){
                    step_arr = step.split("\"");
                    nombreEstacion = step_arr[1];
                    id = step_arr[3];
                    estaciones.add(estaciones.size(), new Estacion(nombreEstacion, id));
                }

                //<Cliente
                if(step.contains("nombreCliente")){
                    step_arr2 = step.split("\"");
                    nombreCliente = step_arr2[1];
                    telefono = step_arr2[3];
                    clientes.add(clientes.size(), new Cliente(nombreCliente, telefono, id));
                }

                //<Enlace
                if(step.contains("primeraEstacion")){
                    step_arr3 = step.split("\"");
                    nombreCliente = step_arr3[1];
                    telefono = step_arr3[3];
                    int x = Integer.parseInt(nombreCliente);
                    int y = Integer.parseInt(telefono);
                    this.grafo.setEdge(x, y);
                }
            }
        }catch(IOException e){
            System.out.println("No se pudo cargar correctamente el archivo: " + e.getMessage());
            System.out.println(e);
        }
    }

    private Estacion find(String num){
        for(Cliente c : clientes){
            if(c.getTelefono().equals(num)){
                int estacionIndex = Integer.parseInt(c.getEstacion());
                    if(estacionIndex >= 0 && estacionIndex < estaciones.size()){
                        return estaciones.get(estacionIndex);
                    }
                
            }
        }
        return null;
    }


    private int[] BFSwithMiDistance(int start){
        int[] distances = new int[this.numEstaciones];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        List<Integer> ls = new ArrayList<>();
        ls.add(ls.size(), start);

        while(!ls.isEmpty()){
            int node = ls.remove(0);

            //recorrer todo los nodos adyacentes
            for(int adyNode = 0; adyNode < this.numEstaciones; adyNode++){
                if(this.grafo.getEdge(node, adyNode) && distances[adyNode] == Integer.MAX_VALUE){
                    distances[adyNode] = distances[node] + 1;
                    ls.add(ls.size(), adyNode);
                }
            }
        }
        return distances;
    }

    public int caminoMasCorto(int i, int j){
        if(i == j){
            return 0;
        }

        int[] distances = BFSwithMiDistance(i);
        if(distances[j] != Integer.MAX_VALUE){
            return distances[j];
        } else {
            return -1;
        }
    }

    public String existeCamino(String num1, String num2){
        Estacion e1 = find(num1);
        if(e1 == null){
            return "\033[0;31mEl numero " + num1 + " es invalido.\u001B[0m";
        }

        Estacion e2 = find(num2);
        if(e2 == null){
            return "\033[0;31mEl numero " + num2 + " es invalido.\u001B[0m";
        }

        return "" + caminoMasCorto(e1.getCodigo(), e2.getCodigo());
    }

    public String llamada(String num1, String num2){
        String val = existeCamino(num1, num2);
        try{
            int i = Integer.parseInt(val);
            if(0 <= i && i <= 6){
                return "\u001B[0;32mLlamada exitosa. Distancia:\u001B[0m " + i;
            }
            return "\033[0;31mLa llamada no pudo realizarse pues no existe connecion directa entre ambos numeros\u001B[0m";
        }catch(Exception e){
            return val;
        }
    }

    public String videoLlamada(String num1, String num2){
        String val = existeCamino(num1, num2);
        try{
            int i = Integer.parseInt(val);
            if(0 <= i && i <= 6){
                return "\u001B[0;32mVideollamada exitosa. Distancia:\u001B[0m " + i;
            }
            return "\033[0;31mLa video llamada no pudo realizarse, se intentara una llamada simple.\nLa llamada no pudo realizarse pues no existe coneccion directa entre ambos numeros.\u001B[0m";
        }catch(Exception e){
            return val;
        }
    }

    public List<Cliente> getClientes(){
        return clientes;
    }

    public List<Estacion> getEstaciones(){
        return estaciones;
    }
}
