package com.cevdetyilmaz.invitefriendcase.feature.invite

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cevdetyilmaz.invitefriendcase.common.viewBinding
import com.cevdetyilmaz.invitefriendcase.databinding.RowInviteUserBinding
import com.cevdetyilmaz.invitefriendcase.databinding.RowInvitedUserBinding
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteUserViewType
import com.cevdetyilmaz.invitefriendcase.domain.model.UserRow

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
class AdapterInviteList : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataList: ArrayList<UserRow?> = arrayListOf()

    fun updateItemList(itemList: MutableList<UserRow?>?) {
        this.dataList.clear()
        itemList?.let {
            this.dataList.addAll(it)
        }
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            InviteUserViewType.INVITED_USER -> {
                InvitedUserViewHolder(parent.viewBinding(RowInvitedUserBinding::inflate))
            }
            else -> {
                InviteUserViewHolder(parent.viewBinding(RowInviteUserBinding::inflate))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            InviteUserViewType.INVITED_USER -> {
                dataList[position]?.let { (holder as InvitedUserViewHolder).bind(it) }
            }
            else -> {
                holder as InviteUserViewHolder
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position]?.userType ?: -1
    }

    class InvitedUserViewHolder(private val binding: RowInvitedUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserRow) {
            with(binding) {
                txtBenefit.text = item.amountText
                txtBenefit.setTextColor(Color.parseColor(item.amountTextColor))
                txtInviteDate.text = item.inviteDate
                txtUserFullName.text = item.fullName
            }
        }
    }

    class InviteUserViewHolder(binding: RowInviteUserBinding) :
        RecyclerView.ViewHolder(binding.root)
}