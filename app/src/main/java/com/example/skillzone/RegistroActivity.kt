package com.example.skillzone

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.skillzone.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardarRegistro.setOnClickListener(this)
        binding.btnBack.setOnClickListener(this)


        binding.btnYaTengoCuenta.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btnBack, R.id.btnYaTengoCuenta -> {
                finish()
            }

            R.id.btnGuardarRegistro -> {
                val email = binding.etRegEmail.text.toString()
                val pass = binding.etRegPassword.text.toString()
                val repitePass = binding.etRegRepeatPassword.text.toString()

                if (email.isNotEmpty() && pass.isNotEmpty() && pass == repitePass) {
                    val preferencias = getSharedPreferences("mis_datos", Context.MODE_PRIVATE)
                    val editor = preferencias.edit()
                    editor.putString("email_guardado", email)
                    editor.putString("clave_guardada", pass)
                    editor.apply()
                    finish()
                } else {
                    binding.tvEstadoRegistro.text = "Revisa los datos o las contraseñas no coinciden"
                }
            }
        }
    }
}