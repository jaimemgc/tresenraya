package TER;

import java.util.Scanner;

public class Coordenada {
    private int fila;
    private int columna;

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    public static Coordenada pedirPorTeclado() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la fila: ");
        int valorFila = scanner.nextInt();
        System.out.print("Introduce la columna: ");
        int valorColumna = scanner.nextInt();
        return new Coordenada(valorFila,valorColumna );
    }
}
