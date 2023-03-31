package mx.com.team9.models

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mx.com.team9.controllers.CuentasController
import mx.com.team9.controllers.MovimientosController
import mx.com.team9.domain.Usuario
import java.time.LocalDateTime
import java.time.Month

// Clase que generarada por el usuario que genera los reportes de una cuenta
class Reporte {
    val usuario: Usuario? = null

    companion object {
        val reportObj = Reporte()
        fun reporteMensual(usuario: Usuario) = runBlocking {
            reportObj.reporteMensual(usuario)
        }

        fun ultimosMovimientos(usuario: Usuario) {

        }

        fun reportePorCategoria(usuario: Usuario) {

        }
    }

    // Suspend function que genera el reporte mensual de una cuenta simulando su carga
    suspend fun reporteMensual(usuario: Usuario) {
        // Obtener cuenta de usuario
        val cuentaSeleccionada = usuario.obtenerUnaCuenta("REPORTE")
        println("CARGANDO INFORMACION DE CUENTA ${cuentaSeleccionada.nombre}")
        // Filtrar los movimientos de la cuenta por mes actual
        val movimientosMesActual = cuentaSeleccionada.listaMovimientos.filter {
            it.fecha.month == LocalDateTime.now().month
        }
        // Si no hay movimientos en el mes actual
        if (movimientosMesActual.isEmpty()) {
            (1..5).forEach {
                delay(500)
                print("█")
            }
            print("X")
            println()
            println("NO HAY MOVIMIENTOS EN EL MES ACTUAL")
            delay(2000)
            return
        }

        println()
        println(
            """
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    REPORTE DE ${reportObj.traducirMes { LocalDateTime.now().month }}
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        """.trimIndent()
        )

        movimientosMesActual.forEach {
            println(
                """
                        DESCRIPCIÓN:    ${it.descripcion}
                        MONTO:          ${it.monto}
                        CATEGORIA:      ${it.categoria}
                        FECHA:          ${it.fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))}
            """.trimIndent()
            )
            println("------------------------------------------------------------")
        }
        println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
        delay(2000)
    }


    // Funcion para traducir los meses del ingles al español
    //#PROGRAMACION_FUNCIONAL LAMBDA HOF
    fun traducirMes(fechaActual: () -> Month): String {
        //Funcion para traducir los meses del ingles al español
        val meses = mapOf(
            Month.JANUARY to "ENERO",
            Month.FEBRUARY to "FEBRERO",
            Month.MARCH to "MARZO",
            Month.APRIL to "ABRIL",
            Month.MAY to "MAYO",
            Month.JUNE to "JUNIO",
            Month.JULY to "JULIO",
            Month.AUGUST to "AGOSTO",
            Month.SEPTEMBER to "SEPTIEMBRE",
            Month.OCTOBER to "OCTUBRE",
            Month.NOVEMBER to "NOVIEMBRE",
            Month.DECEMBER to "DICIEMBRE"
        )
        return meses[fechaActual()]!!
    }


}