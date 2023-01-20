package com.example.apitest.data.api

import com.example.apitest.data.model.Film
import retrofit2.Response

interface ApiHelper {
   suspend fun getFilm(): Response<Film>
}