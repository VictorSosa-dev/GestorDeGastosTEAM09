package mx.com.team9.domain

import mx.com.team9.models.Categoria
import java.time.LocalDateTime

class Ingreso(
    cuenta: Cuenta,
    monto: Double,
    descripcion: String,
    categoria: Categoria
) : Movimiento(cuenta, monto, descripcion, categoria), IMovimientoMock {

    override val idMovimiento: String = "ING-${cuenta.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()

    override fun actualizarSaldo(): Boolean {
        println("INICIANDO TRANSACCION")
        println("CONECTANDO CON CUENTA ${cuenta.nombre}")
        (1..5).forEach {
            Thread.sleep(500)
            print("█")
        }
        print("☑")
        println()
        cuenta.saldo += monto
        return true
    }

    override fun actualizacionRapidaMock() {
        cuenta.saldo += monto
    }


}
