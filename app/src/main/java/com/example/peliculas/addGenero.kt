package com.example.peliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.peliculas.databinding.FragmentAddGeneroBinding
import com.example.peliculas.models.Dao.Genero_Dao
import com.example.peliculas.models.Genero
import com.example.peliculas.models.db_Genero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class addGenero : Fragment() {
    lateinit var binding: FragmentAddGeneroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAddGeneroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        val db: db_Genero = db_Genero.getInstace(this.requireContext().applicationContext)
        val dao: Genero_Dao = db.generoDao()

        with(binding){
            btnSaveG.setOnClickListener {
                val id = Genero(0,edtGenero.text.toString(), true)

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insertGenero(id)
                }
            }
        }
    }
}