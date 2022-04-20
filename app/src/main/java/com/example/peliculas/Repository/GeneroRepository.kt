package com.example.peliculas.Repository



interface GeneroRepository {

    suspend fun insertUser(user: User)
}