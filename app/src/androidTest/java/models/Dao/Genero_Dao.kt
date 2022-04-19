package models.Dao
import androidx.room.*
import models.Genero
@Dao
interface Genero_Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenero(usuario: Genero)

    @Query("Select * from Genero")
    suspend fun getAllGenero(): List<Genero>

    @Query("SELECT * FROM Genero where id_Genero= :id")
    suspend fun getByIdGenero(id: Int): Genero

    @Update
    fun updateGenero(usuario: Genero)

    @Delete
    fun deleteGenero(usuario: Genero)
}