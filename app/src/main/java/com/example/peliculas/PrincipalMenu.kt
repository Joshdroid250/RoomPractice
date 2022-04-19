package com.example.peliculas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.peliculas.databinding.FragmentPrincipalMenuBinding


class PrincipalMenu : Fragment() {
    lateinit var fragBinding: FragmentPrincipalMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragBinding = FragmentPrincipalMenuBinding.inflate(layoutInflater)
        return fragBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragBinding.btnVerGenero.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalMenu_to_listGenero)
        }
        fragBinding.addGenero.setOnClickListener {
            it.findNavController().navigate(R.id.action_principalMenu_to_addGenero2)
        }
    }
}