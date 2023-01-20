package com.example.apitest.data.model

import com.squareup.moshi.Json

data class Datum(
    @Json(name = "author") var author: String? = null,

    @Json(name = "datetime") var datetime: String? = null,

    @Json(name = "description") var description: String? = null,

    @Json(name = "title") var title: String? = null
)