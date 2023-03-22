package mx.com.team9.models

import mx.com.team9.activities.Movimiento
import java.util.Date
import java.util.UUID

class Cuenta(
    val idCuenta: String,
    var saldo: Double,
    val fechaCreacion: Date,
    val usuario: Usuario,
    var movimientos: MutableList<Movimiento>
) {

    init {
        println("Se ha creado la cuenta $idCuenta")
        saldo = 0.0
    }

    fun consultaSaldo() {
        println("El saldo de la cuenta es: $saldo")
    }

    fun crearCuenta(usuario: Usuario) {
        val cuenta = Cuenta(UUID.randomUUID().toString(), saldo, Date(), usuario, mutableListOf())
        usuario.cuentas.add(cuenta)
    }

}