package mx.com.team9.domain

import mx.com.team9.models.Categoria
import mx.com.team9.utils.TipoCategoria
import java.time.LocalDateTime

// Clase abstracta que representa una transacción de una cuenta
abstract class Movimiento(
    val cuenta: Cuenta,
    val monto: Double,
    val descripcion: String,
    val categoria: TipoCategoria
) {
    //Propiedades abstractas neceserias de implementar, las cuales
    // generaran en automatico en su inicializacion
    abstract val idMovimiento: String
    abstract val fecha: LocalDateTime

    // Funcion abstracta que actualiza el saldo de la cuenta ya sea para ingresos, gastos
    abstract fun actualizarSaldo(): Boolean

    //como ocupar esta funcion?
//    fun realizarMovimiento() {
//        actualizarSaldo()
//    }

    override fun toString(): String {
        return "Movimiento(idMovimiento='$idMovimiento'\n, fecha=$fecha\n," +
                " cuenta=$cuenta\n, monto=$monto\n, descripcion='$descripcion'\n," +
                " categoria=$categoria\n)"
    }

    // Funcion que imprime en consola la transaccion realizada
    fun logTransaccion() {
        println("Se ha realizado una transaccion de $monto en la cuenta ${cuenta.idCuenta} con la categoria ${categoria.name}")
    }
}