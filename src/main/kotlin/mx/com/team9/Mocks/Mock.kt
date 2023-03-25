package mx.com.team9.Mocks

import mx.com.team9.activities.Cuenta
import mx.com.team9.activities.Usuario
import java.time.LocalDateTime

class Mock {

    fun MockData(): MutableList<Usuario> {
        val listaUsuarios = mutableListOf<Usuario>()
        val usuario1 = Usuario("1", "Victor", "vic@gmail.com", "123")
        val usuario2 = Usuario("2", "Kef", "kef@gmail.com", "123")
        usuario1.creaCuenta(Cuenta("1", 1000.0, LocalDateTime.now()))
        usuario2.creaCuenta(Cuenta("2", 2000.0, LocalDateTime.now()))
        listaUsuarios.add(usuario1)
        listaUsuarios.add(usuario2)
        return listaUsuarios

    }

}