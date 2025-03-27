package TER;

public class Tablero {
    private char[][] tablero = new char[3][3];
    private int filas = 3;
    private int columnas = 3;

    public Tablero() {
        for(int fila = 0; fila < this.filas; ++fila) {
            for(int columna = 0; columna < this.columnas; ++columna) {
                this.tablero[fila][columna] = '_';
            }
        }

    }

    public void ponFicha(char ficha, Coordenada coordenada) {
        this.tablero[coordenada.getFila()][coordenada.getColumna()] = ficha;
    }

    public void quitaFicha(Coordenada coordenada) {
        this.tablero[coordenada.getFila()][coordenada.getColumna()] = '_';
    }

    public boolean esVacia(Coordenada coordenada) {
        return this.tablero[coordenada.getFila()][coordenada.getColumna()] == '_';
    }

    public boolean hayFicha(char ficha, Coordenada coordenada) {
        return this.tablero[coordenada.getFila()][coordenada.getColumna()] == ficha;
    }

    public boolean hayTresEnRaya() {
        //Comprueba FILAS
        for(int fila = 0; fila < this.filas; fila++) {
            if (this.tablero[fila][0] == this.tablero[fila][1] && this.tablero[fila][0] == this.tablero[fila][2] && this.tablero[fila][0] != '_') {
                return true;
            }
        }
        //Comprueba COLUMNAS
        for(int columna = 0; columna < this.columnas; columna++) {
            if (this.tablero[0][columna] == this.tablero[1][columna] && this.tablero[0][columna] == this.tablero[2][columna] && this.tablero[0][columna] != '_') {
                return true;
            }
        }
        //Comprueba DIAGONALES
        return this.tablero[0][0] != '_' && this.tablero[0][0] == this.tablero[1][1] && this.tablero[1][1] == this.tablero[2][2] || this.tablero[0][2] != '_' && this.tablero[0][2] == this.tablero[1][1] && this.tablero[1][1] == this.tablero[2][0];
    }

    void mostrar() {
        System.out.println("\n");

        for(int fila = 0; fila < this.filas; fila++) {
            for(int columna = 0; columna < this.columnas; columna++) {
                System.out.print(this.tablero[fila][columna] + "\t");
            }

            System.out.println();
        }

        System.out.println("\n");
    }
}
