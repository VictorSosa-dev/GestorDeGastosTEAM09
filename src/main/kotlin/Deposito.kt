import java.time.LocalDateTime

class Deposito : Transaccion() {
    override val fecha: LocalDateTime
        get() = TODO("Se podria obtener la fecha de forma automatica")
    override val monto: Double
        get() = TODO("Not yet implemented")
    override val descripcion: String
        get() = TODO("Not yet implemented")
    override val cuentaOrigen: Cuenta
        get() = TODO("Not yet implemented")
    override val categoria: Categoria
        get() = TODO("Not yet implemented")
}