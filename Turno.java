package TER;

public class Turno {
    private int turno = 0;

    public Turno() {
    }

    public int quienToca() {
        return this.turno;
    }

    public int quienNoToca() {
        return (this.turno + 1) % 2;
    }

    public void cambiar() {
        this.turno = (this.turno + 1) % 2;
    }
}

