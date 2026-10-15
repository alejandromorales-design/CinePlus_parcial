
public class Boleta {

    private String codigo;
    private Asiento asiento;
    private double valorPagado;

    /**
     * metodo de Boleta
     * @param codigo
     * @param asiento
     * @param valorPagado
     */
    public Boleta(String codigo, Asiento asiento, double valorPagado) {
        this.codigo = codigo;
        this.asiento = asiento;
        this.valorPagado = valorPagado;
    }

    // ---- Getters ----
    public String getCodigo() { return codigo; }
    public Asiento getAsiento() { return asiento; }
    public double getValorPagado() { return valorPagado; }

    public String toString() {
        return "Boleta " + codigo + " - " + asiento + " - $" + (long) valorPagado;
    }
}
