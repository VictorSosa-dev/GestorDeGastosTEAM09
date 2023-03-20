package mx.com.team9.activities

import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import mx.com.team9.utils.TipoMovimiento
import java.time.LocalDateTime

class Deposito(
    override val monto: Double,
    override val descripcion: String,
    override val categoria: Categoria,
    override val cuentaOrigen: Cuenta
) : Transaccion() {
    override val fecha: LocalDateTime
        get() = LocalDateTime.now()

    init {
        cuentaOrigen.saldo += monto
        logTransaccion()
    }
}