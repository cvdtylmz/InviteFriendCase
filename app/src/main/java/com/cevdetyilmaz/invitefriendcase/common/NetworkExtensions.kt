package com.cevdetyilmaz.invitefriendcase.common

import retrofit2.HttpException
import retrofit2.Response

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T?> {
    return try {
        val response = call()
        val data = response.body()
        if (response.hasErrors()) {
            Resource.Failure("No Fetch")
        } else {
            Resource.Success(data)
        }

    } catch (e: HttpException) {
        return Resource.Failure(e.toString())
    }

}

fun <T> Response<T>.hasErrors(): Boolean {
    return (!this.isSuccessful || this.code() in 400..500 || this.body() == null)
}