package com.example.peliculas.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.R
import com.example.peliculas.models.ClasificacionModel

class AdapterClasificacion(val clasificacionLista: List<ClasificacionModel>): RecyclerView.Adapter<AdapterClasificacion.AdapterClasificacionHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterClasificacionHolder {
        val verClasificacion: View = LayoutInflater.from(parent.context).inflate(R.layout.list_clasificacion, null,false)
        return AdapterClasificacionHolder(verClasificacion)
    }

    override fun onBindViewHolder(holder: AdapterClasificacionHolder, position: Int) {
         val current = clasificacionLista[position]
        holder.abreviacion.text = current.abreviacion
        holder.nombre.text = current.nombre
        holder.estado.text = "${
            current.activo.toString()
        }"
    }

    override fun getItemCount(): Int = clasificacionLista.size


    class AdapterClasificacionHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val abreviacion: TextView = itemView.findViewById(R.id.tvAbreviacion)
        val nombre: TextView = itemView.findViewById(R.id.tvName)
        val estado: TextView = itemView.findViewById(R.id.tvEstado)
    }

}