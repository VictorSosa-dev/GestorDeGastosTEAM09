package mx.com.team9.utils

import mx.com.team9.activities.Usuario

class Menu(){

    val listaDeUsuarios = mutableListOf<Usuario>()

    fun MostrarMenu() {
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
                1 -> ingresar()
                2 -> registrarse()
                3 -> _salida = true
                else -> println(" $opc ->>> no es una opción valida :(")
            }

            //_salida = true
        } while (!_salida)
    }

    // login
    private fun ingresar(){
        println("Ingresa tu email:")
        val email = readLine().toString()
        println("Ingresa tu contraseña:")
        val password = readln().toString()
        // Validar si el usuario ya existe
        val usuario = listaDeUsuarios.find { it.getEmail() == email }
        if (usuario != null){
            if (usuario.validatePassword(password)){
                // se muestra el menu de operaciones para el usuario
                // para evitar tener todo aqui puedes crear una funcion una
                // en otro archivo y llamarla aqui para las operaciones del usuario
                // tambien se debe crear la cuenta del usuario
                mostrarMenuOperaciones(usuario.getName())
            } else {
                println("Contraseña incorrecta")
            }
        } else {
            println("El usuario no existe")
        }

    }

    // sing in
    private fun registrarse() {
        val u1 = Usuario()
        // Crear usuario
        println("Ingresa tu usuario:")
        val usuario= readLine().toString()
        println("Ingresa tu email:")
        val email = readLine().toString()
        println("Ingresa tu contraseña:")
        val password = readLine().toString()
        u1.crearUsuario(usuario, email, password)
        // Validar si el usuario ya existe
        val existe = listaDeUsuarios.find { it.getEmail() == email }
        if (existe != null){
            println("El usuario $usuario ya existe inicia sesión")
            return
        }
        // Pedir la cantidad de dinero que tiene el usuario
        // Se crea la cuenta del usuario
        listaDeUsuarios.add(u1)
        // Luego mostrar el menu de operaciones por ejemplo
        // agregar gasto, agregar ingreso, ver gastos, ver ingreso


    }

    private fun mostrarMenuOperaciones(usuario: String){
        println("+".repeat(60))
        println("+                    Bienvenido $usuario                  +")
        println("+                        AUTHOR TEAM 9                    +")
        println("+".repeat(60))
    }

}