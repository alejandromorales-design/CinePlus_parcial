
public class Pelicula {

    private String codigo;
    private String titulo;
    private int duracionMinutos;
    private GeneroPelicula genero;
    private ClasificacionEdad clasificacion;

    /**
     * metodo de Pelicula
     * @param codigo
     * @param titulo
     * @param duracionMinutos
     * @param genero
     * @param clasificacion
     */
    public Pelicula(String codigo, String titulo, int duracionMinutos, GeneroPelicula genero,
                    ClasificacionEdad clasificacion) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.genero = genero;
        this.clasificacion = clasificacion;
    }


    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public GeneroPelicula getGenero() { return genero; }
    public ClasificacionEdad getClasificacion() { return clasificacion; }

    // ---- Setters (para la opcion "Actualizar" del CRUD) ----
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public void setGenero(GeneroPelicula genero) { this.genero = genero; }
    public void setClasificacion(ClasificacionEdad clasificacion) { this.clasificacion = clasificacion; }

    public String toString() {
        return "[" + codigo + "] " + titulo + " - " + duracionMinutos + " min - " + genero + " - " + clasificacion;
    }
}