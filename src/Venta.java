import java.time.LocalDate;
import java.util.ArrayList;


public class Venta {

    private String codigo;
    private LocalDate fechaRealizacion;
    private Operario operario;
    private Cliente cliente;
    private Funcion funcion;
    private ArrayList<Boleta> boletas;

    /**
     * metodo de Venta
     * @param codigo
     * @param operario
     * @param cliente
     * @param funcion
     */
    public Venta(String codigo, Operario operario, Cliente cliente, Funcion funcion) {
        this.codigo = codigo;
        this.fechaRealizacion = LocalDate.now();
        this.operario = operario;
        this.cliente = cliente;
        this.funcion = funcion;
        this.boletas = new ArrayList<Boleta>();
    }

    public void agregarBoleta(Boleta boleta) {
        boletas.add(boleta);
    }

    /**
     * metodo de Suma el valor pagado de todas las boletas de esta venta
     * @return
     */
    public double calcularValorTotal() {
        double total = 0.0;
        for (int i = 0; i < boletas.size(); i++) {
            total = total + boletas.get(i).getValorPagado();
        }
        return total;
    }


    public String getCodigo() { return codigo; }
    public LocalDate getFechaRealizacion() { return fechaRealizacion; }
    public Operario getOperario() { return operario; }
    public Cliente getCliente() { return cliente; }
    public Funcion getFuncion() { return funcion; }
    public ArrayList<Boleta> getBoletas() { return boletas; }

    public String toString() {
        return "Venta " + codigo + " - " + fechaRealizacion + " - Cliente: " + cliente.getNombreCompleto()
                + " - Funcion: " + funcion.getCodigo() + " - " + boletas.size() + " boleta(s) - Total: $"
                + (long) calcularValorTotal();
    }
}
