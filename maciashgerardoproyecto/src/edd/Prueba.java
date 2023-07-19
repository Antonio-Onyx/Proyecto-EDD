package edd;

import edd.aplicacion.RedTelefonica;
import edd.aplicacion.Cliente;
import edd.colors.Colors;
import edd.estructuras.lineales.List;
import java.util.Scanner;

public class Prueba {

    public static int getInt(String mensaje, String error, int min, int max) {
        int val;
        Scanner scn = new Scanner(System.in);

        while (true) {
            Colors.println(mensaje, Colors.HIGH_INTENSITY);
            if (scn.hasNextInt()) {
                val = scn.nextInt();
                // (-infinito, min) || (max, infinito)
                if (val < min || max < val) {
                    Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
                } else {
                    return val;
                }
            } else {
                scn.next();
                Colors.println(error, Colors.RED + Colors.HIGH_INTENSITY);
            }
        }
    }

    public static void print(String msg, Iterable it){
        int i = 1;
        StringBuilder sb = new StringBuilder();
        Colors.println(msg, Colors.HIGH_INTENSITY);
        for (Object obj: it) {
            sb.append(i++);
            sb.append(". ");
            sb.append(obj.toString());
            sb.append(".\n");
        }

        Colors.println(sb.toString(), Colors.CYAN + Colors.HIGH_INTENSITY);
    }

    public static String itemize(List list) {
        int i = 1;
        StringBuilder sb = new StringBuilder();

        sb.append("Selecciona una opcion.\n");

        for (Object obj: list) {
            sb.append(i++);
            sb.append(". ");
            sb.append(obj.toString());
            sb.append(".\n");
        }

        sb.append("0. Salir\n");

        return sb.toString();
    }

    


    public static void main(String[] args){

        int opcion;
        String mensaje, error;
        StringBuilder sb;
        String numero1, numero2;
        Scanner sc = new Scanner(System.in);
        boolean existeCamino;
        RedTelefonica red = new RedTelefonica();
        
        Colors.println("Este programa es un buscador sobre caracteristicas de ciudades.", Colors.BLUE + Colors.HIGH_INTENSITY);

        sb = new StringBuilder();
        sb.append("Selecciona una opcion.\n");
        sb.append("1. Realizar llamada telefonica.\n");
        sb.append("2. Realizar videollamada\n");
        sb.append("3. Imprimir directorio de numeros\n");
        sb.append("0. Salir.");
        mensaje = sb.toString();
        error = "Por favor ingrese una opcion valida.";

        do{
            String msg;
            opcion = getInt(mensaje, error, 0, 3);

            switch(opcion){
                case 1:
                    Colors.println("Ingrese el numero en el formato: 52-XXX-XXXXXXX", "\033[1m");
                    numero1 = sc.nextLine();
                    Colors.println("Ingrese el numero en el formato: 52-XXX-XXXXXXX", "\033[1m");
                    numero2 = sc.nextLine();
                    String resultado = red.llamada(numero1, numero2);
                    System.out.println(resultado);
                    break;

                case 2:
                    Colors.println("Ingrese el numero en el formato: 52-XXX-XXXXXXX", "\033[1m");
                    numero1 = sc.nextLine();
                    Colors.println("Ingrese el numero en el formato: 52-XXX-XXXXXXX", "\033[1m");
                    numero2 = sc.nextLine();
                    String resultado2 = red.videoLlamada(numero1, numero2);
                    System.out.println(resultado2);
                    break;

                case 3:
                    print("", red.getClientes());
                    break;

            }

        } while(opcion != 0);
            Colors.println("Vuelve pronto", "\033[0;34m\033[1m");        
    }
}
