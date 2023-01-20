package com.example.apitest.data.api

import javax.inject.Inject

class ApiHelperlmpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getFilm() = apiService.getFilm()
}