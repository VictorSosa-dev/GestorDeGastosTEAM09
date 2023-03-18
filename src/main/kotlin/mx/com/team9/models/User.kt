package mx.com.team9.models

const val PASSWORD_LENGHT = 10
class User(name: String, email: String, password: String) {
    /**
     * Clase que representa a un usuario
     * @param name Nombre del usuario
     * @param password Contraseña del usuario
     */

    init {
        println("El usuario $name ha ingresado")
    }

    private var name = name
        set(value) {
            if (value.length >= 3) field = value
            else println("El nombre debe contener al menos 3 digitos")
        }
    private var email: String = email
        set(value) {
            if (value.contains("@")) field = value
            else println("El email debe contener un @")
        }

    private var password: String = password
        set(value) {
            if (value.length >= PASSWORD_LENGHT) field = value
            else println("El password debe contener al menos 10 digitos")
        }

    fun getName(): String {
        return this.name
    }

    fun getEmail(): String {
        return this.email
    }

    fun validatePassword(password: String): Boolean {
        return this.password == password
    }



}