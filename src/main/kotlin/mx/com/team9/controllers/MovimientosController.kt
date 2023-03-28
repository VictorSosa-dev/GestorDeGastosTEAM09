package mx.com.team9.controllers

import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Gasto
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.TipoCategoria
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarOpcionesMovimientos

object MovimientosController{
    var cuentaSeleccionada: Cuenta? = null


    fun seleccionarMovimiento(usuario: Usuario) {
        mostrarOpcionesMovimientos(usuario)
        do {
            val opcion = readln()?.toIntOrNull() ?: 0
            when (opcion) {
                1 -> {

                }
                2 -> {
                    // Revisar si el usuario tiene mas de una cuenta, selecionar la cuenta a hacer el movimiento
                    try { //LANZAR EXCEPCION
                        if (usuario.listaCuentas?.size ?: 0 > 1) {
                            println("SELECIONA LA CUENTA A LA QUE QUIERES REGISTRAR EL GASTO:")
                            usuario.listaCuentas?.forEachIndexed { index, cuenta ->
                                println("${index + 1}. ${cuenta.idCuenta}")
                            }
                            var opcionCuenta = readln().toIntOrNull() ?: 0
                            //Si la cuenta no es valida, no se puede realizar el movimiento
                            while (opcionCuenta !in 1..usuario.listaCuentas!!.size) {
                                println("LA CUENTA NO ES VALIDA")
                                Thread.sleep(1000)
                                Utilidades.limpiarPantalla()
                                println("SELECIONA LA CUENTA A LA QUE QUIERES REGISTRAR EL GASTO:")
                                usuario.listaCuentas?.forEachIndexed { index, cuenta ->
                                    println("${index + 1}. ${cuenta.idCuenta}")
                                }
                                opcionCuenta = readln()?.toIntOrNull() ?: 0
                            }
                            cuentaSeleccionada = usuario.listaCuentas?.get(opcionCuenta - 1)
                        } else {
                            //Si solo tiene una cuenta, se selecciona automaticamente
                            println("CUENTA PRINCIPAL SELECCIONADA")
                            cuentaSeleccionada = usuario.listaCuentas?.get(0)
                        }
                    } catch (e: Exception) {
                        println("ERROR EN LISTA DE CUENTAS: ${e.message}")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                    }
                    //PROCESO DE REGISTRO DE MOVIMIENTO
                    print("REGISTRAR GASTO:\nINGRESA EL MONTO DE TU GASTO: $")
                    var montoGasto = readln()?.toDoubleOrNull() ?: 0.0
                    //si el gasto es menor o igual a 0, no se puede realizar el movimiento
                    while (montoGasto <= 0) {
                        println("El monto del gasto debe ser mayor a 0")
                        Thread.sleep(1000)
                        Utilidades.limpiarPantalla()
                        println("INGRESA EL MONTO DE TU GASTO: $")
                        montoGasto = readln()?.toDoubleOrNull() ?: 0.0
                    }
                    //revisar si el monto del gasto es mayor al saldo de la cuenta
                    while (montoGasto > cuentaSeleccionada?.saldo ?: 0.0) {
                        println("El monto del gasto es mayor al saldo de la cuenta")
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

                3 -> { //Regresar al menu principal
                    SistemaPrincipalController.sistemaPrincipal(usuario)
                }
                else -> {
                    println(" $opcion ->>> no es una opción valida")
                    Thread.sleep(1000)
                    Utilidades.limpiarPantalla()
                }
            }
            mostrarOpcionesMovimientos(usuario)
        } while (opcion!= 3)
    }

}
