package mx.com.team9.controllers

import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Gasto
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarMenuReportes

object ReportesController {

    lateinit var usuario: Usuario
    fun seleccionarReporte(usuario: Usuario) {
        do {
            mostrarMenuReportes(usuario)
            println("SELECCIONA UNA OPCIÓN: ")
            var opcion = readln().toInt()
            when (opcion) {
                1 -> {
                    println("aqui va Reporte1")
                    Thread.sleep(3000)
                }

                2 -> {
                    println("aqui va Reporte2")
                    Thread.sleep(3000)
                }

                3 -> {
                    println("aqui va Reporte3")
                    Thread.sleep(3000)
                }

                4 -> {
                    println("REGRESANDO AL MENU PRINCIPAL......")
                    Thread.sleep(1000)
                    SistemaPrincipalController.sistemaPrincipal(usuario)
                }

                else -> {
                    println("OPCIÓN NO VALIDA")
                }
            }
        } while (opcion != 4)
    }
}
