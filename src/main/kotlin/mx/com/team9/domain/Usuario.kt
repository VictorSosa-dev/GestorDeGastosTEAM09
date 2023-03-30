package mx.com.team9.domain

import mx.com.team9.utils.Utilidades

const val LONGITUD_PASSWORD = 8
/**
 * Clase que representa a un usuario
 * @param nombre Nombre del usuario
 * @param correo Correo del usuario
 * @param contrasena Contraseña del usuario
 */

class Usuario(
    id: String,
    nombre: String,
    correo: String,
    contrasena: String,
) {

    val listaCuentas: MutableList<Cuenta> = mutableListOf()

    private var nombre = nombre
        set(value) {
            if (value.length >= 3) field = value
            else println("El nombre debe contener al menos 3 digitos")
        }
    private var correo: String = correo
        set(value) {
            if (value.contains("@")) field = value
            else println("El email debe contener un @")
        }

    private var contrasena: String = contrasena
        set(value) {
            if (value.length >= LONGITUD_PASSWORD) field = value
            else println("El password debe contener al menos 10 digitos")
        }

    fun getNombre(): String {
        return this.nombre
    }

    fun getCorreo(): String {
        return this.correo
    }

    fun validarContrasena(contrasena: String): Boolean {
        return this.contrasena == contrasena
    }

    fun agregarCuenta(cuenta: Cuenta) {
        listaCuentas?.add(cuenta)
        cuenta.usuario = this
    }

    fun obtenerSaldoPrincipal(): Double {
        return listaCuentas?.get(0)?.saldo ?: 0.0
    }
    fun getNombreCuentaPrincipal(): String {
        return listaCuentas?.get(0)?.nombre ?: ""
    }

    fun obtenerUnaCuenta(tipoMovimiento: String): Cuenta {
        try { //Excepcion si no hay cuenta
            if (listaCuentas.size > 1) {
                println("SELECIONA LA CUENTA EN LA QUE REGISTRAS TU $tipoMovimiento:")
                listaCuentas?.forEachIndexed { index, cuenta ->
                    println("${index + 1}. ${cuenta.nombre}")
                }
                print("CUENTA:")
                var opcionCuenta = readln().toIntOrNull() ?: 0
                //Si la cuenta no es valida, no se puede realizar el movimiento
                while (opcionCuenta !in 1..listaCuentas.size) {
                    println("LA CUENTA NO ES VALIDA")
                    Utilidades.limpiarPantalla()
                    println("SELECIONA LA CUENTA A LA QUE QUIERES REGISTRAR EN TU $tipoMovimiento:")
                    listaCuentas.forEachIndexed { index, cuenta ->
                        println("${index + 1}. ${cuenta.idCuenta}")
                    }
                    opcionCuenta = readln()?.toIntOrNull() ?: 0
                }
                return listaCuentas.get(opcionCuenta - 1)
            } else {
                //Si solo tiene una cuenta, se selecciona automaticamente
                println("CUENTA PRINCIPAL SELECCIONADA")
                return listaCuentas.get(0)
            }
        } catch (e: Exception) {
            println("ERROR EN LISTA DE CUENTAS: ${e.message}")
            Utilidades.limpiarPantalla()
            throw Exception("ERROR EN LISTA DE CUENTAS: ${e.message}")
        }
    }

}
