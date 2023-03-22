package mx.com.team9.models

import mx.com.team9.activities.Transaccion
import java.time.LocalDateTime
import java.util.Date

/*  mx.com.team9.models.Cuenta.kt tendra los atributos para poder manejar las cuentas de los usuarios y las
    operaciones que se pueden realizar en ellas.

    Posible atributos:
    - Numero de cuenta
    - Saldo
    - Tipo de cuenta
    - Fecha de creacion
    - Fecha de modificacion
    - Fecha de eliminacion
    - Estado de la cuenta
    - Usuario
    - Transacciones

    Posibles Operaciones:
    - mx.com.team9.activities.Deposito
    - mx.com.team9.activities.Retiro
    - Transferencia
    - Consulta de saldo
    - Consulta de transacciones
    - Consulta de estado de cuenta
    - Consulta de fecha de creacion
    - Consulta de fecha de modificacion
    - Consulta de fecha de eliminacion
    - Consulta de tipo de cuenta
    - Consulta de usuario


*/
class Cuenta(
    val numeroCuenta: String,
    var saldo: Double,
    val tipoCuenta: String,
    val estadoCuenta: String,
    val usuario: User,
    val transacciones: MutableList<Transaccion>?
) {
    lateinit var  fechaCreacion: LocalDateTime

    lateinit var fechaModificacion: LocalDateTime

    lateinit var fechaEliminacion: LocalDateTime

    init {
        fechaCreacion = LocalDateTime.now()
        println("Se ha creado la cuenta $numeroCuenta")
        saldo = 0.0
    }

    fun consultaSaldo() {
        println("El saldo de la cuenta es: $saldo")
    }

    fun consultaTransacciones() {
        println("Las transacciones de la cuenta son: $transacciones")
    }

    fun consultaEstadoCuenta() {
        println("El estado de la cuenta es: $estadoCuenta")
    }

    fun deposito(monto: Double) {
        saldo += monto
    }

    fun retiro(monto: Double) {
        saldo -= monto
    }

    fun transferencia(monto: Double, cuentaDestino: Cuenta) {
        saldo -= monto
        cuentaDestino.saldo += monto
    }

}