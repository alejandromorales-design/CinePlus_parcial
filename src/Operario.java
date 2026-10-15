import java.time.LocalDate;

// Hereda de Persona (extends) y le agrega los datos propios de un operario:
// codigo de empleado, fecha de contratacion y salario basico.
// Los operarios son quienes registran las ventas en taquilla

public class Operario extends Persona {

    private String codigoEmpleado;
    private LocalDate fechaContratacion;
    private double salarioBasico;

    /**
     *
     * @param documentoIdentidad
     * @param nombreCompleto
     * @param correoElectronico
     * @param telefono
     * @param codigoEmpleado
     * @param fechaContratacion
     * @param salarioBasico
     */
    public Operario(String documentoIdentidad, String nombreCompleto, String correoElectronico, String telefono,
                    String codigoEmpleado, LocalDate fechaContratacion, double salarioBasico) {
        super(documentoIdentidad, nombreCompleto, correoElectronico, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
    }

    // ---- Getters ----
    public String getCodigoEmpleado() { return codigoEmpleado; }
    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public double getSalarioBasico() { return salarioBasico; }

    // ---- Setters ----
    public void setSalarioBasico(double salarioBasico) { this.salarioBasico = salarioBasico; }

    public String toString() {
        return "Operario [" + codigoEmpleado + "] " + super.toString() + " - Contratado: " + fechaContratacion;
    }
}

