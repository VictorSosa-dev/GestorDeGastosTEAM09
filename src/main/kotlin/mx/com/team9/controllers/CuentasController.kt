package mx.com.team9.controllers

import mx.com.team9.domain.Usuario

class CuentasController(usuario: Usuario) {

    private val usuario = usuario

    fun seleccionarCuenta() {

        if (usuario.listaCuentas?.size == 0) {
            println("No tienes cuentas registradas")
            return
        }

        println("Selecciona una cuenta")
        usuario.listaCuentas?.forEachIndexed { index, cuenta ->
            println("${index + 1}. ${cuenta.nombre}")
        }
        val opcion = readln()?.toIntOrNull() ?: 0
        when (opcion) {
            1 -> {
                println("Seleccionaste la cuenta ${usuario.listaCuentas?.get(0)?.nombre}")
            }
            2 -> {
                println("Seleccionaste la cuenta ${usuario.listaCuentas?.get(1)?.nombre}")
            }
            3 -> {
                println("Seleccionaste la cuenta ${usuario.listaCuentas?.get(2)?.nombre}")
            }
            else -> {
                println("Opcion no valida")
            }
        }
    }

}
