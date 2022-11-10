package com.cevdetyilmaz.invitefriendcase.domain.model

import androidx.annotation.DrawableRes

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
data class UserRow(
    val fullName: String?,
    @DrawableRes val image: Int?,
    val inviteDate: String?,
    val amountText: String?,
    val amountTextColor: String?,
    @InviteUserViewType val userType: Int?
)
