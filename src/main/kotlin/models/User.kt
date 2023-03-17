package models

import kotlin.reflect.typeOf

const val PASSWORD_LENGHT = 10
class User {

    private var usuario: String = ""
    private var password: String = ""
        /*set(value) {
            if (value.length >= PASSWORD_LENGHT) field = value
            else println("El password debe contener al menos 10 digitos")
        }*/

    init {
        println("El usuario $usuario ha ingresado")
    }
    fun getUsuario(): String {
        return usuario
    }
    fun setUsuario(usuario: String) {
        if(usuario.isEmpty()) println("Ingrese un usuario valido") else this.usuario = usuario
    }
    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        if(password.isEmpty()) println("Ingrese una contraseña valida") else this.password = password
    }
    
}