package mx.com.team9.domain

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

    val listaCuentas: MutableList<Cuenta>? = mutableListOf()

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

}
