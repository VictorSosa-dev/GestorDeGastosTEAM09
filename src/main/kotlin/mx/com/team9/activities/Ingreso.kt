package mx.com.team9.activities

import mx.com.team9.models.Categoria

class Ingreso(
    override val monto: Double,
    override val descripcion: String,
    override val categoria: Categoria,
    override val cuentaOrigen: Cuenta
) : Movimiento() {
    init {
        cuentaOrigen.saldo += monto
        logTransaccion()
    }
}