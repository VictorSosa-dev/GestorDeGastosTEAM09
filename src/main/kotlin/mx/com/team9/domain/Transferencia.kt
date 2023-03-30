package mx.com.team9.domain

import mx.com.team9.utils.Categoria
import java.time.LocalDateTime

class Transferencia(
    val cuentaOrigen: Cuenta,
    val cuentaDestino: Cuenta,
    monto: Double,
    descripcion: String,
    categoria: Categoria
) : Movimiento(cuentaOrigen, monto, descripcion, categoria) {

    override val idMovimiento: String = "TRAN-${cuentaOrigen.idCuenta}-${cuentaDestino.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()
    override fun actualizarSaldo(): Boolean {
        println("INICIANDO PROCESO DE TRANSFERENCIA")
        println("VERIFICANDO QUE HAYA SALDO SUFICIENTE EN LA CUENTA ORIGEN")
        if (cuenta.saldo < monto) {
            (1..5).forEach {
                Thread.sleep(500)
                print("█")
            }
            print("☒")
            println("\nNO HAY SALDO SUFICIENTE EN LA CUENTA ORIGEN")
            Thread.sleep(1000)
            return false
        } else {
            println("SALDO SUFICIENTE EN LA CUENTA ORIGEN")
        }
        cuentaOrigen.saldo -= monto
        cuentaDestino.saldo += monto
        println("REALIZANDO TRANSACCION")
        (1..5).forEach {
            Thread.sleep(500)
            print("█")
        }
        print("☑")
        println("\nTRANSFERENCIA REALIZADA CON EXITO")
        Thread.sleep(1000)
        return true
    }
}