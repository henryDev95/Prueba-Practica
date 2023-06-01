package com.henrymoya.amobaapp.domain

import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import com.henrymoya.amobaapp.data.network.repository.PacienteRepository

class GetPacientesUseCase {
    private val pacienteRepository = PacienteRepository()
    suspend fun getPacientes(idUser: String, auth: String): PacienteResponse {
        return pacienteRepository.getAllUser(idUser, auth)
    }
}