package mx.com.team9.utils

import mx.com.team9.activities.User

class Menu(){

    private val listOfUser = mutableListOf<User>()

    fun showMenu() {
        println("+".repeat(60))
        println("+              BIENVENIDO A TU GESTOR DE GASTOS            +")
        println("+                        AUTHOR TEAM 9                     +")
        println("+  https://github.com/VictorSosa-dev/GestorDeGastosTEAM09/ +")
        println("+".repeat(60))
        println("*".repeat(60))
        println("*                        MENU DE OPCIONES                  *")
        println("*                       1.- INICIAR SESIÓN                 *")
        println("*                       2.- REGISTRARSE                    *")
        println("*                       3.- SALIR                          *")
        println("*".repeat(60))


        var _salida = false
        do {
            print("PULSA TU SELECCION E INTRO:")
            // evitar que el usuario ingrese un valor no numerico
            val opc = readLine()?.toIntOrNull() ?: 0
            when (opc) {
                1 -> login()
                2 -> singIn()
                3 -> _salida = true
                else -> println(" $opc ->>> no es una opción valida :(")
            }

            //_salida = true
        } while (!_salida)
    }

    // login
    private fun login(){
        println("Ingresa tu email:")
        val email = readLine().toString()
        println("Ingresa tu contraseña:")
        val password = readln().toString()
        // Validar si el usuario ya existe
        val existe = listOfUser.find { it.getEmail() == email }
        if (existe == null){
            println("El usuario $email no existe")
            return
        } else {
            if (existe.validatePassword(password)){
                println("Ingresaste correctamente")
                // Mostrar un menu de acceso de cuenta
            } else {
                println("Contraseña incorrecta")
            }
        }
    }

    // sing in
    private fun singIn(){
        // Crear usuario
        println("Ingresa tu usuario:")
        val usuario= readLine().toString()
        println("Ingresa tu email:")
        val email = readLine().toString()
        println("Ingresa tu contraseña:")
        val password = readLine().toString()
        val u1 = User(usuario, email, password)
        // Validar si el usuario ya existe
        val existe = listOfUser.find { it.getEmail() == email }
        if (existe != null){
            println("El usuario $usuario ya existe")
            return
        }
        listOfUser.add(u1)

    }


    private fun mostrarMenuOperaciones(usuario: String){
        println("+".repeat(60))
        println("+                    Bienvenido $usuario                  +")
        println("+                        AUTHOR TEAM 9                    +")
        println("+".repeat(60))
    }
}