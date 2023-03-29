package mx.com.team9.domain

import mx.com.team9.utils.Categoria
import java.time.LocalDateTime

class Ingreso(
    cuenta: Cuenta,
    monto: Double,
    descripcion: String,
    categoria: Categoria
) : Movimiento(cuenta, monto, descripcion, categoria) {

    override val idMovimiento: String = "ING-${cuenta.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()

    override fun actualizarSaldo(): Boolean {
        println("INICIANDO TRANSACCION")
        println("CONECTANDO CON CUENTA ${cuenta.idCuenta}")
        (1..5).forEach {
            Thread.sleep(500)
            print("█")
        }
        cuenta.saldo += monto
        return true
    }

}
