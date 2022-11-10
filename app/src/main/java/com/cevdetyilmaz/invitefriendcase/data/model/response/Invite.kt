package com.cevdetyilmaz.invitefriendcase.data.model.response

data class Invite(
    val maximumEarning: Int?,
    val paidAmount: Int?,
    val potentialEarned: Int?,
    val totalEarned: Int?,
    val userList: List<User?>
)