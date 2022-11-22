package com.cevdetyilmaz.invitefriendcase.data.model.response

data class User(
    val firstName: String?,
    val lastName: String?,
    val isEarned: Boolean?,
    val maximumEarnAmount: Int?,
    val totalEarned: Int?,
    val date: Long?
)