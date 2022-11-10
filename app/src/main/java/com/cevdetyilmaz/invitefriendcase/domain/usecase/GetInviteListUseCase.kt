package com.cevdetyilmaz.invitefriendcase.domain.usecase

import com.cevdetyilmaz.invitefriendcase.common.Resource
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteScreen
import com.cevdetyilmaz.invitefriendcase.domain.repository.UserRepository
import javax.inject.Inject

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */

/**
 * Usecase layer is bridge layer between DATA layer and UI layer and had to single responsibility get post or combine logics.
 */

class GetInviteListUseCase @Inject constructor(
    private val repository: UserRepository,
) : SingleUseCase<Unit, InviteScreen> {

    override suspend fun execute(params: Unit): Resource<InviteScreen> = repository.getInviteList()
}
