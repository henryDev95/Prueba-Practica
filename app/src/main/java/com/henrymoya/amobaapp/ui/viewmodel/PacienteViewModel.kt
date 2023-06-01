package com.henrymoya.amobaapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.henrymoya.amobaapp.data.network.model.paciente.Paciente
import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import com.henrymoya.amobaapp.domain.GetPacientesUseCase
import kotlinx.coroutines.launch

class PacienteViewModel:ViewModel(){
    var pacienteUserCase = GetPacientesUseCase()
    var pacientes = MutableLiveData<PacienteResponse>(PacienteResponse(emptyList()))
    val isShaimer = MutableLiveData<Boolean>(true)
    fun getPacientes(idUser:String, token:String){
        viewModelScope.launch {
            isShaimer.value = true
            var response = pacienteUserCase.getPacientes(idUser, token)
            if(!response.pacientes.isNullOrEmpty()){
                pacientes.value = response
            }
            isShaimer.value = false
        }
    }

}