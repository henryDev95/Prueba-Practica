package com.henrymoya.amobaapp.data.network.apiclient

import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PacienteApiClient {
    @GET("/medicos/{idUser}.json")
    suspend fun getPacientes(@Path("idUser") idUser:String, @Query("auth") auth:String):Response<PacienteResponse>
}