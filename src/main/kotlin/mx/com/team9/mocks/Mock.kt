package mx.com.team9.mocks

import mx.com.team9.domain.*
import mx.com.team9.utils.Categoria

// Clase que simula una base de datos inicial de la app
class Mock {

    fun mockData(): MutableList<Usuario> {
        val listaUsuarios = mutableListOf<Usuario>()
        val usuario1 = Usuario("1", "Victor", "vic@vic.com", "123")
        val usuario2 = Usuario("2", "Kef", "kef@kef.com", "123")
        val usuario3 = Usuario("3", "Juan", "j@j.com", "123")
        usuario1.agregarCuenta(Cuenta("C1", 1000.0,"Cuenta Pricipal" ))
        usuario1.agregarCuenta(Cuenta("C2", 3000.0,"Cuenta Secundaria" ))
        usuario2.agregarCuenta(Cuenta("K1", 2000.0,"Cuenta Principal" ))
        usuario2.agregarCuenta(Cuenta("K2", 2000.0,"Cuenta Ahorro" ))
        usuario3.agregarCuenta(Cuenta("Em", 2000.0,"Principal" ))
        //Agregando movimientos de ejemplo
        usuario1.listaCuentas[0].apply {
            listaMovimientos.add(Ingreso(this, 8000.0, "QUINCENA 1RA MAYO", Categoria.SALARIO))
            listaMovimientos.add(Ingreso(this, 500.0, "TANDA", Categoria.OTROS))
            listaMovimientos.add(Ingreso(this, 2000.0, "UTILIDADES", Categoria.SALARIO))
            listaMovimientos.add(Gasto(this, 500.0, "UBER CASA", Categoria.TRANSPORTE))
            listaMovimientos.add(Gasto(this, 1500.0, "DESPENSA", Categoria.COMIDA))
            listaMovimientos.add(Gasto(this, 300.0, "NETFLIX", Categoria.SUSCRIPCIONES))
            val refCuentaSec = usuario1.listaCuentas[1]
            listaMovimientos.add(Transferencia(this, refCuentaSec, 500.0, "TRANSFERENCIA DEUDA 2020", Categoria.OTROS))
            listaMovimientos.add(Transferencia(this, refCuentaSec, 1000.0, "TRANSFERENCIA PAGO RENTA", Categoria.HOGAR))
            listaMovimientos.add(Transferencia(refCuentaSec, this, 2000.0, "TRANSFERENCIA AHORROS", Categoria.HOGAR))
        }
        listaUsuarios.add(usuario1)
        listaUsuarios.add(usuario2)
        return listaUsuarios
    }
}