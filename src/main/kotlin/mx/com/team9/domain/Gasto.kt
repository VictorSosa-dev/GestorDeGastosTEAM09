package mx.com.team9.domain

import mx.com.team9.utils.Categoria
import java.time.LocalDateTime

/**
 * Clase que representa un retiro de una cuenta
 */

class Gasto(
    cuenta: Cuenta,
    monto: Double,
    descipcion: String,
    categoria: Categoria
) : Movimiento(cuenta, monto, descipcion, categoria) {

    override val idMovimiento: String = "ING-${cuenta.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()

    //Esta funcion puede ser una corutina TODO: POSIBLE IMPLEMENTACION CORUTINA
    override fun actualizarSaldo(): Boolean {
        println("INICIANDO TRANSACCION")
        println("CONECTANDO CON CUENTA ${cuenta.idCuenta}")
        (1..5).forEach {
            Thread.sleep(500)
            print("█")
        }
        cuenta.saldo -= monto
        return true
    }

}