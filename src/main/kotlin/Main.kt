import mx.com.team9.activities.Deposito
import mx.com.team9.activities.Retiro
import mx.com.team9.dataclase.Categoria
import mx.com.team9.models.Cuenta
import mx.com.team9.models.User
import mx.com.team9.utils.Menu
import mx.com.team9.utils.TipoCategoria

fun main(args: Array<String>) {

    //Aqui se ejectuara el programa principal y se instanciaran las principales clases

    //Mostrar menu de autenticacion

    //Menu de operacion de cuenta

//    val menu = Menu()
//    menu.showMenu()

    //Testing de las clases de Retiro y Deposito
    //Es necesario crear un usuario y una cuenta para ese usuario para poder hacer las pruebas
    val usuarioKef = User("Kef", "123456789", "123")
    val cuentaMaster = Cuenta("123456789", 0.0, "Cuenta de ahorro", "Activa", usuarioKef, null)
    val deposito = Deposito(10000.0, "Pago de utilidades", Categoria(TipoCategoria.SALARIO, "1ra Quincena Marzo"),cuentaMaster )
    //Mostrar mi saldo actual
    println("Mi saldo actual es: ${cuentaMaster.saldo}")
    val retiro = Retiro(4000.0, "Pago de renta", Categoria(TipoCategoria.HOGAR, "Renta Abril"), cuentaMaster)
    println("Mi saldo actual es: ${cuentaMaster.saldo}")

}