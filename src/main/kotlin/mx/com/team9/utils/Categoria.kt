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
    VIATICOS(10, " GASTOS LABORALES"),
    TRANSPORTE(11, "MOVILIDAD URBANA"),
    IMPUESTOS(12, "PAGOS GUBERNAMENTALES"),
    EDUCACION(13, " FORMACIÓN ACADÉMICA"),
    AHORRO(14, "GUARDAR DINERO"),
    EJERCICIO(15, "GIMNASIOS, CLUBES Y DEPORTES"),
    MASCOTAS(16, "CUIDADO ANIMAL"),
    SERVICIOS_PUBLICOS(17, " SUMINISTROS BÁSICOS"),
    COMUNICACIONES(18, "COMUNICACIÓN MÓVIL"),
    SUSCRIPCIONES(19, "PAGOS PERIÓDICOS"),
    DONACIONES(20, "DONACIONES Y AYUDAS"),
    DEUDAS_PRESTAMOS(21, "PAGOS DE CRÉDITOS"),
    OTROS(22, "GASTOS DIVERSOS");

    companion object {
        fun mostrarCategorias() = runBlocking{
            print("CARGANDO CATEGORIAS")
            for (i in 1..3) {
                print(".")
                delay(1000)
            }
            for(categoria in values())
                println("${categoria.idCategoria}. ${categoria.name}: ${categoria.descripcion}")
        }

        fun seleccionarCategoria(tipoMovimiento: String): Categoria {
            println("SELECCIONA UNA CATEGORIA DE TU $tipoMovimiento")
            mostrarCategorias()
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