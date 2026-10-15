import java.time.LocalDate;
import java.util.ArrayList;


public class CinePlus {


    private String nombreComercial;
    private String nit;
    private String direccion;


    private ArrayList<Sala> salas;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Funcion> funciones;
    private ArrayList<Cliente> clientes;
    private ArrayList<Operario> operarios;
    private ArrayList<Venta> ventas;

    /**
     * metodo cineplus
     * @param nombreComercial
     * @param nit
     * @param direccion
     */

    public CinePlus(String nombreComercial, String nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.salas = new ArrayList<Sala>();
        this.peliculas = new ArrayList<Pelicula>();
        this.funciones = new ArrayList<Funcion>();
        this.clientes = new ArrayList<Cliente>();
        this.operarios = new ArrayList<Operario>();
        this.ventas = new ArrayList<Venta>();
    }


    /**
     * metodo Crea una pelicula solo si no existe otra con el mismo codigo.
     * @param p
     * @return
     */
    public boolean crearPelicula(Pelicula p) {
        if (buscarPeliculaPorCodigo(p.getCodigo()) != null) {
            return false;
        }
        peliculas.add(p);
        return true;
    }

    public ArrayList<Pelicula> listarPeliculas() {
        return peliculas;
    }

    /**
     * metodo buscarPelicula
     * @param codigo
     * @return
     */
    public Pelicula buscarPeliculaPorCodigo(String codigo) {
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p = peliculas.get(i);
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * metodo actualizarPelicula
     * @param codigo
     * @param nuevoTitulo
     * @param nuevaDuracion
     * @param nuevoGenero
     * @param nuevaClasificacion
     * @return
     */

    public boolean actualizarPelicula(String codigo, String nuevoTitulo, int nuevaDuracion,
                                      GeneroPelicula nuevoGenero, ClasificacionEdad nuevaClasificacion) {
        Pelicula p = buscarPeliculaPorCodigo(codigo);
        if (p == null) {
            return false;
        }
        p.setTitulo(nuevoTitulo);
        p.setDuracionMinutos(nuevaDuracion);
        p.setGenero(nuevoGenero);
        p.setClasificacion(nuevaClasificacion);
        return true;
    }

    /**
     * metodo eliminarPelicula
     * @param codigo
     * @return
     */
    public boolean eliminarPelicula(String codigo) {
        Pelicula p = buscarPeliculaPorCodigo(codigo);
        if (p == null) {
            return false;
        }
        peliculas.remove(p);
        return true;
    }

    /**
     * metodo crearSala
     * @param s
     * @return
     */

    public boolean crearSala(Sala s) {
        if (buscarSalaPorCodigo(s.getCodigo()) != null) {
            return false;
        }
        salas.add(s);
        return true;
    }

    public ArrayList<Sala> listarSalas() {
        return salas;
    }

    /**
     * metodo buscarSalaPorCodigo
     * @param codigo
     * @return
     */

    public Sala buscarSalaPorCodigo(String codigo) {
        for (int i = 0; i < salas.size(); i++) {
            Sala s = salas.get(i);
            if (s.getCodigo().equals(codigo)) {
                return s;
            }
        }
        return null;
    }

    /**
     * metodo actualizarNombreSala
     * @param codigo
     * @param nuevoNombre
     * @return
     */

    public boolean actualizarNombreSala(String codigo, String nuevoNombre) {
        Sala s = buscarSalaPorCodigo(codigo);
        if (s == null) {
            return false;
        }
        s.setNombre(nuevoNombre);
        return true;
    }

    /**
     * metodo eliminarSala
     * @param codigo
     * @return
     */

    public boolean eliminarSala(String codigo) {
        Sala s = buscarSalaPorCodigo(codigo);
        if (s == null) {
            return false;
        }
        salas.remove(s);
        return true;
    }

    /**
     * metodo  Crea un cliente solo si no existe otra persona con el mismo documento.
     * @param c
     * @return
     */


    public boolean crearCliente(Cliente c) {
        if (buscarClientePorDocumento(c.getDocumentoIdentidad()) != null) {
            return false;
        }
        clientes.add(c);
        return true;
    }

    public ArrayList<Cliente> listarClientes() {
        return clientes;
    }

    /**
     * metodo de  buscarClientePorDocumento
     * @param documento
     * @return
     */
    public Cliente buscarClientePorDocumento(String documento) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getDocumentoIdentidad().equals(documento)) {
                return c;
            }
        }
        return null;
    }

    /**
     * metodo actualizarCliente
     * @param documento
     * @param nuevoCorreo
     * @param nuevoTelefono
     * @param nuevoDescuento
     * @return
     */

    public boolean actualizarCliente(String documento, String nuevoCorreo, String nuevoTelefono,
                                     double nuevoDescuento) {
        Cliente c = buscarClientePorDocumento(documento);
        if (c == null) {
            return false;
        }
        c.setCorreoElectronico(nuevoCorreo);
        c.setTelefono(nuevoTelefono);
        c.setPorcentajeDescuento(nuevoDescuento);
        return true;
    }

    /**
     * metodo de eliminarCliente
     * @param documento
     * @return
     */

    // Elimina un cliente (solo si no tiene compras registradas).
    public boolean eliminarCliente (String documento) {
        Cliente c = buscarClientePorDocumento(documento);
        if (c == null) {
            return false;
        }
        if (c.getCompras().size() > 0) {
            return false;
        }
        clientes.remove(c);
        return true;
    }


    /**
     * metodo crearOperario
     * @param o
     * @return
     */
    public boolean crearOperario(Operario o) {
        if (buscarOperarioPorDocumento(o.getDocumentoIdentidad()) != null) {
            return false;
        }
        operarios.add(o);
        return true;
    }

    public ArrayList<Operario> listarOperarios() {
        return operarios;
    }

    /**
     * metodo buscarOperarioPorDocumento
     * @param documento
     * @return
     */
    public Operario buscarOperarioPorDocumento(String documento) {
        for (int i = 0; i < operarios.size(); i++) {
            Operario o = operarios.get(i);
            if (o.getDocumentoIdentidad().equals(documento)) {
                return o;
            }
        }
        return null;
    }

    /**
     * metodo de actualizarOperario
     * @param documento
     * @param nuevoCorreo
     * @param nuevoTelefono
     * @param nuevoSalario
     * @return
     */

    public boolean actualizarOperario(String documento, String nuevoCorreo, String nuevoTelefono,
                                      double nuevoSalario) {
        Operario o = buscarOperarioPorDocumento(documento);
        if (o == null) {
            return false;
        }
        o.setCorreoElectronico(nuevoCorreo);
        o.setTelefono(nuevoTelefono);
        o.setSalarioBasico(nuevoSalario);
        return true;
    }

    /**
     * metodo de eliminarOperario
     * @param documento
     * @return
     */
    public boolean eliminarOperario(String documento) {
        Operario o = buscarOperarioPorDocumento(documento);
        if (o == null) {
            return false;
        }
        operarios.remove(o);
        return true;
    }

    /**
     * metodo de crearFuncion
     * @param nueva
     * @return
     */
    public boolean crearFuncion(Funcion nueva) {
        for (int i = 0; i < funciones.size(); i++) {
            Funcion existente = funciones.get(i);
            if (nueva.seSuperponeCon(existente)) {
                return false;
            }
        }
        funciones.add(nueva);
        return true;
    }

    public ArrayList<Funcion> listarFunciones() {
        return funciones;
    }

    /**
     * metodo de buscarFuncionPorCodigo
     * @param codigo
     * @return
     */
    public Funcion buscarFuncionPorCodigo(String codigo) {
        for (int i = 0; i < funciones.size(); i++) {
            Funcion f = funciones.get(i);
            if (f.getCodigo().equals(codigo)) {
                return f;
            }
        }
        return null;
    }

    /**
     * metodo de actualizarPrecioBaseFuncion
     * @param codigo
     * @param nuevoPrecio
     * @return
     */
    public boolean actualizarPrecioBaseFuncion(String codigo, double nuevoPrecio) {
        Funcion f = buscarFuncionPorCodigo(codigo);
        if (f == null) {
            return false;
        }
        f.setPrecioBase(nuevoPrecio);
        return true;
    }

    /**
     * metodo de  Elimina una funcion (solo si todavia no tiene ventas registradas)
     * @param codigo
     * @return
     */

    public boolean eliminarFuncion(String codigo) {
        Funcion f = buscarFuncionPorCodigo(codigo);
        if (f == null) {
            return false;
        }
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getFuncion().getCodigo().equals(codigo)) {
                return false; // ya tiene boletas vendidas, no se puede borrar
            }
        }
        funciones.remove(f);
        return true;
    }

    /**
     * metodo de asientoEstaOcupado
     * @param funcion
     * @param asiento
     * @return
     */
    public boolean asientoEstaOcupado(Funcion funcion, Asiento asiento) {
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            if (!v.getFuncion().getCodigo().equals(funcion.getCodigo())) {
                continue; // es de otra funcion, no bloquea
            }
            ArrayList<Boleta> boletasDeEsaVenta = v.getBoletas();
            for (int j = 0; j < boletasDeEsaVenta.size(); j++) {
                if (boletasDeEsaVenta.get(j).getAsiento().esIgualA(asiento)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo de registrarVenta
     * @param codigoVenta
     * @param operario
     * @param cliente
     * @param funcion
     * @param asientosSeleccionados
     * @return
     */
    public boolean registrarVenta(String codigoVenta, Operario operario, Cliente cliente, Funcion funcion,
                                  ArrayList<Asiento> asientosSeleccionados) {
        if (asientosSeleccionados.size() == 0) {
            return false; // una venta necesita minimo 1 boleta
        }
        for (int i = 0; i < asientosSeleccionados.size(); i++) {
            if (asientoEstaOcupado(funcion, asientosSeleccionados.get(i))) {
                return false; // al menos un asiento ya esta vendido para esta funcion
            }
        }

        Venta venta = new Venta(codigoVenta, operario, cliente, funcion);
        for (int i = 0; i < asientosSeleccionados.size(); i++) {
            Asiento asiento = asientosSeleccionados.get(i);
            double valor = funcion.calcularValorBoleta(cliente.getPorcentajeDescuento());
            String codigoBoleta = codigoVenta + "-B" + (i + 1);
            Boleta boleta = new Boleta(codigoBoleta, asiento, valor);
            venta.agregarBoleta(boleta);
        }

        ventas.add(venta);
        cliente.agregarCompra(venta);
        return true;
    }

    public ArrayList<Venta> listarVentas() {
        return ventas;
    }

    /**
     * metodo de buscarVentaPorCodigo
     * @param codigo
     * @return
     */
    public Venta buscarVentaPorCodigo(String codigo) {
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            if (v.getCodigo().equals(codigo)) {
                return v;
            }
        }
        return null;
    }

    /**
     * metodo de eliminarVenta
     * @param codigo
     * @return
     */
    public boolean eliminarVenta(String codigo) {
        Venta v = buscarVentaPorCodigo(codigo);
        if (v == null) {
            return false;
        }
        ventas.remove(v);
        v.getCliente().getCompras().remove(v);
        return true;
    }

    /**
     * metodo de calcularValorTotalVenta
     * @param codigoVenta
     * @return
     */
    public double calcularValorTotalVenta(String codigoVenta) {
        Venta v = buscarVentaPorCodigo(codigoVenta);
        if (v == null) {
            return -1.0;
        }
        return v.calcularValorTotal();
    }

    /**
     * metodo de calcularPorcentajeOcupacion
     * @param codigoFuncion
     * @return
     */
    public double calcularPorcentajeOcupacion(String codigoFuncion) {
        Funcion f = buscarFuncionPorCodigo(codigoFuncion);
        if (f == null) {
            return -1.0;
        }
        int boletasVendidas = 0;
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            if (v.getFuncion().getCodigo().equals(codigoFuncion)) {
                boletasVendidas = boletasVendidas + v.getBoletas().size();
            }
        }
        int capacidad = f.getSala().getCapacidadMaxima();
        if (capacidad == 0) {
            return 0.0;
        }
        double porcentaje = ((double) boletasVendidas / (double) capacidad) * 100.0;
        return porcentaje;
    }


    public String getNombreComercial() { return nombreComercial; }
    public String getNit() { return nit; }
    public String getDireccion() { return direccion; }
}