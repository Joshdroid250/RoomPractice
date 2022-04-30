package com.example.peliculas.models.Dao
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.peliculas.models.Genero
@Dao
interface Genero_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenero(usuario: Genero)

    @Query("SELECT * FROM Genero")
    fun getAllRealData(): LiveData<List<Genero>>

    @Query("SELECT * FROM Genero")
    suspend fun getAllGenero(): List<Genero>

    @Query("SELECT * FROM Genero where id_Genero= :id")
    suspend fun getByIdGenero(id: Int): Genero

    @Update
    fun updateGenero(usuario: Genero)

    @Delete
    fun deleteGenero(usuario: Genero)
    @Query("Delete from Genero")
    suspend fun deleteAll()
}