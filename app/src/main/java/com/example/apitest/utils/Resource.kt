package com.example.apitest.utils

data class Resource<out T>(val status: Status?, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(status = Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, msg: String?): Resource<T> {
            return Resource(status = Status.ERROR, null, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(status = Status.LOADING, null, null)
        }
    }
}
