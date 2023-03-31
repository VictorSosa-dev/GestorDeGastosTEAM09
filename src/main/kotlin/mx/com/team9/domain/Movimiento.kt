package mx.com.team9.domain

import mx.com.team9.models.Categoria
import mx.com.team9.utils.Utilidades
import java.time.LocalDateTime

// Clase abstracta que representa una transacción de una cuenta
abstract class Movimiento(
    val cuenta: Cuenta,
    val monto: Double,
    val descripcion: String,
    val categoria: Categoria
) {

    companion object {
        fun validarMonto(tipoMovimiento: String): Double {
            print("INGRESA EL MONTO DE TU $tipoMovimiento: $")
            var monto = readln()?.toDoubleOrNull() ?: 0.0
            //si el gasto es menor o igual a 0, no se puede realizar el movimiento
            while (monto <= 0.0) {
                println("\nTU $tipoMovimiento DEBE SER MAYOR A 0")
                Utilidades.limpiarPantalla()
                print("INGRESA EL MONTO DE TU $tipoMovimiento: $")
                monto = readln()?.toDoubleOrNull() ?: 0.0
            }
            println()
            return monto
        }
    }
    //Propiedades abstractas neceserias de implementar, las cuales
    // generaran en automatico en su inicializacion
    abstract val idMovimiento: String
    abstract val fecha: LocalDateTime

    // Funcion abstracta que actualiza el saldo de la cuenta ya sea para ingresos, gastos
    abstract fun actualizarSaldo(): Boolean

}