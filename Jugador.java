package TER;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private char ficha;

    public Jugador(char ficha, String nombre) {
        this.ficha = ficha;
        this.nombre = nombre;
    }

    public Jugador(char ficha) {
        this.ficha = ficha;
    }

    public void putNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador: ");
        this.nombre = scanner.nextLine();
    }

    public void colocarFicha(Tablero tablero) {
        Coordenada coordenada;
        do {
            System.out.println("Jugador " + this.nombre + ", introduce la coordenada donde poner la ficha.");
            coordenada = Coordenada.pedirPorTeclado();
        } while(!tablero.esVacia(coordenada));

        tablero.ponFicha(this.ficha, coordenada);
    }

    public void mueveFicha(Tablero tablero) {
        Coordenada coordenada;
        do {
            System.out.println("Jugador " + this.nombre + ", introduce la coordenada de la ficha que quieres mover.");
            coordenada = Coordenada.pedirPorTeclado();
        } while(!tablero.hayFicha(this.ficha, coordenada));

        tablero.quitaFicha(coordenada);
        this.colocarFicha(tablero);
    }

    public void haGanado(Tablero tablero) {
        System.out.println("Felicidades " + this.nombre + " con ficha: " + this.ficha + " has ganado la partida");
        tablero.mostrar();
    }
}

