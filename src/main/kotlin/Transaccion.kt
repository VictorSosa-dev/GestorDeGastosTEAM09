import java.time.LocalDateTime
/*
 * Clase abstracta que representa una transacción de una cuenta
 * Esta contiene atributos como:
 *  - Fecha de la transacción
 *  - Monto de la transacción
 *  - Descripcion de la transaccion
 *  - Categoria de la transaccion
 *  - Cuenta de origen asociada a la transaccion
 */
abstract class Transaccion {
    abstract val fecha: LocalDateTime
    abstract val monto: Double
    abstract val descripcion: String
    abstract val cuentaOrigen: Cuenta
    abstract val categoria: Categoria

    fun logTransaccion() {
        println("Se ha realizado una transaccion de $monto en la cuenta {cuentaOrigen.numeroCuenta} con la categoria ${categoria.nombre}")
    }
}