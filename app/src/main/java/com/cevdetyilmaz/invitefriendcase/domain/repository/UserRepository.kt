package com.cevdetyilmaz.invitefriendcase.domain.repository

import com.cevdetyilmaz.invitefriendcase.common.Resource
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteScreen

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
interface UserRepository {
    suspend fun getInviteList(): Resource<InviteScreen>
}