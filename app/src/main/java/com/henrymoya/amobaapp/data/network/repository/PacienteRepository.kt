package com.henrymoya.amobaapp.data.network.repository

import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import com.henrymoya.amobaapp.data.network.service.PacienteService

class PacienteRepository {
    private val api = PacienteService()
    suspend fun getAllUser(idUser:String, auth:String): PacienteResponse {
        val response = api.getPacientes(idUser, auth)
        return response!!
    }
}