package com.example.comunicacion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AbsSpinner
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.comunicacion.R
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nombre: String
    private lateinit var adapterSpinner: ArrayAdapter<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //crea la parte de datos del spinner


        instancias();
        persoAdaptadores();




        // cada vez que cambia la seleccion del spinner, que salga un Snackbar con el nombre de la
        // marca

        this.nombre = intent.getStringExtra("correo")!!
        binding.textoSaludo.text = nombre

        // arraylist con todas las marcas

        acciones();
        //TODO: implementar: cada vez que cambia la seleccion del spinner, que salga en Snackbar con el nombre del la marca
        binding.spinnerSeleccion.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val seleccion : Marca = parent!!.adapter.getItem(position) as Marca
                Snackbar.make(
                    binding.root,
                    "${seleccion.nombre} ${seleccion.calidad}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    /*
    * Crear un a clase que tenga: marca, modelo, cv(int), precio(d), imagen(int)
    * */


        // se definen los datos en el strings
        // se definen los graficos en el xml

        //arraylist con todas las marcas
        //DataSet.getAllMarcas()


        /* estaba escrito dos veces
        binding.spinnerSeleccion.onItemSelectedListener = object : OnItemSelectedListener { //el icono de V es una variable, El icono M es un metodo
            // NOTE: Alt + Enter para autocompletar
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int, // posicion lista espiner
                id: Long //id elemento pos 1, 2,3 etc
            ) {
                //Para fetch de recursos
                //R.drawable

                Snackbar.make(
                    binding.root,
                    "${selecccion.nombre} ${selecccion.calidad}",
                    //parent!!.adapter.getItem(position).toString(),
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }*/
    }
    fun instancias(){
        //inicializar variables
        adapterSpinner = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )
    }
    fun persoAdaptadores(){
        //juntar parte grafica con logica
        binding.spinnerSeleccion.adapter=adapterSpinner
        // muestra el desplegabla mas bonito, de forma visible
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.recyclerModelos.adapter = adaptadorModelo
        binding.reclyerModelos.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.recyclerModelos.layoutManager =
                GridLayoutManager(this, 2)
        }



    }

    fun acciones(){
        binding.spinnerSeleccion.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccion : Marca = parent!!.adapter.getItem(position) as Marca

                //filtrar lista -> DATASET
                //cambiar lista -> ADAPTADOR
                adapatadorModelo.cambiarLista(DataSet.gelAllModelos(seleccion.nombre))

                Snackbar.make(
                    binding.root,
                    "${seleccion.nombre} ${seleccion.calidad}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}