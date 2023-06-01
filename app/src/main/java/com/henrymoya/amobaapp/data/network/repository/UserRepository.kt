package com.henrymoya.amobaapp.data.network.repository

import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.data.network.model.user.UserResponse
import com.henrymoya.amobaapp.data.network.service.UserService

class UserRepository {

    private val api = UserService()
    suspend fun getAllUser(user: UserRequest): UserResponse {
        val response = api.getUser(user)
        return response!!
    }
}