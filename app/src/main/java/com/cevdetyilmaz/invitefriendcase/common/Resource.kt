package com.cevdetyilmaz.invitefriendcase.common

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
sealed class Resource<out R> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure(val error: String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}