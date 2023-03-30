package mx.com.team9.controllers

import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarOpcionesPrincipal

object SistemaPrincipalController {
    lateinit var usuario: Usuario
    //Logica de Manejo de Cuenta
    fun sistemaPrincipal(usuario: Usuario) {
        this.usuario = usuario
        do {
            mostrarOpcionesPrincipal(usuario)
            var opcion = readln().toIntOrNull() ?: 0
            when (opcion) {
                1 -> { // reportes  -> resumen mensual, ultimos movimientos

                }
                // Manejo de cuentas -> consultar saldo, consultar movimientos, agregar cuenta, eliminar cuenta
                2 -> CuentasController.manejoCuentas(usuario)

                3 -> { // Realizar movimientos -> ingreso, gasto, transferencia
                    MovimientosController.seleccionarMovimiento(usuario)
                }

                4 -> { // DELOGUERASE
                    println("DESLOGUEANDO")
                    Utilidades.limpiarPantalla()
                    AutenticacionController.menuAutenticacion()
                }

                else -> {
                    println("POR FAVOR, INGRESE UNA OPCION VALIDA")
                    Thread.sleep(1000)
                    Utilidades.limpiarPantalla()
                }
            }
        } while (opcion != 4)
    }
}