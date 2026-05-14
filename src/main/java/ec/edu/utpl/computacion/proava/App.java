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

        String palabraBuscada = "Python";
        int filas = matriz.length;
        Hilos[]  hilos = new Hilos[filas];
        int resultadoFinal = 0;

        try {
            for(int i = 0; i < filas; i++){
                hilos[i] = new Hilos(matriz[i], palabraBuscada, i);
            }

            for(int i = 0; i < filas; i++){
                int parcial = hilos[i].getContador();
            }
        }catch (Exception e){}
    }
}