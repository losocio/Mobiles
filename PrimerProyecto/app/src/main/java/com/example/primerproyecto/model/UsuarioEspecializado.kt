package com.example.primerproyecto.model

import com.example.primerproyecto.model.Usuario

// herencia de clases y sobreescribir metodos
class UsuarioEspecializado (nombre: String, correo: String, pass: String, var salario: Int):
    Usuario(nombre, correo, pass) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario $salario")
        val usuario = Usuario(correo="asd")// parametros posicionales, siuen la posicion de los param de la def de la clase
    }
}