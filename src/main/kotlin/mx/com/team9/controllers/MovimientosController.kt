package mx.com.team9.controllers

import mx.com.team9.domain.*
import mx.com.team9.utils.Categoria
import mx.com.team9.utils.Utilidades
import mx.com.team9.utils.Utilidades.mostrarOpcionesMovimientos

object MovimientosController {
    lateinit var cuentaSeleccionada: Cuenta


    fun seleccionarMovimiento(usuario: Usuario) {
        mostrarOpcionesMovimientos(usuario)
        do {
            val opcion = readln()?.toIntOrNull() ?: 0
            when (opcion) {
                1 -> { // MOVIMIENTO: INGRESO
                    // Obtener cuenta de usuario
                    cuentaSeleccionada = usuario.obtenerUnaCuenta("INGRESO")
                    //PROCESO DE REGISTRO DE MOVIMIENTO
                    println("REGISTRAR INGRESO")
                    val montoIngreso = Movimiento.registrarMonto("INGRESO")
                    println("INGRESA LA DESCRIPCION DE TU INGRESO:")
                    val descripcion = readln()
                    // Selecion de categoria
                    val categoria = Categoria.seleccionarCategoria("INGRESO")
                    //Crear el movimiento de tipo ingreso, realizar transaccion y asociar a la lista de movimientos de cuenta
                    val nuevoIngreso = Ingreso(
                        cuentaSeleccionada ?: throw Exception("NO HAY CUENTA PRINCIPAL ASOCIADA A USUARIO"),
                        montoIngreso,
                        descripcion,
                        categoria
                    )
                    if (nuevoIngreso.actualizarSaldo()) { // Si la transaccion se realizo con exito
                        usuario.listaCuentas.get(0).listaMovimientos.add(nuevoIngreso)
                        println("INGRESO REGISTRADO CON EXITO")
                        Utilidades.limpiarPantalla()
                    } else {
                        println("NO SE PUDO REALIZAR EL MOVIMIENTO")
                        Utilidades.limpiarPantalla()
                    }

                }

                2 -> { //MOVIMIENTO: GASTO
                    // Obtener cuenta de usuario
                    cuentaSeleccionada = usuario.obtenerUnaCuenta("GASTO")
                    //PROCESO DE REGISTRO DE MOVIMIENTO
                    println("REGISTRAR GASTO")
                    var montoGasto = Movimiento.registrarMonto("GASTO")
                    //revisar si el monto del gasto es mayor al saldo de la cuenta
                    while (montoGasto > cuentaSeleccionada.saldo) {
                        println("EL GASTO ES MAYOR AL SALDO EN LA CUENTA")
                        Utilidades.limpiarPantalla()
                        print("INGRESA EL MONTO DE TU GASTO: $")
                        montoGasto = readln()?.toDoubleOrNull() ?: 0.0
                    }
                    println("INGRESA LA DESCRIPCION DE TU GASTO:")
                    val descripcion = readln()
                    // Selecion de categoria
                    val categoria = Categoria.seleccionarCategoria("GASTO")
                    //Crear el movimiento de tipo gasto, realizar transaccion y asociar a la lista de movimientos de cuenta
                    val nuevoGasto = Gasto(
                        cuentaSeleccionada ?: throw Exception("NO HAY CUENTA PRINCIPAL ASOCIADA A USUARIO"),
                        montoGasto,
                        descripcion,
                        categoria
                    )
                    if (nuevoGasto.actualizarSaldo()) { // Si la transaccion se realizo con exito
                        usuario.listaCuentas.get(0).listaMovimientos.add(nuevoGasto)
                        println("GASTO REGISTRADO CON EXITO")
                        Utilidades.limpiarPantalla()
                    } else {
                        println("NO SE PUDO REALIZAR EL MOVIMIENTO")
                        Utilidades.limpiarPantalla()
                    }
                }

                3 -> { // TRANSFERENCIA

                }

                4 -> { //Regresar al menu principal
                    SistemaPrincipalController.sistemaPrincipal(usuario)
                }

                else -> {
                    println("OPCION NO VALIDA, INTENTA DE NUEVO")
                    Utilidades.limpiarPantalla()
                }
            }
            mostrarOpcionesMovimientos(usuario)
        } while (opcion != 3)
    }
}
