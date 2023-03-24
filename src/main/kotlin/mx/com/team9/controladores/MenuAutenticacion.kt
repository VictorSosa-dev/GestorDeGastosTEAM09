package mx.com.team9.controladores

import mx.com.team9.activities.Usuario
import mx.com.team9.Utils.Utilidades.limpiarPantalla
import kotlin.system.exitProcess

//TODO: EL AUTENTICADO PODRIA ESTAR FUERA
class MenuAutenticacion(){

    val listaUsuarios = mutableListOf<Usuario>(
        Usuario("Victor", "vic@test.com", "123", null),
        Usuario("Kef", "kef@test.com", "123", null),
        Usuario("Ema", "ema@test.com", "123", null),
    )

    fun menuAutenticar() {
        println("""
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+       BIENVENIDO CASH MANAGER: A TU GESTOR DE GASTOS     +
+                    AUTOR TEAM 9                          +
+   CARLOS SALAZAR - EMANUEL RIVERA - FERNANDO NOVALES     +
+               KEVIN GORDILLO - VICTOR SOSA               +
+  https://github.com/VictorSosa-dev/GestorDeGastosTEAM09/ +
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
************************************************************
*                        MENU DE OPCIONES                  *
*                       1.- INICIAR SESIÓN                 *
*                       2.- REGISTRARSE                    *
*                       3.- SALIR                          *
************************************************************
""".trimIndent())
//        println("+".repeat(60))
//        println("+        BIENVENIDO CASH MANAGER -TU GESTOR DE GASTOS      +")
//        println("+                       AUTOR TEAM 9:                       +")
//                "EMANUELRIVERA-KEVINGORDILLO-" +
//                "VICTORSOSA-CARLOSJIMENES-FERNANDO  +")
//        println("+  https://github.com/VictorSosa-dev/GestorDeGastosTEAM09/ +")
//        println("+".repeat(60))
//        println("*".repeat(60))
//        println("*                        MENU DE OPCIONES                  *")
//        println("*                       1.- INICIAR SESIÓN                 *")
//        println("*                       2.- REGISTRARSE                    *")
//        println("*                       3.- SALIR                          *")
//        println("*".repeat(60))
    }
    fun MostrarMenu() {
        var _salida = false
        do {
            menuAutenticar()
            print("PULSA TU SELECCION E INTRO:")
            // evitar que el usuario ingrese un valor no numerico
            val opc = readln()?.toIntOrNull() ?: 0
            when (opc) {
                1 -> ingresar()
                2 -> registrarse()
                3 -> _salida = true
                else -> {
                    println(" $opc ->>> no es una opción valida")
                    Thread.sleep(1000)
                    limpiarPantalla()
                }
            }
        } while (!_salida)
        cerrarSistema()
    }

    // login
    private fun ingresar(){
        println("Ingresa tu email:")
        val email = readln().toString()
        println("Ingresa tu contraseña:")
        val password = readln().toString()
        // Validar si el usuario ya existe
        val usuario = listaUsuarios.find { it.getCorreo() == email }
        if (usuario != null){
            if (usuario.validarPassword(password)){
                // se muestra el menu de operaciones para el usuario
                // para evitar tener todo aqui puedes crear una funcion una
                // en otro archivo y llamarla aqui para las operaciones del usuario
                // tambien se debe crear la cuenta del usuario
                mostrarMenuOperaciones(usuario.getNombre())
            } else {
                println("Contraseña incorrecta")
                Thread.sleep(1000)
                limpiarPantalla()
            }
        } else {
            println("El usuario no existe")
            Thread.sleep(1000)
            limpiarPantalla()
        }

    }

    // Registro de usuario
    private fun registrarse() {
        println("Ingresa tu nombre de usuario:")
        var nombreUsuario = readln()
        // Validar que el nombre usuario no exista en la lista de usuarios
        while (listaUsuarios.find { it.getNombre().lowercase() == nombreUsuario.lowercase() } != null){
            println("El usuario $nombreUsuario ya existe, ingresa otro nombre de usuario")
            limpiarPantalla()
            println("Ingresa tu nombre de usuario:")
            nombreUsuario = readln()
        }
        println("Ingresa tu email:")
        var email = readln()
        // revisar si es un correo valido
        while (!email.contains("@") || !email.contains(".")){
            println("El email $email no es valido, ingresa un email valido")
            limpiarPantalla()
            println("Ingresa tu email:")
            email = readln()
        }
        while (listaUsuarios.find { it.getCorreo() == email } != null){
            println("El email $email ya existe, ingresa otro correo")
            limpiarPantalla()
            println("Ingresa tu email:")
            email = readln()
        }
        println("Ingresa tu contraseña:")
        val password = readln().toString()
        // Se crea la cuenta del usuario
        listaUsuarios.add(Usuario(nombreUsuario, email, password, null))
        println("Usuario registrado con exito. Puedes iniciar sesión")
        Thread.sleep(1000)
        limpiarPantalla()
        // Luego mostrar el menu de operaciones por ejemplo
        // agregar gasto, agregar ingreso, ver gastos, ver ingreso
    }

    private fun mostrarMenuOperaciones(usuario: String){
        println("+".repeat(60))
        println("+                    Bienvenido $usuario                  +")
        println("+                        AUTHOR TEAM 9                    +")
        println("+".repeat(60))
    }

    
    fun cerrarSistema(){
        println("Gracias por usar nuestro sistema")
        println("Hasta pronto")
        Thread.sleep(2000)
        exitProcess(0)
    }

}