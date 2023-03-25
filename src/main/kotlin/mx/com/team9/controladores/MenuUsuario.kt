import mx.com.team9.Utils.Utilidades.limpiarPantalla
import mx.com.team9.activities.Usuario
fun MenuUsuarioLogeado(usuario: Usuario){

    var _salida = false

    do {
        MenuAcionesLogeado(usuario)
        val op = readln()?.toIntOrNull() ?: 0
        when (op) {
            1 -> {
                println("REGISTRAR GASTO")
                println("PULSA TU SELECCION E INTRO:")
            }
            2 -> {
                println("DEPOSITAR")
                println("PULSA TU SELECCION E INTRO:")
            }
            3 -> _salida = true
            else -> {
                println(" $op ->>> no es una opción valida")
                Thread.sleep(1000)
                limpiarPantalla()
            }
        }

    } while (!_salida)
}

fun MenuAcionesLogeado(usuario: Usuario){
    println("""
           ************************************************************
           *                        MENU DE PRINCIPAL                 *
           *                       1.- REGISTRAR GASTO                *
           *                       2.- DEPOSITAR                      *
           *                       3.- SALIR                          *
           ************************************************************
       """.trimIndent())
    print("PULSA TU SELECCION E INTRO:")
}
