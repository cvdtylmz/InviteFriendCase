package com.cevdetyilmaz.invitefriendcase.data.source

import com.cevdetyilmaz.invitefriendcase.common.Resource
import com.cevdetyilmaz.invitefriendcase.common.getResult
import com.cevdetyilmaz.invitefriendcase.data.model.response.Invite
import com.cevdetyilmaz.invitefriendcase.data.remote.ApiService
import javax.inject.Inject

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) : RemoteDataSource {
    override suspend fun getInviteList(): Resource<Invite?> {
        return getResult {
            apiService.getInviteList()
        }
    }
}