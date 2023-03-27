package mx.com.team9.domain

import mx.com.team9.utils.TipoCategoria
import java.time.LocalDateTime

/**
 * Clase que representa un retiro de una cuenta
 */

class Gasto(
    cuenta: Cuenta,
    monto: Double,
    descipcion: String,
    categoria: TipoCategoria
) : Movimiento(cuenta, monto, descipcion, categoria) {

    override val idMovimiento: String = "ING-${cuenta.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()

    //Esta funcion puede ser una corutina TODO: POSIBLE IMPLEMENTACION CORUTINA
    override fun actualizarSaldo(): Boolean {
        cuenta.saldo -= monto
        return true
    }
}