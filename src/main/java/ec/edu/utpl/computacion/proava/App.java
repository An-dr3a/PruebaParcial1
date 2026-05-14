package ec.edu.utpl.computacion.proava;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String[][] matriz ={
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        String palabraBuscada = "Java";
        System.out.println("Iniciando busqueda concurrente del termino: \"" + palabraBuscada + "\"");
        int filas = matriz.length;

        Hilos[]  hilos = new Hilos[filas];
        Thread[] threads = new Thread[filas];
        int resultadoFinal = 0;

        try {
            for(int i = 0; i < filas; i++){
                hilos[i] = new Hilos(matriz[i], palabraBuscada);
                threads[i] = new Thread(hilos[i]);
                threads[i].start();
            }

            for(int i = 0; i < filas; i++){
                threads[i].join();
                int num = hilos[i].getContador();
                System.out.println("Hilo -" + i + " finalizado. Encontrados: " + num);
                resultadoFinal += hilos[i].getContador();
            }

            System.out.println("Total de coincidencias para '" + palabraBuscada + "': " + resultadoFinal);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}