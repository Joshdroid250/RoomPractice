package com.example.peliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.peliculas.databinding.FragmentAddGeneroBinding
import com.example.peliculas.models.Genero
import com.example.peliculas.viewModels.GeneroViewModel



class addGenero : Fragment() {
    lateinit var binding: FragmentAddGeneroBinding
    private lateinit var viewModel: GeneroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAddGeneroBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(GeneroViewModel::class.java)

        binding.btnSaveG.setOnClickListener {
            saveGenero()
        }
        return binding.root
    }

    private fun saveGenero(){
        val nombre = binding.edtGenero.text.toString()

        val genero = Genero(0, nombre, activo = true)

        viewModel.agregarGenero(genero)
        Toast.makeText(requireContext(), "Registro guardado",
            Toast.LENGTH_LONG).show()
    }
}