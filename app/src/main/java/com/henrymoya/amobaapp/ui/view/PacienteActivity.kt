package com.henrymoya.amobaapp.ui.view

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.henrymoya.amobaapp.core.adapter.PacienteAdapter
import com.henrymoya.amobaapp.core.sesion.SessionManagement
import com.henrymoya.amobaapp.data.network.model.paciente.Paciente
import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import com.henrymoya.amobaapp.databinding.ActivityPacienteBinding
import com.henrymoya.amobaapp.ui.viewmodel.PacienteViewModel

class PacienteActivity : AppCompatActivity() {
    lateinit var binding: ActivityPacienteBinding
    private val pacienteViewModel: PacienteViewModel by viewModels()
    lateinit var  sessionManagement : SessionManagement
    private var pacienteAdapter: PacienteAdapter = PacienteAdapter(PacienteResponse(emptyList())) {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPacienteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sessionManagement = SessionManagement(this)
        var idClient = intent.getStringExtra("idUser")

        pacienteViewModel.getPacientes(idClient!!, sessionManagement.getToken())
        val layoutManager = LinearLayoutManager(this)
        binding.pacienteList.layoutManager = layoutManager

        pacienteViewModel.pacientes.observe(this, Observer {
            if (!it.pacientes.isNullOrEmpty()) {
                binding.pacienteList.isVisible = true
                pacienteAdapter = PacienteAdapter(it) {
                    clikItem(it)
                }
                binding.pacienteList.adapter = pacienteAdapter
            }
        })
        pacienteViewModel.isShaimer.observe(this, Observer {
            binding.viewPacientetList.isVisible = it
        })

        binding.logOut.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Salir")
                .setMessage("¿Desea cerrar sesión ?")
                .setPositiveButton("Aceptar",
                    DialogInterface.OnClickListener { dialog, id ->
                        finish()
                        sessionManagement.logoutUser()
                        val intent= Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
            builder.show()
        }
    }

    fun clikItem(paciente: Paciente) {
        var intent = Intent(this,ShowPacienteActivity::class.java)
        intent.putExtra("paciente", paciente)
        startActivity(intent)
    }
}