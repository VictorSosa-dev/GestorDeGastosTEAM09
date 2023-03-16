import java.time.LocalDateTime
/**
 * Clase que representa un retiro de una cuenta
 */
class Retiro : Transaccion() {
    override val fecha: LocalDateTime
        get() = TODO("Not yet implemented")
    override val monto: Double
        get() = TODO("Not yet implemented")
    override val descripcion: String
        get() = TODO("Not yet implemented")
    override val cuentaOrigen: Cuenta
        get() = TODO("Not yet implemented")
    override val categoria: Categoria
        get() = TODO("Not yet implemented")
}