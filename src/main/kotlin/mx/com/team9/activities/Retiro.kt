package mx.com.team9.activities

import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import mx.com.team9.utils.TipoMovimiento
import java.time.LocalDateTime
/**
 * Clase que representa un retiro de una cuenta
 */
class Retiro : Transaccion() {
    override val fecha: LocalDateTime
        get() = TODO("Not yet implemented")
    override val monto: Double
        get() = TODO("Not yet implemented")
    override val descripcion: String
        get() = TODO("Not yet implemented")
    override val cuentaOrigen: Cuenta
        get() = TODO("Not yet implemented")
    override val categoria: Categoria
        get() = TODO("Not yet implemented")
    override val tipo: TipoMovimiento
        get() = TODO("Not yet implemented")

    override fun movimiento(
        monto: Double,
        cuenta: Cuenta,
        tipo: TipoMovimiento,
        descripcion: String,
        categoria: Categoria
    ) {
        TODO("Not yet implemented")
    }


}