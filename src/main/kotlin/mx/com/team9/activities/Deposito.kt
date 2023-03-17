package mx.com.team9.activities

import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import mx.com.team9.utils.TipoMovimiento
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
    override val tipo: TipoMovimiento
        get() = TODO("Not yet implemented")

    override fun movimiento(
        monto: Double,
        cuenta: Cuenta,
        tipo: TipoMovimiento,
        descripcion: String,
        categoria: Categoria
    ) {
        TODO("Not yet implemented")
    }

    override fun logTransaccion() {
        println("Se ha realizado un deposito de $monto en la cuenta {cuentaOrigen.numeroCuenta} con la categoria ${categoria.nombre}")
    }
}