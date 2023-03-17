fun main(args: Array<String>) {

    //Aqui se ejectuara el programa principal y se instanciaran las principales clases

    //Mostrar menu de autenticacion

    //Menu de operacion de cuenta

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