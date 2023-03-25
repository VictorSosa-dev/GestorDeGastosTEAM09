package mx.com.team9.activities

import mx.com.team9.models.Categoria

/**
 * Clase que representa un retiro de una cuenta
 */

class Gasto(
    cuenta: Cuenta,
    monto: Double,
    descipcion: String,
    categoria: Categoria
) : Movimiento(cuenta, monto, descipcion, categoria) {
    override fun actualizarSaldo() {
        cuenta.saldo -= monto
    }
}