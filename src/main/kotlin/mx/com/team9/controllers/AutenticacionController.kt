package mx.com.team9.controllers

import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Mock
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.cerrarSistema
import mx.com.team9.utils.Utilidades.generadorIDUnico
import mx.com.team9.utils.Utilidades.limpiarPantalla
import mx.com.team9.utils.Utilidades.mostrarOpcionesAutenticar

object AutenticacionController {

    val mock = Mock()
    private val listaUsuarios = mock.mockData()

    // Menu de autenticacion al sistema
    fun menuAutenticacion() {
        Utilidades.inicioSistemaCashControlManager()
        do {
            mostrarOpcionesAutenticar()
            // evitar que el usuario ingrese un valor no numerico
            val opcion = readln()?.toIntOrNull() ?: 0
            when (opcion) {
                1 -> ingresar()
                2 -> registrarse()
                3 -> cerrarSistema()
                else -> {
                    println("POR FAVOR, INGRESE UNA OPCION VALIDA")
                    Thread.sleep(1000)
                    limpiarPantalla()
                }
            }
        } while (opcion != 3)
    }

    // Funcion para iniciar sesion con validacion de usuario y contraseña
    private fun ingresar(){
        var intentos = 3
        println("INGRESA TU EMAIL:")
        val email = validarCorreo()
        println("INGRESA TU CONTRASEÑA:")
        var password = readln()
        // Validar si el usuario ya existe
        val usuario = listaUsuarios.find { it.getCorreo() == email }
        if (usuario != null){
            while (!usuario.validarContrasena(password) && intentos > 0){
                println("CONTRASEÑA INCORRECTA !!")
                println("INTENTOS RESTANTANTES: $intentos")
                print("INGRESA LA CONTRASEÑA:")
                password = readln()
                intentos--
            }
            if (intentos == 0){
                println("HAS EXCEDIDO EL NUMERO DE INTENTOS XD")
                Thread.sleep(1000)
                limpiarPantalla()
                return
            }
            Thread.sleep(1000)
            SistemaPrincipalController.sistemaPrincipal(usuario)
        } else {
            println("EL USUARIO NO EXISTE")
            Thread.sleep(1000)
            limpiarPantalla()
        }
    }

    // Funcion de registro de usuario con validaciones de existencia de usuario y correo
    private fun registrarse() {
        println("INGRSA TU NOMBRE DE USUARIO:")
        var nombreUsuario = validarExistenciaUsuario()
        println("INGRESA TU EMAIL:")
        val email = validarExistenciaCorreo()
        println("INGRESA TU CONTRASEÑA:")
        val password = pedirContrasena()
        //  Creacion de usuario y cuenta default
        val usuario = Usuario(generadorIDUnico(6), nombreUsuario, email, password)
        crearCuentaPorDefecto(usuario)
        println("USUARIO REGISTRADO CON EXITO. PUEDES INICIAR SESION")
        Thread.sleep(1000)
        limpiarPantalla()
    }

    private fun pedirContrasena(): String {
        var password = readln()
        while (password.length < 4){
            println("LA CONTRASEÑA DEBE TENER AL MENOS 4 CARACTERES")
            print("INGRESA TU CONTRASEÑA:")
            password = readln()
        }
        println("CONFIRMA TU CONTRASEÑA:")
        var passwordConfirm = readln()
        while (password != passwordConfirm){
            println("LAS CONTRASEÑAS NO COINCIDEN")
            print("INGRESA TU CONTRASEÑA:")
            password = readln()
            println("CONFIRMA TU CONTRASEÑA:")
            passwordConfirm = readln()
        }
        return password
    }

    private fun validarCorreo(): String {
        var email = readln()
        // revisar si es un correo valido
        while (!email.contains("@") || !email.contains(".")){
            println("EL EMAIL $email NO ES VALIDO, INGRESA UNO CON @ y .")
            limpiarPantalla()
            print("INGRESA TU EMAIL:")
            email = readln()
        }
        return email
    }
    private fun validarExistenciaCorreo(): String {
        var email = validarCorreo()
        // Validar que el correo no exista en la lista de usuarios
        while (listaUsuarios.find { it.getCorreo() == email } != null) {
            println("EL EMAIL $email YA EXISTE, INGRESA OTRO EMAIL")
            Thread.sleep(500)
            limpiarPantalla()
            print("INGRESA TU EMAIL:")
            email = readln()
        }
        return email
    }

    private fun validarExistenciaUsuario(): String {
        var nombreUsuario = readln()
        // Verificar que el nombre usuario no exista en la lista de usuarios
        while (listaUsuarios.find { it.getNombre().lowercase() == nombreUsuario.lowercase() } != null) {
            println("EL USARIO $nombreUsuario YA EXISTE, INGRESA OTRO USUARIO")
            limpiarPantalla()
            print("INGRES OTRO NOMBRE DE USUARIO:")
            nombreUsuario = readln()
        }
        return nombreUsuario
    }

    private fun crearCuentaPorDefecto(usuario: Usuario) {
        println("INGRESA EL MONTO INICIAL DE TU CUENTA:")
        var montoInicial = readln()?.toDoubleOrNull() ?: 0.0
        while ( montoInicial is Double && montoInicial <= 0.0){
            print("EL MONTO DEBE SER MAYOR A CERO:")
            montoInicial = readLine()?.toDoubleOrNull() ?: 0.0
        }
        val cuenta = Cuenta(generadorIDUnico(12), montoInicial, "Cuenta Principal")
        usuario.agregarCuenta(cuenta)
        listaUsuarios.add(usuario)
    }
}