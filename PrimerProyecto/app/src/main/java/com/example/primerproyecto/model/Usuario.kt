package com.example.primerproyecto.model

open class Usuario(var nombre: String? = null, var correo: String? = null, var pass: String? = null) { //open para que sea heredable

    //var mutable
    //val unmutable

    //var nombre: String //variables had to ve initialized when created

    init { //se ejecuta siempre despues de los constructores

    }
    //lateinit var nombre: String // para innicializar mas tarde

    //var correo: String? = null; //null safety

    //No es obligatorio tipar las variables
    var telefono: Int? = null
    var direccion: String? = null
    // un constructor primario y despues otros segundarios
    //segundario
    constructor(
        nombre: String,
        correo: String,
        pass: String,
        telefono: Int,
        direccion: String

    ) : this(nombre, correo, pass){ //this() para llamar al constructor primario
        this.telefono = telefono
        this.direccion = direccion
    }

    //void -> Unit
    //Object -> Any
    open fun mostrarDatos() { //si no pongo open el metodo no sera sobreescribible
        println("Nombre: $nombre")
        //println("NUM Char of Nombre: ${nombre?.length ?: 0}") // para ejecutar metodos, si es null nos da 0
        println("NUM Char of Nombre: ${nombre!!.length}") // "te la juegas" a tener un error por null

    }
    open fun mostrarDatos(numero: Int) {

        /*
        //for clasico
        for (i in 0 <= .. < numero-1){

        }*/

        //otro for
        (0..numero).forEach{
            mostrarDatos()
        } // coleccion de datos,luego iterar

        // envez de switch, when
        when(numero){
            0->{
                println("No se van a mostrar datos")
            }

            1->{
                mostrarDatos()
            }// las llaves hacen el break, no hay que ponerlo

        }
    }

}