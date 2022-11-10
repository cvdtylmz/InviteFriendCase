package com.cevdetyilmaz.invitefriendcase.feature.invite

import com.cevdetyilmaz.invitefriendcase.domain.model.InviteScreen

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
sealed class InviteListEvent {
    object Idle : InviteListEvent()
    object Loading : InviteListEvent()
    class DataLoaded(val data: InviteScreen) : InviteListEvent()
    class Error(val error : String) : InviteListEvent()
}