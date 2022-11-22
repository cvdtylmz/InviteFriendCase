package com.cevdetyilmaz.invitefriendcase.data.mapper

import com.cevdetyilmaz.invitefriendcase.R
import com.cevdetyilmaz.invitefriendcase.common.Constants
import com.cevdetyilmaz.invitefriendcase.common.convertAmountText
import com.cevdetyilmaz.invitefriendcase.common.convertEpocTime
import com.cevdetyilmaz.invitefriendcase.common.convertMaxEarnText
import com.cevdetyilmaz.invitefriendcase.data.model.response.Invite
import com.cevdetyilmaz.invitefriendcase.domain.mapper.DomainMapper
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteScreen
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteUserViewType
import com.cevdetyilmaz.invitefriendcase.domain.model.UserRow
import javax.inject.Inject

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
class InviteScreenMapper @Inject constructor() : DomainMapper<Invite?, InviteScreen> {
    override fun mapToDomainModel(dataModel: Invite?): InviteScreen {
        val list = dataModel?.userList?.mapNotNull { user ->
            UserRow(
                fullName = user?.firstName.plus(user?.lastName),
                image = R.drawable.ic_launcher_foreground,
                inviteDate = user?.date.convertEpocTime(),
                amountText = user?.maximumEarnAmount.convertMaxEarnText(),
                amountTextColor = if (user?.isEarned == true) Constants.COLOR.GRAY else Constants.COLOR.ORANGE,
                userType = InviteUserViewType.INVITED_USER
            )
        }?.toMutableList()
        list?.add(
            UserRow(
                userType = InviteUserViewType.INVITE_USER,
                fullName = null,
                image = null,
                inviteDate = null,
                amountText = null,
                amountTextColor = null
            )
        )
        return InviteScreen(
            totalEarningText = dataModel?.totalEarned.toString().convertAmountText(),
            potentialEarningText = dataModel?.potentialEarned.toString().convertAmountText(),
            maxEarningText = "Maximum Earnings ".plus(
                dataModel?.maximumEarning.toString().convertAmountText()
            ),
            userList = list
        )
    }
}