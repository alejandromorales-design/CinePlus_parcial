import java.util.ArrayList;

// Hereda de Persona (extends) y le agrega los datos propios de un cliente:
// codigo de afiliacion y porcentaje de descuento sobre sus compras.



public class Cliente extends Persona {

    private String codigoAfiliacion;
    private double porcentajeDescuento; // valor entre 0.0 y 1.0 (0% a 100%)
    private ArrayList<Venta> compras;

    public Cliente(String documentoIdentidad, String nombreCompleto, String correoElectronico, String telefono,
                   String codigoAfiliacion, double porcentajeDescuento) {
        super(documentoIdentidad, nombreCompleto, correoElectronico, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.compras = new ArrayList<Venta>();
    }

    // Guarda en la lista del cliente una venta que CinePlus acaba de crear

    public void agregarCompra(Venta venta) {
        compras.add(venta);
    }

    public String getCodigoAfiliacion() { return codigoAfiliacion; }
    public double getPorcentajeDescuento() { return porcentajeDescuento; }
    public ArrayList<Venta> getCompras() { return compras; }


    public void setPorcentajeDescuento(double porcentajeDescuento) { this.porcentajeDescuento = porcentajeDescuento; }

    public String toString() {
        long descuentoTexto = (long) (porcentajeDescuento * 100);
        return "Cliente [" + codigoAfiliacion + "] " + super.toString() + " - Descuento: " + descuentoTexto + "%";
    }
}

