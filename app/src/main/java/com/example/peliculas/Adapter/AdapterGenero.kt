package com.example.peliculas.Adapter

import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.peliculas.R
import com.example.peliculas.models.Genero

class AdapterGenero(val generoLista: List<Genero>): RecyclerView.Adapter<AdapterGenero.AdapterGeneroHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterGeneroHolder {
        val verGenero: View = LayoutInflater.from(parent.context).inflate(R.layout.list_genero, null, false)
        return AdapterGeneroHolder(verGenero)
    }

    override fun onBindViewHolder(holder: AdapterGenero.AdapterGeneroHolder, position: Int) {
        val current = generoLista[position]
        holder.nombre.text = current.nombre
        holder.activo.text = "${
            current.activo.toString()
        }"

    }
    override fun getItemCount(): Int = generoLista.size

    class AdapterGeneroHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nombre: TextView = itemView.findViewById(R.id.tvNombre)
        val  activo: TextView = itemView.findViewById(R.id.tvActivo)
    }
}