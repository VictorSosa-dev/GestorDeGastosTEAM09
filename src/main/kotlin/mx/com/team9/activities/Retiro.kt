package mx.com.team9.activities

import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import java.time.LocalDateTime

/**
 * Clase que representa un retiro de una cuenta
 */
class Retiro(
    override val monto: Double,
    override val descripcion: String,
    override val categoria: Categoria,
    override val cuentaOrigen: Cuenta
) : Transaccion() {


    init {
        cuentaOrigen.saldo -= monto
        logTransaccion()
    }
}