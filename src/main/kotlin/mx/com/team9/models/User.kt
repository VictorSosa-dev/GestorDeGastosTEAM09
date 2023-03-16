package mx.com.team9.models

const val PASSWORD_LENGHT = 10
class User(name: String,password: String) {
    /**
     * Clase que representa a un usuario
     * @param name Nombre del usuario
     * @param password Contraseña del usuario
     */

    init {
        println("El usuario $name ha ingresado")
    }

    private var name = name
    private var password: String = password
        set(value) {
            if (value.length >= PASSWORD_LENGHT) field = value
            else println("El password debe contener al menos 10 digitos")
        }



    companion object {
        @JvmStatic fun main(vararg input: String){
            val u1 = User("juan", "os")
        }

    }

}