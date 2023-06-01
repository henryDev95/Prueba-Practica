package com.henrymoya.amobaapp.domain

import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.data.network.model.user.UserResponse
import com.henrymoya.amobaapp.data.network.repository.UserRepository

class AuthenticationUseCase {
    private var userRepository = UserRepository()
    suspend fun authenticationUser(user: UserRequest): UserResponse {
       return userRepository.getAllUser(user);
    }
}