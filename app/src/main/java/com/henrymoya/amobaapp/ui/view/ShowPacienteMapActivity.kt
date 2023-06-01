package com.henrymoya.amobaapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.henrymoya.amobaapp.R
import com.henrymoya.amobaapp.databinding.ActivityShowPacienteMapBinding

class ShowPacienteMapActivity : AppCompatActivity() , OnMapReadyCallback {
    lateinit var binding:ActivityShowPacienteMapBinding
    lateinit var map: GoogleMap
    var latitud:Double=0.0
    var longitud:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowPacienteMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        latitud = intent.getFloatExtra("latitud", 0f).toDouble()
        longitud = intent.getFloatExtra("longitud", 0f).toDouble()
        createFragment()
    }

    fun createFragment() {
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.googleMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.uiSettings.isZoomControlsEnabled = true
        createMarker(39.481106, -0.340987)
    }

    fun createMarker(latitud:Double,longitud:Double){
        val marker = LatLng(latitud,longitud)
        map.addMarker(MarkerOptions().position(marker).title("Ubicación actual"))
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(marker,18f),4000,null)
    }
}