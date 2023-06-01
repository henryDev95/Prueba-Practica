package com.henrymoya.amobaapp.data.network.model.paciente


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class PacienteResponse(
    @SerializedName("pacientes") val pacientes: List<Paciente>
)

@Parcelize
data class Paciente(
    val nombre: String,
    val apellido: String,
    val dni: String,
    val sexo: String,
    val email: String,
    val edad: String,
    val direccion:String,
    val celular: String,
    val latitud: Float,
    val longitud: Float
) : Parcelable