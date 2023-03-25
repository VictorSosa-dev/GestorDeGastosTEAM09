import mx.com.team9.controladores.MenuAutenticacion

fun main(args: Array<String>) {
    //Aqui se ejectuara el programa principal y se instanciaran las principales clases
    inicioSistemaCashControlManager()
    val menu = MenuAutenticacion()
    menu.MostrarMenu()
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
    println() // Salto de línea

    // Imprime un mensaje indicando que el programa se ha cargado exitosamente
    logoCashControlManager()
    Thread.sleep(2000)
}

fun generarBarraCarga(progreso: Int, total: Int): String {
    val longitudBarra = 50 // Longitud total de la barra de carga
    val porcentajeCarga = (progreso.toFloat() / total.toFloat()) * longitudBarra // Calcula el porcentaje de carga en función de la longitud de la barra
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
    println("""                                              
            ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓    
            ▒▒▓▓░░                          ░░▓▓▓▓    
            ▒▒▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░  ▓▓▓▓    
            ▒▒▓▓▓▓▒▒░░▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒▓▓▓▓▓▓    
                    ░░▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▒▒          
                    ▒▒▓▓▓▓▓▓▓▓░░  ▒▒▓▓▓▓▓▓▓▓          
                    ▒▒▓▓▓▓▓▓  ░░▓▓  ░░▓▓▓▓▓▓          
                    ▓▓▓▓▓▓▓▓    ▒▒▓▓▓▓▓▓▓▓▓▓          
                    ▓▓▓▓▓▓▓▓▓▓▒▒░░  ░░▓▓▓▓▓▓          
                ░░▓▓▓▓▓▓▓▓  ░░▓▓░░  ▓▓▓▓▓▓          
                ░░▓▓▓▓▓▓▓▓▒▒░░  ░░▓▓▓▓▓▓▓▓          
                ▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░        
                ▓▓▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░        
                ▒▒░░▓▓▓▓░░▓▓▒▒░░▓▓▓▓▒▒▓▓▓▓▒▒        
                            ░░    ▒▒▓▓  ▒▒            
                                              
""".trimIndent())
}

fun logoCashControlManager() {
    println("""
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    +       BIENVENIDO CASH MANAGER: A TU GESTOR DE GASTOS     +
    +                    AUTOR TEAM 9                          +
    +   CARLOS SALAZAR - EMANUEL RIVERA - FERNANDO NOVALES     +
    +               KEVIN GORDILLO - VICTOR SOSA               +
    +  https://github.com/VictorSosa-dev/GestorDeGastosTEAM09/ +
    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    """.trimIndent())
    println("           ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ \n" +
            "           ────────────────────────────────────── \n" +
            "           ────────────────────█───────────────── \n" +
            "           ─▀██▀▀▀█─▀██▀▀▀█─▀█▀█▀▀█─▀██──█─────── \n" +
            "           ──██──────██───█──█▄█▄▄▄──██▄▄█─────── \n" +
            "           ──██──────██▄▄▄█──▄─█─██──██──█─────── \n" +
            "           ─▄██▄▄▄█─▄██───█──█▄█▄██─▄██──█─────── \n" +
            "           ────────────────────█───────────────── \n" +
            "           ──────────────MANAGER───────────────── \n" +
            "           ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒ \n")
}