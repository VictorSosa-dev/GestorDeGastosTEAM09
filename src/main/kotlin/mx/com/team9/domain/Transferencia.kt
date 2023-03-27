package mx.com.team9.domain

interface Transferencia {

    // Función que realiza la transferencia de dinero entre dos cuentas
    fun transferir(cuentaOrigen: Cuenta, cuentaDestino: Cuenta, monto: Double, descripcion: String)
}