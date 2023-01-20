package com.example.apitest.view.screen2

import com.example.apitest.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getFilm() = apiHelper.getFilm()
}