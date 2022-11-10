package com.cevdetyilmaz.invitefriendcase.domain.usecase

import com.cevdetyilmaz.invitefriendcase.common.Resource

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
interface SingleUseCase<in Params, Type> {
    suspend fun execute(params: Params): Resource<Type>
}