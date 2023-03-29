package mx.com.team9.controllers

import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarOpcionesPrincipal

object SistemaPrincipalController {
    lateinit var usuario: Usuario
    //Logica de Manejo de Cuenta
    fun sistemaPrincipal(usuario: Usuario) {
        this.usuario = usuario

        mostrarOpcionesPrincipal(usuario)
        println("Selecciona una opcion:")
        var opcion = readln().toInt()
        do {
            when (opcion) {
                1 -> { // reportes  -> resumen mensual, ultimos movimientos


                }
                // Manejo de cuentas -> consultar saldo, consultar movimientos, agregar cuenta, eliminar cuenta
                2 -> CuentasController.manejoCuentas(usuario)

                3 -> { // Realizar movimientos -> ingreso, gasto, transferencia
                    MovimientosController.seleccionarMovimiento(usuario)
                }

                4 -> { // DELOGUERASE
                    println("¿SEGURO QUE DESEA DESLOGUEARSE? (S/N)")
                    val respuesta = readln()
                    if (respuesta == "S" || respuesta == "s") {
                        println("DESLOGUEANDO")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                        AutenticacionController.menuAutenticacion()
                    }
                }

                else -> {
                    println("OPCION NO VALIDA")
                }
            }
        } while (opcion != 4)
    }

}