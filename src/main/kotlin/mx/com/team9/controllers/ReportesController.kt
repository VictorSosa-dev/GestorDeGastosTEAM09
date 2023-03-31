package mx.com.team9.controllers

import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Gasto
import mx.com.team9.domain.Usuario
import mx.com.team9.models.Reporte
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarMenuReportes

object ReportesController {
    fun seleccionarReporte(usuario: Usuario) {
        do {
            mostrarMenuReportes(usuario)
            println("SELECCIONA UNA OPCIÓN: ")
            var opcion = readln().toInt()
            when (opcion) {
                1 -> { //RESUMEN MENSUAL
                    Reporte.reporteMensual(usuario)
                }

                2 -> { //ULTIMOS MOVIMIENTOS
                    Reporte.ultimosMovimientos(usuario)

                }

                3 -> { //CATEGORIAS
                    Reporte.reportePorCategoria(usuario)
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
