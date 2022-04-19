package models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import models.Dao.Genero_Dao
import models.Genero

interface MainDataBaseProvider{
    fun generoDao() : Genero_Dao


}


abstract class db_Genero: RoomDatabase(), MainDataBaseProvider {
    abstract override fun generoDao(): Genero_Dao

    companion object{
        @Volatile
        private var INSTANCE: db_Genero? = null
        fun getInstace(context: Context): db_Genero {
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        db_Genero::class.java,
                        "dbGenero"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}