package com.henrymoya.amobaapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.data.network.model.user.UserResponse
import com.henrymoya.amobaapp.domain.AuthenticationUseCase
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var userResponse = MutableLiveData<UserResponse>()
    var authenticationUseCase = AuthenticationUseCase()
    var loading = MutableLiveData<Boolean>(true)

    fun login(user: UserRequest){
       viewModelScope.launch {
           loading.value = true
           var response = authenticationUseCase.authenticationUser(user)
           userResponse.postValue(response)
           loading.value = false
       }
    }
}