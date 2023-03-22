package mx.com.team9.activities

import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import mx.com.team9.utils.TipoMovimiento
import java.time.LocalDateTime
import java.util.*

/*
 * Clase abstracta que representa una transacción de una cuenta
 * Esta contiene atributos como:
 *  - Fecha de la transacción
 *  - Monto de la transacción
 *  - Descripcion de la transaccion
 *  - mx.com.team9.enums.Categoria de la transaccion
 *  - mx.com.team9.models.Cuenta de origen asociada a la transaccion
 */
abstract class Transaccion {

    abstract val monto: Double
    abstract val descripcion: String
    abstract val categoria: Categoria
    abstract val cuentaOrigen: Cuenta
    val id: String
        get() = UUID.randomUUID().toString()

    val fecha: LocalDateTime
        get() = LocalDateTime.now()

    /*
    @Victor: Tambien pense en una funcion abstracta que se encargara de realizar el movimiento
     pero no serviria mucho al momento de implementar las funciones en las clases Deposito y Retiro
     Podriamos comentarlo en al session de hoy:
        1) tener la clase abstracta con la funcion abstracta movimientos, y que se implemente en
            cada clase Deposito y Retiro
        2) Tener la clase Transaccion, y tener interfaces llamadas Deposito, Retiro que agreguen la
        funcion deposito y retiro  respectivamente.
     */

//    abstract fun movimiento(monto: Double ,cuenta: Cuenta, tipo: TipoMovimiento, descripcion: String, categoria: Categoria)

    /**
     * Funcion que imprime en consola la transaccion realizada
     */
    fun logTransaccion() {
        println("Se ha realizado una transaccion de $monto en la cuenta {cuentaOrigen.numeroCuenta} con la categoria ${categoria.nombre}")
    }
}