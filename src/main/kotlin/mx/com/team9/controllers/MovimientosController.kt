package mx.com.team9.controllers

import mx.com.team9.domain.Gasto
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.TipoCategoria
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarOpcionesMovimientos

class MovimientosController(val usuario: Usuario){


    fun seleccionarMovimiento() {
        var _salida = false

        do {
            mostrarOpcionesMovimientos(usuario)
            val op = readln()?.toIntOrNull() ?: 0
            when (op) {
                1 -> {

                }
                2 -> {
                    print("REGISTRAR GASTO:\n INGRESA EL MONTO DE TU GASTO: $")
                    var montoGasto = readln()?.toDoubleOrNull() ?: 0.0
                    //si el gasto es menor o igual a 0, no se puede realizar el movimiento
                    while (montoGasto <= 0) {
                        println("El monto del gasto debe ser mayor a 0")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                        println("INGRESA EL MONTO DE TU GASTO: $")
                        montoGasto = readln()?.toDoubleOrNull() ?: 0.0
                    }
                    println("INGRESA LA DESCRIPCION DE TU GASTO:")
                    val descripcion = readln()
                    println("SELECIONA LA CATEGORIA DE TU GASTO:")
                    TipoCategoria.values().forEach { println("${it.ordinal + 1}. ${it.name}") }
                    var categoria = readln()?.toIntOrNull() ?: 0
                    //Si la categoria no es valida, no se puede realizar el movimiento
                    while (categoria !in 1..TipoCategoria.values().size) {
                        println("La categoria no es valida")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                        println("SELECIONA LA CATEGORIA DE TU GASTO:")
                        TipoCategoria.values().forEach { println("${it.ordinal + 1}. ${it.name}") }
                        var categoria = readln()?.toIntOrNull() ?: 0
                    }
                    //Crear el movimiento de tipo gasto
                    val nuevoGasto = Gasto(
                        usuario.listaCuentas?.get(0) ?: throw Exception("No hay cuenta principal asociada al usuario"),
                        montoGasto,
                        descripcion,
                        TipoCategoria.values()[categoria - 1]
                    )
                    //Agregar el movimiento a la lista de movimientos de la cuenta principal si el movimiento se
                    //realiza con exito
                    if (nuevoGasto.actualizarSaldo()) {
                        usuario.listaCuentas?.get(0)?.listaMovimientos?.add(nuevoGasto)
                        println("Gasto registrado con exito")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                    } else {
                        println("No se pudo realizar el movimiento")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                    }
                }

                3 -> {
                    _salida = true
                }
                else -> {
                    println(" $op ->>> no es una opción valida")
                    Thread.sleep(1000)
                    Utilidades.limpiarPantalla()
                }
            }
            mostrarOpcionesMovimientos(usuario)
        } while (!_salida)
    }

}
