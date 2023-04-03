package mx.com.team9.domain

import mx.com.team9.models.Categoria
import java.time.LocalDateTime

/**
 * Clase que representa un retiro de una cuenta
 */

class Gasto(
    cuenta: Cuenta,
    monto: Double,
    descipcion: String,
    categoria: Categoria
) : Movimiento(cuenta, monto, descipcion, categoria), IMovimientoMock {

    override val idMovimiento: String = "GAST-${cuenta.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()

    override fun actualizarSaldo(): Boolean {
        println("INICIANDO TRANSACCION")
        println("CONECTANDO CON CUENTA ${cuenta.nombre}")
        (1..5).forEach {
            Thread.sleep(500)
            
            print("█")
        }
        println("☑")
        println()
        cuenta.saldo -= monto
        return true
    }

    override fun actualizacionRapidaMock() {
        cuenta.saldo -= monto
    }

}