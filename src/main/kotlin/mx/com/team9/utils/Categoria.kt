package mx.com.team9.utils

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mx.com.team9.utils.Utilidades.limpiarPantalla

// Enumeración que representa los tipos de categorías que pueden tener las transacciones
enum class Categoria(val idCategoria: Int, val descripcion: String) {
    SALARIO(1, "INGRESOS POR TRABAJO"),
    HOGAR(2, "GASTOS DOMÉSTICOS"),
    SEGURO(3, "PÓLIZAS Y COBERTURAS"),
    COMIDA(4, "ALIMENTOS Y BEBIDAS"),
    ENTRETENIMIENTO(5, "OCIO Y DIVERSIÓN"),
    COMPRAS(6, "ADQUISICIONES GENERALES"),
    COMPRAS_ONLINE(7, "ADQUISICIONES DIGITALES"),
    SALUD(8, "SERVICIOS MÉDICOS"),
    VIAJES(9, " VACACIONES Y EXCURSIONES"),
    TRANSPORTE(10, "MOVILIDAD URBANA"),
    EDUCACION(11, " FORMACIÓN ACADÉMICA"),
    EJERCICIO(12, "GIMNASIOS, CLUBES Y DEPORTES"),
    SERVICIOS_PUBLICOS(13, " SUMINISTROS BÁSICOS"),
    COMUNICACIONES(14, "COMUNICACIÓN MÓVIL"),
    SUSCRIPCIONES(15, "PAGOS PERIÓDICOS"),
    DONACIONES(16, "DONACIONES Y AYUDAS"),
    DEUDAS_PRESTAMOS(17, "PAGOS DE CRÉDITOS"),
    OTROS(18, "GASTOS DIVERSOS");

    companion object {
        fun mostrarCategorias() = runBlocking{
            print("CARGANDO CATEGORIAS")
            for (i in 1..3) {
                print(".")
                delay(1000)
            }
            println()
            for(categoria in values())
                println("${categoria.idCategoria}. ${categoria.name}: ${categoria.descripcion}")
        }

        fun seleccionarCategoria(tipoMovimiento: String): Categoria {
            println("SELECCIONA UNA CATEGORIA DE TU $tipoMovimiento")
            mostrarCategorias()
            print("CATEGORIA: ")
            var idCategoria = readln()?.toIntOrNull() ?: 0
            while (idCategoria !in 1..values().size) {
                println("LA CATEGORIA SELECCIONADA NO EXISTE")
                limpiarPantalla()
                mostrarCategorias()
                idCategoria = readln()?.toIntOrNull() ?: 0
            }
            return values()[idCategoria - 1]
        }
    }

}