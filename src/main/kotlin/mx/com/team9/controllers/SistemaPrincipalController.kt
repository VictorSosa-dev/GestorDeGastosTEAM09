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
        var opcion = readln().toInt()
        do {
            when (opcion) {
                1 -> { // reportes  -> resumen mensual, ultimos movimientos
1

                }

                2 -> { // manejo de cuentas -> crear cuenta, editar cuenta, eliminar cuenta

                }

                3 -> { // Realizar movimientos -> ingreso, gasto, transferencia
                    MovimientosController.seleccionarMovimiento(usuario)
                }

                4 -> { // DELOGUERASE
                    println("¿SEGURO QUE DESEA DESLOGUEARSE? (S/N)")
                    val respuesta = readln()
                    if (respuesta == "S" || respuesta == "s") {
                        println("DESLOGUEANDO")
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