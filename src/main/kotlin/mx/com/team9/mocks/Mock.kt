package mx.com.team9.mocks

import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Usuario
import mx.com.team9.utils.Utilidades

class Mock {

    fun mockData(): MutableList<Usuario> {
        val listaUsuarios = mutableListOf<Usuario>()
        val usuario2 = Usuario(Utilidades.generadorIDUnico(12), "Victor", "vic@vic.comm", "123")
        val usuario1 = Usuario(Utilidades.generadorIDUnico(12), "Kef", "kef@kef.com", "123")
        usuario1.agregarCuenta(Cuenta(Utilidades.generadorIDUnico(5), 1000.0 ))
        usuario1.agregarCuenta(Cuenta(Utilidades.generadorIDUnico(5), 3000.0 ))
        usuario2.agregarCuenta(Cuenta("2", 2000.0, ))
        listaUsuarios.add(usuario1)
        listaUsuarios.add(usuario2)
        return listaUsuarios

    }

}