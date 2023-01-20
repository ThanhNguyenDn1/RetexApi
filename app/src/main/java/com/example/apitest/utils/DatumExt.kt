package com.example.apitest.utils

import com.example.apitest.data.model.Datum
import com.example.apitest.data.model.Film
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Datum.filmToString(): String {
    val gson = Gson()
    return gson.toJson(this)
}

fun String.stringToDatum(): Datum {
    val gson = Gson()
    val type = object : TypeToken<Datum?>() {}.type
    return gson.fromJson(this, type)
}