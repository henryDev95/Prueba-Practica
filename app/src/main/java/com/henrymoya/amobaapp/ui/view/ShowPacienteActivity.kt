package com.henrymoya.amobaapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.henrymoya.amobaapp.R
import com.henrymoya.amobaapp.data.network.model.paciente.Paciente
import com.henrymoya.amobaapp.databinding.ActivityShowPacienteBinding

class ShowPacienteActivity : AppCompatActivity() {
    lateinit var binding: ActivityShowPacienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPacienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var paciente = intent.getParcelableExtra<Paciente>("paciente")!!
        binding.apply {
            userFirstName.text = "${paciente.nombre} ${paciente.apellido}"
            dniPaciente.text = paciente.dni
            email.text = paciente.email
            edadPaciente.text = paciente.edad
            sexoPaciente.text = paciente.sexo
            directionPaciente.text = paciente.direccion
            phonePaciente.text = paciente.celular
            btOpcion.setOnClickListener{
                finish()
            }

            showMap.setOnClickListener {
                intentShowMap(paciente.latitud, paciente.longitud)
            }
        }
    }

    private fun intentShowMap(latitud:Float, longitud:Float) {
        var intent = Intent(this, ShowPacienteMapActivity::class.java)
        intent.putExtra("latitud", latitud)
        intent.putExtra("longitud", longitud)
        startActivity(intent)
    }
}