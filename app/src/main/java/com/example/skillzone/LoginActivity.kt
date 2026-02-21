package com.example.skillzone

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.skillzone.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener(this)
        binding.btnIrARegistro.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnIrARegistro -> {
                startActivity(Intent(this, RegistroActivity::class.java))
            }
            R.id.btnEntrar -> {
                val emailEscrito = binding.etEmail.text.toString()
                val passEscrito = binding.etPassword.text.toString()
                val preferencias = getSharedPreferences("mis_datos", Context.MODE_PRIVATE)
                val emailGuardado = preferencias.getString("email_guardado", "")
                val passGuardada = preferencias.getString("clave_guardada", "")

                if (emailEscrito == emailGuardado && passEscrito == passGuardada && emailEscrito.isNotEmpty()) {
                    binding.tvError.text = ""
                    // Ir a MainActivity
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    binding.tvError.text = "Email o contraseña incorrectos"
                }
            }
        }
    }
}