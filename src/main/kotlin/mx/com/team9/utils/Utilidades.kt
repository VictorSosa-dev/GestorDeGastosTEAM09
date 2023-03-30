package mx.com.team9.utils

import mx.com.team9.controllers.SistemaPrincipalController
import mx.com.team9.domain.Usuario
import kotlin.random.Random
import kotlin.system.exitProcess

//Funciones que se pueden ocupar en todo el proyecto
object Utilidades {
    //Funcion para limpiar la pantalla
    fun limpiarPantalla() {
        Thread.sleep(1000)
        println("\u001b[H\u001b[2J")
    }

    fun inicioSistemaCashControlManager() {
        println("Iniciando Cash Manager")

        val maxCarga = 100 // Valor máximo de la carga
        val incremento = 5 // Incremento de la carga en cada iteración
        val duracionTimer = 200L // Duración en milisegundos de la pausa en cada iteración

        // Bucle que recorre desde 0 hasta maxCarga con un incremento en cada iteración
        for (i in 0..maxCarga step incremento) {
            // Imprime la barra de carga y el porcentaje de progreso
            print("\rCargando: ${generarBarraCarga(i, maxCarga)} $i% ")
            // Pausa la ejecución por la duración definida en duracionTimer
            Thread.sleep(duracionTimer)
        }
        println()
        // Imprime un mensaje indicando que el programa se ha cargado exitosamente
        logoCashManager()
        Thread.sleep(5000)
    }

    fun generarBarraCarga(progreso: Int, total: Int): String {
        val longitudBarra = 50 // Longitud total de la barra de carga
        val porcentajeCarga =
            (progreso.toFloat() / total.toFloat()) * longitudBarra // Calcula el porcentaje de carga en función de la longitud de la barra
        val cantidadCaracteresCargados = porcentajeCarga.toInt() // Convierte el porcentaje de carga en un número entero

        // Genera y devuelve la barra de carga
        return "[" +
                // Repite el caracter "=" la cantidad de veces indicada por cantidadCaracteresCargados, pero nunca menos de 0 (usando coerceAtLeast)
                "=".repeat(cantidadCaracteresCargados.coerceAtLeast(0)) +
                ">" +
                // Repite el caracter " " la cantidad de veces necesaria para completar la barra, pero nunca menos de 0 (usando coerceAtLeast)
                " ".repeat((longitudBarra - cantidadCaracteresCargados - 1).coerceAtLeast(0)) +
                "]"
    }

    fun ingresarDineroAscii() {
        println(
            """                                              
▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓    
▒▒▓▓░░                          ░░▓▓▓▓    
▒▒▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░  ▓▓▓▓    
▒▒▓▓▓▓▒▒░░▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓    
        ░░▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒          
        ▒▒▓▓▓▓▓▓▓▓░░  ▒▒▓▓▓▓▓▓▓▓          
        ▒▒▓▓▓▓▓▓  ░░▓▓  ░░▓▓▓▓▓▓          
        ▓▓▓▓▓▓▓▓    ▒▒▓▓▓▓▓▓▓▓▓▓        .
        ▓▓▓▓▓▓▓▓▓▓▒▒░░  ░░▓▓▓▓▓▓      .:;:.  
    ░░▓▓▓▓▓▓▓▓  ░░▓▓░░  ▓▓▓▓▓▓      .:;;;;;:.
    ░░▓▓▓▓▓▓▓▓▒▒░░  ░░▓▓▓▓▓▓▓▓        ;;;;;  
    ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░      ;;;;;  
    ▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░      ;;;;;  
    ▒▒░░▓▓▓▓░░▓▓▒▒░░▓▓▓▓▒▒▓▓▓▓▒▒      ;;;;;                                      
""".trimIndent())
    }

    fun logoCashManager() {
        print(
            """    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    + BIENVENIDO CASH MANAGER: TU GESTOR DE GASTOS PERSONALES  +
    +      AUTOR TEAM 9:  CARLOS SALAZAR - EMANUEL RIVERA      +
    +       FERNANDO NOVALES -KEVIN GORDILLO - VICTOR SOSA     +
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                ───────────────────────█──────────────
                ────▀██▀▀▀█─▀██▀▀▀█─▀█▀█▀▀█─▀██──█────
                ─────██──────██───█──█▄█▄▄▄──██▄▄█────
                ─────██──────██▄▄▄█──▄─█─██──██──█────
                ────▄██▄▄▄█─▄██───█──█▄█▄██─▄██──█────
                ───────────────────────█──────────────
                ──────────────MANAGER─────────────────
                ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒""".trimIndent()
        )
    }

    fun mostrarOpcionesAutenticar() {
        println(
            """
    
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    +       CASH MANAGER: TU GESTOR DE GASTOS PERSONALES       +
    +                    CASH MANAGER                          +
    +                       V1.00                              +
    +                     MARZO 2023                           +
    +                                                          +
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    ************************************************************
    *                   ACCESO AL SISTEMA                      *
    *                   1.- INICIAR SESIÓN                     *
    *                   2.- REGISTRARSE                        *
    *                   3.- SALIR                              *
    ************************************************************
""".trimIndent()
        )
        print("INGRESA TU OPCION Y PRESIONA ENTER:")
    }

    //Menu inicial de cuenta,
    fun mostrarOpcionesPrincipal(usuario: Usuario) {
        println("""
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    +             CASH MANAGER: A TU GESTOR DE GASTOS          +
    BIENVENIDO ${usuario.getNombre().uppercase()}
    SALDO CUENTA PRINCIPAL:$${usuario.obtenerSaldoPrincipal()}
    +                                                          +
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    ************************************************************
    *                    MENU  PRINCIPAL                       *
    *                  1.- REPORTES                            *
    *                  2.- MANEJO DE CUENTAS                   *
    *                  3.- REALIZAR MOVIMIENTOS                *
    *                  4.- SALIR DE SESION                     *
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
""".trimIndent())
    print("INGRESA TU OPCION Y PRESIONA ENTER:")
    }

    //Menu inicial de cuenta,
    fun mostrarOpcionesMovimientos(usuario: Usuario) {
        println("""
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    +             CASH MANAGER: A TU GESTOR DE GASTOS          +
    BIENVENIDO ${usuario.getNombre().uppercase()}
    SALDO CUENTA PRINCIPAL:$${usuario.obtenerSaldoPrincipal()}
    +                                                          +
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    ************************************************************
    *                 MENU DE MOVIMIENTOS                      *
    *                  1.- INGRESO                             *
    *                  2.- GASTO                               *
    *                  3.- TRANSFERENCIA ENTRE MIS CUENTAS     *
    *                  4.- ATRAS                               *
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    """.trimIndent())
        print("INGRESA TU OPCION Y PRESIONA ENTER:")
    }

    fun cerrarSistema() {
        println("GRACIAS POR USAR CASH MANAGER\n")
        println("VUELVE PRONTO")
        Thread.sleep(2000)
        exitProcess(0)
    }

    //Funcion para generar un ID unico para cuentas y movimientos
    fun generadorIDUnico(longitud: Int): String {
        val charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        return (1..longitud)
            .map { Random.nextInt(0, charPool.length) }
            .map(charPool::get)
            .joinToString("")
    }
}