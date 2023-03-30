package mx.com.team9.mocks

import mx.com.team9.domain.Cuenta
import mx.com.team9.domain.Usuario

class Mock {

    fun mockData(): MutableList<Usuario> {
        val listaUsuarios = mutableListOf<Usuario>()
        val usuario1 = Usuario("1", "Victor", "vic@vic.com", "123")
        val usuario2 = Usuario("2", "Kef", "kef@kef.com", "123")
        usuario1.agregarCuenta(Cuenta("1", 1000.0,"Cuenta Pricipal" ))
        usuario2.agregarCuenta(Cuenta("2", 2000.0,"Cuenta Principal" ))
        usuario1.agregarCuenta(Cuenta("3", 3000.0,"Cuenta Secundaria" ))
        listaUsuarios.add(usuario1)
        listaUsuarios.add(usuario2)
        return listaUsuarios

    }

}