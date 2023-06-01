package com.henrymoya.amobaapp.data.network.service

import com.henrymoya.amobaapp.BuildConfig
import com.henrymoya.amobaapp.BuildConfig.API_DATA
import com.henrymoya.amobaapp.core.RetrofitHelper
import com.henrymoya.amobaapp.data.network.apiclient.PacienteApiClient
import com.henrymoya.amobaapp.data.network.apiclient.UserApiClient
import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.data.network.model.user.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PacienteService {
    private val retrofit = RetrofitHelper.getRetrofit(API_DATA)
    suspend fun getPacientes(idUser:String, auth:String ): PacienteResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(PacienteApiClient::class.java).getPacientes(idUser, auth)
            if(response.isSuccessful){
                response.body()!!
            }else{
                PacienteResponse(emptyList())
            }
        }
    }

}