package com.henrymoya.amobaapp.core.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrymoya.amobaapp.R
import com.henrymoya.amobaapp.data.network.model.paciente.Paciente
import com.henrymoya.amobaapp.data.network.model.paciente.PacienteResponse
import com.henrymoya.amobaapp.databinding.ItemPacienteBinding

class PacienteAdapter(
    val listPacientes: PacienteResponse,
    private val itemSelector: (Paciente) -> Unit
) : RecyclerView.Adapter<PacienteAdapter.PacientesViewHolder>() {

    class PacientesViewHolder(
        private var binding: ItemPacienteBinding,
        var itemSelecter: (Paciente) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(paciente: Paciente) {
            binding.apply {
                userFirstName.text = "${paciente.nombre} ${paciente.apellido}"
                this.itemsClient.setOnClickListener {
                    itemSelecter(paciente)
                    itemsClient.setCardBackgroundColor(Color.GRAY)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacientesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PacientesViewHolder(
            ItemPacienteBinding.inflate(layoutInflater, parent, false),
            itemSelector
        )
    }

    override fun getItemCount(): Int {
        return listPacientes.pacientes.size
    }

    override fun onBindViewHolder(holder: PacientesViewHolder, position: Int) {
        holder.bind(listPacientes.pacientes[position])
    }

}