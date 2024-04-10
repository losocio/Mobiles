package com.example.comunicacion.model

class Marca (var nombre: String, var imagen: Int, var calidad: String){ //imagener como Int, son punteros

    override fun toString(): String {
        return nombre
    }
}