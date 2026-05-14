package ec.edu.utpl.computacion.proava;

public class Hilos implements Runnable{

    private String[] fila;
    private String palabra;
    private int contador;

    public Hilos(String[] fila, String palabra){
        this.fila = fila;
        this.palabra = palabra;
        this.contador = 0;
    }

    @Override
    public void run() {
        for(String pal : fila){
            if(pal != null && pal.equalsIgnoreCase(palabra)){
                contador++;
            }
        }
    }

    public int getContador() {
        return contador;
    }

}
