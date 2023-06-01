package com.henrymoya.amobaapp.data.network.service

import com.henrymoya.amobaapp.BuildConfig.API_HOST
import com.henrymoya.amobaapp.BuildConfig.API_KEY
import com.henrymoya.amobaapp.core.RetrofitHelper
import com.henrymoya.amobaapp.data.network.apiclient.UserApiClient
import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.data.network.model.user.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserService {

    private val retrofit = RetrofitHelper.getRetrofit(API_HOST)
    suspend fun getUser(user: UserRequest): UserResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UserApiClient::class.java).loginUser(user, API_KEY)
           if(response.isSuccessful){
               response.body()!!
           }else{
               UserResponse("","", "")
           }
        }
    }
}