package mx.com.team9.models

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mx.com.team9.domain.*
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

        fun ultimosMovimientos(usuario: Usuario) = runBlocking {
            reportObj.ultimosMovimientos(usuario)
        }

        fun reportePorCategoria(usuario: Usuario) = runBlocking {
            val categoria = Categoria.seleccionarCategoria("REPORTE")
            reportObj.reportePorCategoria(usuario, categoria)
        }
    }

    suspend fun reportePorCategoria(usuario: Usuario, categoria: Categoria) {
        // Obtener cuenta de usuario
        val cuentaSeleccionada = usuario.obtenerUnaCuenta("REPORTE")
        println("CARGANDO INFORMACION DE CUENTA ${cuentaSeleccionada.nombre}")

        // Filtrar los movimientos por categoria obteniendo los utlimos 10
        try {
            val movimientosCategoria = cuentaSeleccionada.listaMovimientos.filter {
                it.categoria == categoria
            }.takeLast(10)

            // Si no hay movimientos en el mes actual
            if (movimientosCategoria.isEmpty()) {
                (1..5).forEach {
                    delay(500)
                    print("█")
                }
                print("X")
                println()
                println("NO HAY MOVIMIENTOS EN LA CATEGORIA ${categoria.name}")
                delay(2000)
                return
            }
            (1..5).forEach {
                Thread.sleep(500)
                print("█")
            }
            print("☑")
            delay(2000)

            println()
            println(
                """
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                             REPORTES DE LA CATEGORIA: ${categoria.name}
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        """.trimIndent()
            )

            movimientosCategoria.forEach {
                println(
                    """
                        DESCRIPCIÓN:    ${it.descripcion}
                        MONTO:          ${it.monto}
                        CATEGORIA:      ${it.categoria}
                        FECHA:          ${it.fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))}
                        TIPO MOVIMIENTO:${obtenerTipoMovimiento(it)}
            """.trimIndent()
                )
                println("------------------------------------------------------------")
            }
            println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            delay(2000)
        } catch (e: Exception) {
            println("ERROR AL CARGAR LA LISTA DE MOVIMIENTOS")
        }
    }

    private fun obtenerTipoMovimiento(movimiento: Movimiento): String {
        return when (movimiento) {
            is Ingreso -> return "INGRESO"
            is Gasto -> return "GASTO"
            is Transferencia -> return "TRANSFERENCIA"
            else -> return "DESCONOCIDO"
        }
    }

    // Suspend function que genera el reporte mensual de una cuenta simulando su carga
    suspend fun reporteMensual(usuario: Usuario) {
        // Obtener cuenta de usuario
        val cuentaSeleccionada = usuario.obtenerUnaCuenta("REPORTE")
        println("CARGANDO INFORMACION DE CUENTA ${cuentaSeleccionada.nombre}")

        // Filtrar los movimientos de la cuenta por mes actual
        try {
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
            (1..5).forEach {
                Thread.sleep(500)
                print("█")
            }
            print("☑")
            println()
            delay(2000)
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
                        TIPO MOVIMIENTO:${obtenerTipoMovimiento(it)}
            """.trimIndent()
                )
                println("------------------------------------------------------------")
            }
            println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            delay(2000)
        } catch (e: Exception) {
            println("ERROR AL CARGAR LA LISTA DE MOVIMIENTOS")
            return
        }
    }

    suspend fun ultimosMovimientos(usuario: Usuario) {
        // Obtener cuenta de usuario
        val cuentaSeleccionada = usuario.obtenerUnaCuenta("REPORTE")
        println("CARGANDO INFORMACION DE CUENTA ${cuentaSeleccionada.nombre}")

        // Filtrar par abtener max los ultimos 10 movimientos de la cuenta
        try {

            val ultimos10Movimientos = cuentaSeleccionada.listaMovimientos.sortedByDescending { it.fecha }.take(10)

            // Si no hay movimientos en el mes actual
            if (ultimos10Movimientos.isEmpty()) {
                (1..5).forEach {
                    delay(500)
                    print("█")
                }
                print("X")
                println()
                println("NO HAY MOVIMIENTOS EN ESTA CUENTA")
                delay(2000)
                return
            }
            (1..5).forEach {
                Thread.sleep(500)
                print("█")
            }
            print("☑")
            println()
            delay(2000)
            println(
                """
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                REPORTE DE LOS ULTIMOS 10 MOVIMIENTOS MAS RECIENTES
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        """.trimIndent()
            )

            ultimos10Movimientos.forEach {
                println(
                    """
                        DESCRIPCIÓN:    ${it.descripcion}
                        MONTO:          ${it.monto}
                        CATEGORIA:      ${it.categoria}
                        FECHA:          ${it.fecha.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))}
                        TIPO MOVIMIENTO:${obtenerTipoMovimiento(it)}
            """.trimIndent()
                )
                println("------------------------------------------------------------")
            }
            println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++")
            delay(2000)
        } catch (e: Exception) {
            println("ERROR AL CARGAR LA LISTA DE MOVIMIENTOS")
            return
        }
    }


    // Funcion para traducir los meses del ingles al español
    //#PROGRAMACION_FUNCIONAL LAMBDA HOF
    inline fun traducirMes(fechaActual: () -> Month): String {
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