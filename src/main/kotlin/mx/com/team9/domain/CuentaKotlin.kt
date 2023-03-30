package mx.com.team9.domain

import java.time.LocalDateTime

class CuentaKotlin(
    val idCuenta: String,
    //TODO: AGREGAR NOMBRE DE CUENTA
    var saldo: Double,
    var nombre: String,
) {
    val listaMovimientos =  mutableListOf<Movimiento>()

    lateinit var usuario: Usuario

    val fechaCreacion: LocalDateTime = LocalDateTime.now()

    fun consultaSaldo() {
        println("El saldo de la cuenta es: $saldo")
    }

    // consultar los movimientos de la cuenta
    fun obtenerMovimientos(): List<Movimiento> {
        return listaMovimientos
    }
}
