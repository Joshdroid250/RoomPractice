package com.example.peliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peliculas.Adapter.AdapterGenero
import com.example.peliculas.databinding.FragmentListGeneroBinding
import com.example.peliculas.models.Dao.Genero_Dao
import com.example.peliculas.models.MainBaseDatos

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class listGenero : Fragment() {

    lateinit var binding: FragmentListGeneroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListGeneroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainBaseDatos = MainBaseDatos.getDataBase(this.requireContext().applicationContext)
        val dao: Genero_Dao = db.generoDao()


        CoroutineScope(Dispatchers.Main).launch {
            var list = dao.getAllGenero()
            binding.RwGenero.layoutManager = LinearLayoutManager(context)
            val adapter = AdapterGenero(list)
            binding.RwGenero.adapter = adapter
            findNavController().navigate(R.id.action_return_to_main)
        }

    }
}