package com.henrymoya.amobaapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.henrymoya.amobaapp.core.sesion.SessionManagement
import com.henrymoya.amobaapp.data.network.model.user.UserRequest
import com.henrymoya.amobaapp.databinding.ActivityLoginBinding
import com.henrymoya.amobaapp.ui.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()
    lateinit var  sessionManagement : SessionManagement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sessionManagement = SessionManagement(this)

        binding.apply {
            loginButton.setOnClickListener {
                var user = UserRequest(
                    emailInput.editableText.toString(),
                    passwordInput.editableText.toString()
                )
                userViewModel.login(user)
                userViewModel.userResponse.observe(this@LoginActivity, Observer { user ->
                    if (!user.email.equals("")) {
                         sessionManagement.setToken(user.idToken)
                        finish()
                        val intent = Intent(this@LoginActivity, PacienteActivity::class.java)
                        intent.putExtra("idUser", user.localId)
                        startActivity(intent)
                    }
                })
                userViewModel.loading.observe(this@LoginActivity, Observer{
                    binding.loading.isVisible = it
                })
            }
        }
    }
}