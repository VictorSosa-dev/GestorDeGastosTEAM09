package mx.com.team9.activities

import java.time.LocalDateTime
import java.util.*

/*  mx.com.team9.models.Cuenta.kt tendra los atributos para poder manejar las cuentas de los usuarios y las
    operaciones que se pueden realizar en ellas.

    Posible atributos:
    - Numero de cuenta
    - Saldo
    - Tipo de cuenta
    - Fecha de creacion
    - Estado de la cuenta
    - Usuario
    - Movimientos

    */


class Cuenta(
    val idCuenta: String,
    var saldo: Double,
    val tipoCuenta: String,
    val estadoCuenta: String,
    val usuario: Usuario,
    val transacciones: MutableList<Movimiento>?
) {
    lateinit var fechaCreacion: LocalDateTime


    init {
        fechaCreacion = LocalDateTime.now()
        println("Se ha creado la cuenta $idCuenta")
        saldo = 0.0
    }

    fun consultaSaldo() {
        println("El saldo de la cuenta es: $saldo")
    }

}