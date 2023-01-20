package com.example.apitest.data.api

import com.example.apitest.data.model.Film
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(" ")
    suspend fun getFilm(): Response<Film>
}