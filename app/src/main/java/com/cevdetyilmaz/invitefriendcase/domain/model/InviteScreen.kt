package com.cevdetyilmaz.invitefriendcase.domain.model

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
data class InviteScreen(
    val totalEarningText: String?,
    val potentialEarningText: String?,
    val maxEarningText: String?,
    val userList: List<UserRow?>?
)