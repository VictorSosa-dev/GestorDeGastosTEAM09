package mx.com.team9.domain;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String idCuenta;
    private double saldo;

    public List<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(List<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    private String nombre;
    private List<Movimiento> listaMovimientos;
    private Usuario usuario;
    private LocalDateTime fechaCreacion;

    public Cuenta(String idCuenta, double saldo, String nombre) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.nombre = nombre;
        this.listaMovimientos = new ArrayList<Movimiento>();
        this.fechaCreacion = LocalDateTime.now();
    }

    public void consultaSaldo() {
        System.out.println("EL SALDO DE LA CUENTA ES: " + saldo);
    }

    public List<Movimiento> obtenerMovimientos() {
        return listaMovimientos;
    }

    // getters y setters
    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}