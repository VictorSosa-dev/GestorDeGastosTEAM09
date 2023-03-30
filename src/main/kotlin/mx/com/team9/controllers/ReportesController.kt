package mx.com.team9.controllers

import mx.com.team9.domain.Gasto
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.TipoCategoria
import mx.com.team9.utils.Utilidades

class ReportesController(val usuario: Usuario) {

    var _salida = false

    fun seleccionarReporte() {
    do {
        Utilidades.mostrarOpcionesReportes(usuario)
        val op = readln()?.toIntOrNull() ?: 0
        when (op) {
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
                _salida = true
            }
            else -> {
                println(" $op ->>> no es una opción valida")
                Thread.sleep(1000)
                Utilidades.limpiarPantalla()
            }
        }
        Utilidades.mostrarOpcionesReportes(usuario)
    } while (!_salida)
    }
}
