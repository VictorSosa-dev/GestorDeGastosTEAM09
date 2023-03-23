package mx.com.team9.activities

import mx.com.team9.models.Categoria

/**
 * Clase que representa un retiro de una cuenta
 */
class Gasto(
    override val monto: Double,
    override val descripcion: String,
    override val categoria: Categoria,
    override val cuentaOrigen: Cuenta
) : Movimiento() {


    init {
        cuentaOrigen.saldo -= monto
        logTransaccion()
    }
}