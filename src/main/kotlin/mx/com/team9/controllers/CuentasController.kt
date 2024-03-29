package mx.com.team9.controllers

import mx.com.team9.controllers.SistemaPrincipalController.usuario
import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Utilidades.limpiarPantalla
import mx.com.team9.utils.Utilidades.mostrarMenuCuentas
import java.lang.Thread.sleep
import java.util.*

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
            var opcion = readln().toIntOrNull()?: -1
            when (opcion) {
                1 -> consultaMovimientos()

                2 -> {
                    agregarCuenta()
                }

                3 -> {
                    editarCuenta()
                }

                4 ->{
                    eliminarCuenta()
                }

                5 -> {
                    println("REGRESANDO AL MENU PRINCIPAL......")
                    Thread.sleep(1000)
                    SistemaPrincipalController.sistemaPrincipal(usuario)
                }
                else -> {
                    println("OPCIÓN NO VALIDA")
                }
            }
        } while (opcion != 5)

    }

    private fun editarCuenta() {
        // Si solo tiene una cuenta, se edita automaticamente
        if (usuario?.listaCuentas?.size == 1) {
            cuenta = usuario?.listaCuentas?.get(0)
            println("EDITANDO CUENTA ${cuenta?.nombre}")
            pedirDatosCuenta()
            return
        }

        // Seleccionar la cuenta a editar
        println("ESTAS SON TUS CUENTAS REGISTRADAS")
        usuario?.listaCuentas?.forEachIndexed { index, cuenta ->
            println("${index + 1}. ${cuenta.nombre}")
        }
        println("SELECCIONA UNA CUENTA: ")
        var opcion = readln().toIntOrNull() ?: -1
        while (opcion !in 1.. usuario.listaCuentas.size) {
            println("OPCION NO VALIDA !!!")
            println("SELECCIONA UNA CUENTA: ")
            opcion = readln().toIntOrNull() ?: 0
        }
        cuenta = usuario?.listaCuentas?.get(opcion - 1)
        pedirDatosCuenta()
    }

    private fun pedirDatosCuenta() {
        print("INGRESA EL NUEVO NOMBRE DE LA CUENTA:")
        val nombre = readln()?: ""
        while (nombre.isEmpty()) {
            println("NOMBRE NO VALIDO")
            return
        }
        cuenta?.nombre = nombre
        println("CUENTA EDITADA CON EXITO")
        println(" NOMBRE DE LA CUENTA: ${cuenta?.nombre}" )
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
        println("INGRESA EL NOMBRE DE LA NUEVA CUENTA:")
        val nombre = readln()
        println("INGRESA EL SALDO INICIAL DE LA NUEVA CUENTA:")
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
        sleep(2000)
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

        print("""
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    MOVIMIENTOS DE LA CUENTA ${cuenta?.nombre?.uppercase()}
            ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        """.trimIndent()
        )
        println()
        cuenta?.obtenerMovimientos()?.forEach {
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
                       INFORMACIÓN DE LA CUENTA         
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    NOMBRE:           ${cuenta?.nombre?.uppercase()}   
                    SALDO:            ${cuenta?.saldo}   
                    FECHA DE CREACIÓN: ${cuenta?.fechaCreacion?.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"))} 
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
""".trimIndent()
        println(info)
    }
}
