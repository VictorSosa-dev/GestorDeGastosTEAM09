package mx.com.team9.domain

import mx.com.team9.models.Categoria
import mx.com.team9.utils.TipoCategoria
import java.time.LocalDateTime

class Ingreso(
    cuenta: Cuenta,
    monto: Double,
    descripcion: String,
    categoria: TipoCategoria
) : Movimiento(cuenta, monto, descripcion, categoria) {

    override val idMovimiento: String = "ING-${cuenta.idCuenta}-${LocalDateTime.now()}"
    override val fecha: LocalDateTime = LocalDateTime.now()

    override fun actualizarSaldo(): Boolean {
        cuenta.saldo += monto
        return true
    }
}
