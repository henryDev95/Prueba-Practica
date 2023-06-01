package com.henrymoya.amobaapp.data.network.apiclient

import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.data.network.model.user.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApiClient {

    @POST("/v1/accounts:signInWithPassword?")
    suspend fun loginUser(@Body user: UserRequest, @Query("key") key:String): Response<UserResponse>
}