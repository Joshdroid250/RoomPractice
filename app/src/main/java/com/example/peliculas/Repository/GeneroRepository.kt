package com.example.peliculas.Repository

import androidx.lifecycle.LiveData
import com.example.peliculas.models.Dao.Genero_Dao
import com.example.peliculas.models.Genero


class GeneroRepository(val dao: Genero_Dao) {
    val lista : LiveData<List<Genero>> =
        dao.getAllRealData()
    suspend fun addGenero(genero: Genero){
        dao.insertGenero(genero)
    }
    suspend fun updateGenero(genero: Genero){
        dao.updateGenero(genero)
    }
    suspend fun deleteGenero(genero: Genero)
    {
        dao.deleteGenero(genero)

    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
}