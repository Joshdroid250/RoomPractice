package com.example.peliculas.viewModels
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.peliculas.Repository.GeneroRepository
import com.example.peliculas.models.Dao.Genero_Dao
import com.example.peliculas.models.Genero
import com.example.peliculas.models.MainBaseDatos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeneroViewModel (application:
    Application): AndroidViewModel(application) {

        val listaG: LiveData<List<Genero>>
        private val repository: GeneroRepository
        init {
            val generodao =
                MainBaseDatos.getDataBase(application).generoDao()
            repository = GeneroRepository(generodao)
            listaG = repository.lista
        }

    fun agregarGenero(genero: Genero){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGenero(genero)
        }
    }

    fun actualizarGenero(genero: Genero){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateGenero(genero)
        }
    }

    fun eliminarGenero(genero: Genero){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteGenero(genero)
        }
    }
    fun eliminarTodo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }


}