package com.example.apitest.data.model

import com.squareup.moshi.Json
class Film {
    @Json(name = "data")
    var data: List<Datum>? = null
}