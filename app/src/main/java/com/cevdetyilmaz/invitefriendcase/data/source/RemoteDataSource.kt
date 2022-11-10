package com.cevdetyilmaz.invitefriendcase.data.source

import com.cevdetyilmaz.invitefriendcase.common.Resource
import com.cevdetyilmaz.invitefriendcase.data.model.response.Invite

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
interface RemoteDataSource {
    suspend fun getInviteList(): Resource<Invite?>
}