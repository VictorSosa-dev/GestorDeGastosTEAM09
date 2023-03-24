package mx.com.team9.controladores

import mx.com.team9.activities.Usuario

class MenuPrincipalUsuario(private val usuario: Usuario) {
//
//    //Logica de Manejo de Cuenta
//    fun manejoCuenta() {
//        //Revisar si el usuario actual tiene cuentas
//        if (usuario.listaCuentas.isNullOrEmpty()) {
//            //Si no tiene cuentas, lo primero que mostrara es el menu de creacion de cuenta
//            crearCuenta(usuario)
//        }
//        //Si tiene cuentas, mostrara el menu de inicio
//        else {
//            menuInicialCuenta()
//            var opcion = ""
//            do {
//                when(opcion) {
//                    1 -> { // reportes  -> resumen mensual, ultimos movimientos
//
//
//                    }
//                    2 -> { // manejo de cuentas -> crear cuenta, editar cuenta, eliminar cuenta
//
//                    }
//                    3 -> { // Realizar movimientos -> ingreso, gasto, transferencia
//
//                    }
//                    4 -> { // desloguearse
//
//                    }
//                    else -> {
//                        println("Opcion no valida")
//                    }
//                }
//            } while (opcion != "exit")
//            menuInicialCuenta()
//        }
//    }
//
//    private fun crearCuenta(usuario: Usuario) {
//        println("Crear cuenta")
//
//    }
//
//    //Menu inicial de cuenta, muestra opciones como crear cuenta
//    fun menuInicialCuenta() = println("""
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+             CASH MANAGER: A TU GESTOR DE GASTOS          +
//+         Bienvenido ${usuario.getNombre()}                +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//************************************************************
//*                 MENU DE PRINCIPAL                        *
//*           1.- REPORTES               *
//*           2.- MANEJO DE CUENTAS                   *
//*           3.- REALIZAR MOVIMIENTOS                          *
//*           4.- Desloguearse                          *
//************************************************************""".trimIndent())
//
}