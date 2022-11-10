package com.cevdetyilmaz.invitefriendcase.data.remote

import com.cevdetyilmaz.invitefriendcase.data.model.response.Invite
import retrofit2.Response
import retrofit2.http.GET

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
interface ApiService {
    @GET(".")
    suspend fun getInviteList(): Response<Invite>
}