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


    companion object {
        @JvmStatic fun main(vararg input: String){
            /*val u1 = User()
            u1.setUsuario("")
            u1.setPassword("")*/

            println("+".repeat(60))
            println("+              BIENVENIDO A TU GESTOR DE GASTOS            +")
            println("+                        AUTHOR TEAM 9                     +")
            println("+  https://github.com/VictorSosa-dev/GestorDeGastosTEAM09/ +")
            println("+".repeat(60))
            println("*".repeat(60))
            println("*                        MENU DE OPCIONES                  *")
            println("*                       1.- INICIAR SESIÓN                 *")
            println("*                       2.- CONSULTAR SALDO                *")
            println("*                       3.- CONSULTAR MOVIMIENTOS          *")
            println("*                       4.- SALIR                          *")
            println("*".repeat(60))


            var _salida = false
            do {
                print("PULSA TU SELECCION E INTRO:")
                val opc = readln().toInt()
                
                when(opc){
                    1 -> println("Haz elegido iniciar sesión")
                    2 -> println("Haz elegido consultar saldo")
                    4 -> _salida = true
                    else -> println(" $opc ->>> no es una opción valida :(")
                }

                //_salida = true
            }while (!_salida)
        }

    }

}