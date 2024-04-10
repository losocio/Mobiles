package com.example.comunicacion.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comunicacion.R
import com.example.comunicacion.model.Modelo
import java.util.ArrayList
import kotlin.collections.ArrayList

// adapatar lo modelos dentro de la lista

class AdaptadorModelo(var lista: ArrayList<Modelo>) : RecyclerView.Adapter<AdaptadorModelo.MyHolder>(){

    //representa el aspecto de una fila de la lista
    class MyHolder (item: View) : RecyclerView.ViewHolder(item){
        //definir cad uno de los elemento de la fila
        var imagen: ImageView = item.findViewById(R.id.imagenFila)
        var titulo: TextView = item.findViewById(R.id.tituloFila)
        var subtitulo: TextView = item.findViewById(R.id.subtituloFila)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //creara la plantilla asociada
        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.item_modelo, parent,
            false
        ) //siempre a falso
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantos elemento tengo que pintar -> LOS QUE HAY EN LA LISTA A REPRESENTAR
        return lista.size;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // asociar el holder (XML) con los datos de la LISTA

        val elemento = lista[position]

        holder.titulo.text
        holder.subtitulo.text
        holder.imagen.setImageResource(elemento.imagen)
        holder.imagen.setOnClickListener{
            /*val intent: Intent = Intent(context, )
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)*/
        }
    }

    fun cambiarLista(lista: ArrayList<Modelo>) {
        this.lista = lista;
        notifyDataSetChanged()
    }


}