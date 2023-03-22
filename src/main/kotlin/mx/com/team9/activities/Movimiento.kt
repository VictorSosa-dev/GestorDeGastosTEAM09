package mx.com.team9.activities

import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import mx.com.team9.utils.TipoMovimiento
import java.time.LocalDateTime
/*
 * Clase abstracta que representa una transacción de una cuenta
 * Esta contiene atributos como:
 *  - Fecha de la transacción
 *  - Monto de la transacción
 *  - Descripcion de la transaccion
 *  - mx.com.team9.enums.Categoria de la transaccion
 *  - mx.com.team9.models.Cuenta de origen asociada a la transaccion
 */
abstract class Movimiento {
    abstract val fecha: LocalDateTime
    abstract val monto: Double
    abstract val cuentaOrigen: Cuenta
    abstract val descripcion: String
    abstract val categoria: Categoria
    abstract val tipo: TipoMovimiento

    abstract fun movimiento(monto: Double ,cuenta: Cuenta, tipo: TipoMovimiento, descripcion: String, categoria: Categoria)

    open fun logMovimientos() {
        println("Se ha realizado una transaccion de $monto en la cuenta {cuentaOrigen.numeroCuenta} con la categoria ${categoria.nombre}")
    }
}