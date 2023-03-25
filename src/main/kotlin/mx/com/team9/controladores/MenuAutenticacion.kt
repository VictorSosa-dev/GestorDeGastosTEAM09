package mx.com.team9.controladores

import MenuUsuarioLogeado
import mx.com.team9.Mocks.Mock
import mx.com.team9.activities.Usuario
import mx.com.team9.Utils.Utilidades.limpiarPantalla
import mx.com.team9.activities.Cuenta
import java.time.LocalDateTime
import java.util.*
import kotlin.system.exitProcess

//TODO: EL AUTENTICADO PODRIA ESTAR FUERA
class MenuAutenticacion(){

    val mock = Mock()
    private val listaUsuarios = mock.MockData()

    fun menuAutenticar() {
        println("""
************************************************************
*                        MENU DE PRINCIPAL                 *
*                       1.- INICIAR SESIÓN                 *
*                       2.- REGISTRARSE                    *
*                       3.- SALIR                          *
************************************************************
""".trimIndent())
        print("PULSA TU SELECCION E INTRO:")
    }
    fun MostrarMenu() {
        var _salida = false
        do {
            menuAutenticar()
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
        val email = validaEmail()

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
                println("Bienvenido ${usuario.getNombre()}")
                usuario.listaCuentas?.get(0)?.let { println(it.saldo) }
                Thread.sleep(500)
                MenuUsuarioLogeado(usuario)
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

    private fun validaEmail(): Any? {
        var email = readln()
        // revisar si es un correo valido
        while (!email.contains("@") || !email.contains(".")){
            println("El email $email no es valido, ingresa un email valido")
            limpiarPantalla()
            println("Ingresa tu email:")
            email = readln()
        }
        return email
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
        // Se crea el usuario
        val usuario = Usuario(UUID.randomUUID().toString(), nombreUsuario, email, password)
        // Se crea la cuenta
        crearCuenta(usuario)

        println("Usuario registrado con exito. Puedes iniciar sesión")
        Thread.sleep(1000)
        limpiarPantalla()
        // Luego mostrar el menu de operaciones por ejemplo
        // agregar gasto, agregar ingreso, ver gastos, ver ingreso
    }

    private fun crearCuenta(usuario: Usuario) {
        println("Ingresa el monto inicial de tu cuenta:")
        var montoInicial = readln()?.toDoubleOrNull() ?: 0.0
        while ( montoInicial is Double && montoInicial <= 0.0){
            println("El monto debe ser positivo :")
            montoInicial = readln()?.toDoubleOrNull() ?: 0.0
        }
        val cuenta = Cuenta(UUID.randomUUID().toString(), montoInicial, LocalDateTime.now())
        usuario.creaCuenta(cuenta)
        listaUsuarios.add(usuario)
    }

    fun cerrarSistema(){
        println("Gracias por usar nuestro sistema")
        println("Hasta pronto")
        Thread.sleep(2000)
        exitProcess(0)
    }

}