package mx.com.team9.controllers

import mx.com.team9.mocks.Mock
import mx.com.team9.utils.Utilidades.cerrarSistema
import mx.com.team9.utils.Utilidades.limpiarPantalla
import mx.com.team9.domain.Usuario
import mx.com.team9.domain.Cuenta
import mx.com.team9.utils.Utilidades.mostrarOpcionesAutenticar
import java.util.*

object AutenticacionController {

    val mock = Mock()
    private val listaUsuarios = mock.mockData()

    // se podra hacer esta funcion lambda, y si el usuario ingresa correctamente, aceptar otra funcion
    // tipo menuPrincipal?
    //val autenticacion: (Unit) -> Boolean =  {
    fun menuAutenticacion(): Boolean {
        var _salida = false
        do {
            mostrarOpcionesAutenticar()
            // evitar que el usuario ingrese un valor no numerico
            val opcion = readln()?.toIntOrNull() ?: 0
            when (opcion) {
                1 -> ingresar()
                2 -> registrarse()
                3 -> _salida = true
                else -> {
                    println("POR FAVOR, INGRESE UNA OPCION VALIDA")
                    Thread.sleep(1000)
                    limpiarPantalla()
                }
            }
        } while (!_salida)
        cerrarSistema()
        return false
    }

    // Funcion para iniciar sesion con validacion de usuario y contraseña
    private fun ingresar(){
        println("Ingresa tu email:")
        val email = validarCorreo()
        println("Ingresa tu contraseña:")
        val password = readln()
        // Validar si el usuario ya existe
        val usuario = listaUsuarios.find { it.getCorreo() == email }
        if (usuario != null){
            if (usuario.validarContrasena(password)){
//                usuario.listaCuentas?.get(0)?.let { println(it.saldo) }
                Thread.sleep(1000)
                SistemaPrincipalController.manejoCuenta(usuario) //TODO: EXTRAER DESPUES
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

    // Funcion de registro de usuario con validaciones de existencia de usuario y correo
    private fun registrarse() {
        println("Ingresa tu nombre de usuario:")
        var nombreUsuario = validarExistenciaUsuario()
        println("Ingresa tu email:")
        var email = validarExistenciaCorreo()
        println("Ingresa tu contraseña:")
        val password = readln().toString()
        //  Creacion de usuario y cuenta default
        val usuario = Usuario(UUID.randomUUID().toString(), nombreUsuario, email, password)
        crearCuentaPorDefecto(usuario)
        println("Usuario registrado con exito. Puedes iniciar sesión")
        Thread.sleep(1000)
        limpiarPantalla()
    }

    private fun validarCorreo(): String {
        var email = readln()
        // revisar si es un correo valido
        while (!email.contains("@") || !email.contains(".")){
            println("El email $email no es valido, ingresa un email valido con @ y .")
            limpiarPantalla()
            println("Ingresa tu email:")
            email = readln()
        }
        return email
    }
    private fun validarExistenciaCorreo(): String {
        var email = validarCorreo()
        // Validar que el correo no exista en la lista de usuarios
        while (listaUsuarios.find { it.getCorreo() == email } != null) {
            println("El email $email ya existe, ingresa otro correo")
            Thread.sleep(500)
            limpiarPantalla()
            println("Ingresa tu email:")
            email = readln()
        }
        return email
    }

    private fun validarExistenciaUsuario(): String {
        var nombreUsuario = readln()
        // Verificar que el nombre usuario no exista en la lista de usuarios
        while (listaUsuarios.find { it.getNombre().lowercase() == nombreUsuario.lowercase() } != null) {
            println("El usuario $nombreUsuario ya existe, ingresa otro nombre de usuario")
            limpiarPantalla()
            println("Ingresa tu nombre de usuario:")
            nombreUsuario = readln()
        }
        return nombreUsuario
    }

    private fun crearCuentaPorDefecto(usuario: Usuario) {
        println("Ingresa el monto inicial de tu cuenta:")
        var montoInicial = readln()?.toDoubleOrNull() ?: 0.0
        while ( montoInicial is Double && montoInicial <= 0.0){
            println("El monto debe ser mayor o igual a 0 :")
            montoInicial = readln()?.toDoubleOrNull() ?: 0.0
        }
        val cuenta = Cuenta(UUID.randomUUID().toString(), montoInicial, "Cuenta Default")
        usuario.agregarCuenta(cuenta)
        listaUsuarios.add(usuario)
    }
}