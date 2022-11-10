package com.cevdetyilmaz.invitefriendcase.domain.model

import androidx.annotation.IntDef

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
@IntDef(
    InviteUserViewType.INVITED_USER,
    InviteUserViewType.INVITE_USER
)
@Retention(AnnotationRetention.SOURCE)
annotation class InviteUserViewType {
    companion object {
        const val INVITED_USER = 1
        const val INVITE_USER = 2
    }
}