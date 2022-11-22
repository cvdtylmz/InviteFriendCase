package com.cevdetyilmaz.invitefriendcase.feature.invite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cevdetyilmaz.invitefriendcase.common.Resource
import com.cevdetyilmaz.invitefriendcase.domain.usecase.GetInviteListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *Created by Cevdet Yilmaz on 10.11.2022
 */
@HiltViewModel
class InviteListViewModel @Inject constructor(private val getInviteListUseCase: GetInviteListUseCase) : ViewModel() {

    private val _result = MutableStateFlow<InviteListEvent>(InviteListEvent.Idle)
    val launchResult = _result.asStateFlow()


    fun getInviteList() {
        _result.value = InviteListEvent.Loading
        viewModelScope.launch {
            val response = getInviteListUseCase.execute(Unit)
            when (response) {
                is Resource.Success -> _result.value = InviteListEvent.DataLoaded(response.data)
                is Resource.Failure -> _result.value = InviteListEvent.Error(response.error)
                Resource.Loading -> Unit
            }
        }
    }
}

