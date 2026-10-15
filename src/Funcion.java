import java.time.LocalDate;
import java.time.LocalTime;


public class Funcion {

    private String codigo;
    private LocalDate fechaPresentacion;
    private LocalTime horaInicio;
    private double precioBase;
    private Pelicula pelicula;
    private Sala sala;

    /**
     *metodo de Funcion
     * @param codigo
     * @param fechaPresentacion
     * @param horaInicio
     * @param precioBase
     * @param pelicula
     * @param sala
     */
    public Funcion(String codigo, LocalDate fechaPresentacion, LocalTime horaInicio, double precioBase,
                   Pelicula pelicula, Sala sala) {
        this.codigo = codigo;
        this.fechaPresentacion = fechaPresentacion;
        this.horaInicio = horaInicio;
        this.precioBase = precioBase;
        this.pelicula = pelicula;
        this.sala = sala;
    }


    public LocalTime getHoraFin() {
        return horaInicio.plusMinutes(pelicula.getDuracionMinutos());
    }

    /**
     * metodo de seSuperponeCon
     * @param otra
     * @return
     */
    public boolean seSuperponeCon(Funcion otra) {
        if (!this.sala.getCodigo().equals(otra.sala.getCodigo())) {
            return false; // salas distintas, no hay conflicto
        }
        if (!this.fechaPresentacion.equals(otra.fechaPresentacion)) {
            return false; // fechas distintas, no hay conflicto
        }
        boolean seSolapan = this.horaInicio.isBefore(otra.getHoraFin()) && otra.horaInicio.isBefore(this.getHoraFin());
        return seSolapan;
    }

    /**
     * metodo de calcularValorBoleta
     * @param porcentajeDescuentoCliente
     * @return
     */
    public double calcularValorBoleta(double porcentajeDescuentoCliente) {
        double recargo = sala.calcularRecargoPorTipo();
        double valorConRecargo = precioBase + (precioBase * recargo);
        double valorFinal = valorConRecargo - (valorConRecargo * porcentajeDescuentoCliente);
        return valorFinal;
    }


    public String getCodigo() { return codigo; }
    public LocalDate getFechaPresentacion() { return fechaPresentacion; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public double getPrecioBase() { return precioBase; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }

    // ---- Setters (para la opcion "Actualizar" del CRUD) ----
    public void setPrecioBase(double precioBase) { this.precioBase = precioBase; }

    public String toString() {
        return "[" + codigo + "] " + pelicula.getTitulo() + " - " + fechaPresentacion + " " + horaInicio
                + " - Sala " + sala.getCodigo() + " - Base: $" + (long) precioBase;
    }
}