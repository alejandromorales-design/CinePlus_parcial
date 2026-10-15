import java.util.ArrayList;

public class Sala {

    private String codigo;
    private String nombre;
    private int filas;
    private int columnas;
    private int capacidadMaxima;
    private TipoSala tipo;
    private ArrayList<Asiento> asientos;

    /**
     * metodo de  Sala
     * @param codigo
     * @param nombre
     * @param filas
     * @param columnas
     * @param tipo
     */

    public Sala(String codigo, String nombre, int filas, int columnas, TipoSala tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.capacidadMaxima = filas * columnas;
        this.tipo = tipo;
        this.asientos = new ArrayList<Asiento>();
        generarAsientos();
    }

    /**
     * metodo generarAsientos
     */
    private void generarAsientos() {
        for (int f = 1; f <= filas; f++) {
            for (int c = 1; c <= columnas; c++) {
                asientos.add(new Asiento(f, c));
            }
        }
    }

    /**
     * metodo  calcularRecargoPorTipo
     * @return
     */
    public double calcularRecargoPorTipo() {
        if (tipo == TipoSala.VIP) {
            return 0.30; // 30%
        } else if (tipo == TipoSala.TRES_D) {
            return 0.20; // 20%
        } else {
            return 0.0; // Tradicional: sin recargo
        }
    }

    /**
     * metodo de buscarAsiento
     * @param fila
     * @param columna
     * @return
     */
    public Asiento buscarAsiento(int fila, int columna) {
        for (int i = 0; i < asientos.size(); i++) {
            Asiento a = asientos.get(i);
            if (a.getFila() == fila && a.getColumna() == columna) {
                return a;
            }
        }
        return null;
    }


    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public TipoSala getTipo() { return tipo; }
    public ArrayList<Asiento> getAsientos() { return asientos; }

    // ---- Setters (para la opcion "Actualizar" del CRUD) ----
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String toString() {
        return "Sala " + codigo + " - " + nombre + " (" + tipo + ") - " + filas + "x" + columnas
                + " = " + capacidadMaxima + " puestos";
    }
}
