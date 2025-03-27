package TER;

public class TresEnRaya {
    private Tablero tablero = new Tablero();
    private Jugador[] jugadores = new Jugador[2];
    private Turno turno = new Turno();
    private static final char FICHA_JUG_1 = 'X';
    private static final char FICHA_JUG_2 = 'O';

    public TresEnRaya() {
        this.jugadores[0] = new Jugador('X');
        this.jugadores[1] = new Jugador('O');
    }

    public void jugar() {
        //Pedimos el nombre de cada jugador
        for(int jugador = 0; jugador < this.jugadores.length;jugador++) {
            this.jugadores[jugador].putNombre();
        }


        //Colocamos las 5 piezas iniciales, porque el primer jugador puede ganar al haber colocado sus tres piezas
        for(int pieza = 0; pieza < 5; pieza++) {
            this.jugadores[this.turno.quienToca()].colocarFicha(this.tablero);
            this.turno.cambiar();
            this.tablero.mostrar();
        }

        //Empieza el juego. Comprobamos si el primer jugador ha ganado. Sino, el segundo jugador coloca su ultima ficha
        //A partir de ese momento, cada jugador quita una de sus piezas y vuelve a colocarla
        if (this.tablero.hayTresEnRaya()) {
            this.jugadores[this.turno.quienNoToca()].haGanado(this.tablero);
        } else {
            //Segundo jugador coloca su ultima pieza
            this.jugadores[this.turno.quienToca()].colocarFicha(this.tablero);
            this.turno.cambiar();
            this.tablero.mostrar();

            //Comprobamos si hay tresEnRaya, sino el jugador con turno MUEVE una pieza
            while(!this.tablero.hayTresEnRaya()) {
                this.jugadores[this.turno.quienToca()].mueveFicha(this.tablero);
                this.turno.cambiar();
                this.tablero.mostrar();
            }

            this.jugadores[this.turno.quienNoToca()].haGanado(this.tablero);
        }

    }
}

