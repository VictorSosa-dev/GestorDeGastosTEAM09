package mx.com.team9.controllers

import mx.com.team9.controllers.SistemaPrincipalController.usuario
import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Utilidades.limpiarPantalla
import mx.com.team9.utils.Utilidades.mostrarMenuCuentas
import java.util.UUID

object CuentasController {

    private var cuenta: Cuenta? = null

    fun manejoCuentas(usuario: Usuario) {

        // validar si tiene cuentas registradas
        if (usuario.listaCuentas?.size == 0) {
            println("NO TIENES CUENTAS REGISTRADAS")
            return
        }

        // si solo tiene una cuenta, se selecciona automaticamente
        if (usuario.listaCuentas?.size == 1) {
            cuenta = usuario.listaCuentas?.get(0)
            // seleccionar la cuenta y mostrar detalles de la cuenta
            mostrarOpcionesCuenta(usuario)
        }

        // si tiene mas de una cuenta, se le pide que seleccione una
        if (usuario.listaCuentas?.size!! > 1) {
            println("ESTAS SON TUS CUENTAS REGISTRADAS")
            usuario.listaCuentas?.forEachIndexed { index, cuenta ->
                println("${index + 1}. ${cuenta.nombre}")
            }
            println("SELECCIONA UNA CUENTA: ")
            val opcion = readln().toInt()
            cuenta = usuario.listaCuentas?.get(opcion - 1)
            mostrarOpcionesCuenta(usuario)
        }

    }

    private fun mostrarOpcionesCuenta(usuario: Usuario) {
        do {
            mostrarDetallesCuenta()
            mostrarMenuCuentas()
            println("SELECCIONA UNA OPCIÓN: ")
            var opcion = readln().toInt()
            when (opcion) {
                1 -> consultaMovimientos()

                2 -> {
                    agregarCuenta()
                }

                3 -> {
                    eliminarCuenta()
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

    private fun eliminarCuenta() {

        // eliminar la cuenta de la lista de cuentas del usuario
        if (usuario?.listaCuentas?.size == 1) {
            println("NO PUEDES ELIMINAR TU UNICA CUENTA")
            return
        }

        usuario?.listaCuentas?.forEachIndexed { index, cuenta ->
            println("${index + 1}. ${cuenta.nombre}")
        }
        println("SELECIONA LA CUENTA QUE DESEAS ELIMINAR")
        val opcion = readln().toInt() ?: 0
        if (opcion > usuario?.listaCuentas?.size!! || opcion < 1) {
            println("OPCION NO VALIDA !!!")
            return
        }
        // confirmar eliminacion
        println("¿SEGURO QUIERE ELIMINAR LA CUENTA? (S/N)")
        val respuesta = readln() ?: ""
        if (respuesta != "S" && respuesta != "s" ) {
            println("CANCELANDO ELIMINACIÓN DE CUENTA")
            return
        }
        val cuentaEliminada = usuario?.listaCuentas?.removeAt(opcion - 1)
        println("CUENTA ELIMINADA CON EXITO "+ cuentaEliminada?.nombre)

    }

    private fun agregarCuenta() {
        println("INGRESA EL NOMBRE DE LA NUEVA CUENTA")
        val nombre = readln()
        println("INGRESA EL SALDO INICIAL DE LA NUEVA CUENTA")
        val saldo = readln().toDouble()
        val nuevaCuenta = Cuenta(UUID.randomUUID().toString(), saldo, nombre)
        usuario?.listaCuentas?.add(nuevaCuenta)
        println("CUENTA CREADA CON EXITO")
        println(
            """
            NOMBRE: ${nuevaCuenta.nombre}
            SALDO: ${nuevaCuenta.saldo}
            FECHA DE CREACIÓN: ${nuevaCuenta.fechaCreacion}
            
        """.trimIndent()
        )
    }

    private fun consultaMovimientos() {
        limpiarPantalla()
        if (cuenta == null) {
            println("NO HAS SELECCIONADO UNA CUENTA")
            return
        }

        if (cuenta?.obtenerMovimientos()?.size == 0) {
            println("NO HAY MOVIMIENTOS REGISTRADOS !!!!")
            return
        }

        cuenta?.obtenerMovimientos()?.forEach {
            println(
                """
                DESCRIPCIÓN: ${it.descripcion}
                MONTO: ${it.monto}
                CATEGORIA: ${it.categoria}
                FECHA: ${it.fecha}
            """.trimIndent()
            )
        }
    }

    private fun mostrarDetallesCuenta() {
        if (cuenta == null) {
            println("NO HAS SELECCIONADO UNA CUENTA O NO TIENES CUENTAS REGISTRADAS")
            return
        }
        limpiarPantalla()

        val info =
            """
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                            INFORMACIÓN            
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    NOMBRE:           ${cuenta?.nombre}   
                    SALDO:            ${cuenta?.saldo}   
                    FECHA DE CREACIÓN: ${cuenta?.fechaCreacion} 
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
""".trimIndent()
        println(info)
    }
}
