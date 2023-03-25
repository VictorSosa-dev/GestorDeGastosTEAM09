package mx.com.team9.activities

import mx.com.team9.models.Categoria
import java.time.LocalDateTime

/*
 * Clase abstracta que representa una transacción de una cuenta
 * Esta contiene atributos como:
 *  - Fecha de la transacción
 *  - Monto de la transacción
 *  - Descripcion de la transaccion
 *  - mx.com.team9.enums.Categoria de la transaccion
 *  - mx.com.team9.activities.Cuenta de origen asociada a la transaccion
 */
abstract class Movimiento(
    val cuenta: Cuenta,
    val monto: Double,
    val descripcion: String,
    val categoria: Categoria
) {
    abstract fun actualizarSaldo()

    fun realizarMovimiento() {
        actualizarSaldo()
    }
    val fecha: LocalDateTime
        get() = LocalDateTime.now()

    /**
     * Funcion que imprime en consola la transaccion realizada
     */
    fun logTransaccion() {
        println("Se ha realizado una transaccion de $monto en la cuenta {cuentaOrigen.numeroCuenta} con la categoria ${categoria.nombre}")
    }
}