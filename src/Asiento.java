// Cada Sala genera automaticamente sus asientos (fila x columna) al crearse.
// Cada Boleta queda ligada a un Asiento especifico.

public class Asiento {

    private int fila;
    private int columna;

    public Asiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // Compara si dos asientos son el mismo puesto (misma fila y columna).

    public boolean esIgualA(Asiento otro) {
        return this.fila == otro.fila && this.columna == otro.columna;
    }


    public int getFila() { return fila; }
    public int getColumna() { return columna; }

    public String toString() {
        return "Fila " + fila + " - Puesto " + columna;
    }
}

