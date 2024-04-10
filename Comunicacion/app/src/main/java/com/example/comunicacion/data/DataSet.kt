package com.example.comunicacion.data

import com.example.comunicacion.R
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Modelo

class DataSet {
    // aqui tengo la lista de todos los datos que nameja la app
    // quiero que estos sean capturados automaticamente
    // no necesito tener la intancia del objeto para ejecutar un metodo

    companion object{
        fun getAllMarcas(): ArrayList<Marca> {
            val listaMarcas = ArrayList<Marca>()

            listaMarcas.add(Marca("Audi", R.drawable.audi, "alta"))
            listaMarcas.add(Marca("Mercedes",R.drawable.mercedes, "premium"))
            listaMarcas.add(Marca("Ford",R.drawable.ford,"normal"))
            listaMarcas.add(Marca("VW",R.drawable.vw, "alta"))

            return listaMarcas;
        }

        fun gelAllModelos(): ArrayList<Modelo> {
            val listaModelos = ArrayList<Modelo>();

            listaModelos.add(Modelo("Audi", "A3", 150, 30000.0, R.drawable.audi))
            listaModelos.add(Modelo("Audi", "Aew", 1330, 2000.0, R.drawable.audi))

            listaModelos.add(Modelo("Mercedes", "ewe", 10, 300.0, R.drawable.mercedes))
            listaModelos.add(Modelo("Mercedes", "kek", 10326, 35550.0, R.drawable.mercedes))

            listaModelos.add(Modelo("Ford", "3434e", 1032, 5550.0, R.drawable.ford))
            listaModelos.add(Modelo("Ford", "LOLOLO", 130, 3.0, R.drawable.ford))


            return listaModelos.filter {
                return@filter it.marca.equals(marca)
            } as ArrayList<Modelo>
        }
    }
}