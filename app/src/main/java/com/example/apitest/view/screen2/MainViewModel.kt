package com.example.apitest.view.screen2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apitest.data.model.Film
import com.example.apitest.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: MainRepository) : ViewModel() {

    private var films: MutableLiveData<Resource<Film>>

    init {
        films = MutableLiveData()
        films.value = Resource.loading(null)
    }

    fun getFilmFromAPI() {
        viewModelScope.launch {
            repo.getFilm().let {
                films.value = if (it.isSuccessful) Resource.success(it.body()) else Resource.error(
                    null, it.code().toString()
                )
            }
        }
    }

    fun getFilms() = films
}