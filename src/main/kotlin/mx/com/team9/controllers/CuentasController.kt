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
            println("No tienes cuentas registradas")
            return
        }

        // si solo tiene una cuenta, se selecciona automaticamente
        if (usuario.listaCuentas?.size == 1) {
            cuenta = usuario.listaCuentas?.get(0)
            // seleccionar la cuenta y mostrar detalles de la cuenta
            mostrarDetallesCuenta()
            mostrarOpcionesCuenta()
        }

    }

    private fun mostrarOpcionesCuenta() {
        do {
            mostrarMenuCuentas()
            println("Selecciona una opcion:")
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
                    // regresar al menu principal
                    return
                }

                else -> {
                    println("Opcion no valida")
                }
            }
        } while (opcion != 4)

    }

    private fun eliminarCuenta() {
        if (cuenta == null) {
            println("No has seleccionado una cuenta")
            return
        }

        // eliminar la cuenta de la lista de cuentas del usuario
        println("Selecciona la cuenta que deseas eliminar")
        if (usuario?.listaCuentas?.size == 1) {
            println("No puedes eliminar tu unica cuenta")
            return
        }
    }

    private fun agregarCuenta() {
        println("Ingresa el nombre de la cuenta")
        val nombre = readln()
        println("Ingresa el saldo inicial")
        val saldo = readln().toDouble()
        val nuevaCuenta = Cuenta(UUID.randomUUID().toString(), saldo, nombre)
        usuario?.listaCuentas?.add(nuevaCuenta)
        println("Cuenta creada con exito")
        println(
            """
            Nombre: ${nuevaCuenta.nombre}
            Saldo: ${nuevaCuenta.saldo}
            Fecha de creacion: ${nuevaCuenta.fechaCreacion}
            
        """.trimIndent()
        )
    }

    private fun consultaMovimientos() {
        limpiarPantalla()
        if (cuenta == null) {
            println("No has seleccionado una cuenta")
            return
        }

        if (cuenta?.obtenerMovimientos()?.size == 0) {
            println("No tienes movimientos registrados")
            return
        }

        cuenta?.obtenerMovimientos()?.forEach {
            println(
                """
                Descripcion: ${it.descripcion}
                Monto: ${it.monto}
                Categoria: ${it.categoria}
                Fecha: ${it.fecha}
            """.trimIndent()
            )
        }
    }

    private fun mostrarDetallesCuenta() {
        if (cuenta == null) {
            println("No has seleccionado una cuenta o no tienes cuentas registradas")
            return
        }
        limpiarPantalla()

        val info = """
    ===================================
              INFORMACIÓN            
    ===================================
      Nombre:           ${cuenta?.nombre}   
      Saldo:            ${cuenta?.saldo}   
      Fecha de creación: ${cuenta?.fechaCreacion} 
    ===================================
""".trimMargin()

        println(info)
    }
}
