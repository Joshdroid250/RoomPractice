package com.example.peliculas.models.Dao

import androidx.room.*
import com.example.peliculas.models.ClasificacionModel
import com.example.peliculas.models.Genero

@Dao
interface ClasificacionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClasificacion(usuario: ClasificacionModel)

    @Query("Select * from clasificacion")
    suspend fun getAllGenero(): List<ClasificacionModel>

    @Query("SELECT * FROM clasificacion where idClasificacion= :id")
    suspend fun getByIdClasificacion(id: Int): ClasificacionModel

    @Update
    fun updateClasificacion(usuario: ClasificacionModel)

    @Delete
    fun deleteClasificacion(usuario: ClasificacionModel)
}