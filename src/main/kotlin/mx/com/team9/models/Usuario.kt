package mx.com.team9.models

import java.util.UUID

const val PASSWORD_LENGHT = 10
class Usuario(
    idUsuario: String,
    nombre: String,
    correo: String,
    contrasena: String,
    var cuentas: MutableList<Cuenta> = mutableListOf()) {
    /**
     * Clase que representa a un usuario
     * @param nombre Nombre del usuario
     * @param correo Correo del usuario
     * @param contrasena Contraseña del usuario
     */

    // Constructor vacío
    constructor() : this("", "", "", "")
    init {
        println("El usuario $nombre ha ingresado")
    }

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
            if (value.length >= PASSWORD_LENGHT) field = value
            else println("El password debe contener al menos 10 digitos")
        }

    fun getName(): String {
        return this.nombre
    }

    fun getEmail(): String {
        return this.correo
    }

    fun validatePassword(contrasena: String): Boolean {
        return this.contrasena == contrasena
    }

    // Método para crear un usuario
    fun crearUsuario(nombre: String, correo: String, contrasena: String) {
        val id = UUID.randomUUID().toString()
        val usuario = Usuario(id, nombre, correo, contrasena)
    }

    // Metodo para iniciar sesión
    fun iniciarSesion(correo: String, contrasena: String): Boolean {
        return this.correo == correo && this.contrasena == contrasena
    }

}