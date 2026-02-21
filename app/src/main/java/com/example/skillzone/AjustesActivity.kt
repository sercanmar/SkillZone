package com.example.skillzone

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.skillzone.databinding.ActivityAjustesBinding

class AjustesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAjustesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAjustesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // escuchamos los botones de arriba
        binding.btnMenu.setOnClickListener(this)
        binding.btnPerfil.setOnClickListener(this)

        // opciones del spinner
        val opcionesIdioma = arrayOf("Español", "English", "Français", "Deutsch")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, opcionesIdioma)
        binding.spIdioma.adapter = adapter

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // viaja a inicio
                    val intento = Intent(this, MainActivity::class.java)
                    intento.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intento)
                    finish()
                    true
                }
                R.id.nav_salas -> {
                    // viaja a salas
                    startActivity(Intent(this, SalasActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_torneos -> {
                    // viaja a torneos
                    startActivity(Intent(this, TorneosActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        binding.navView.setNavigationItemSelectedListener { item ->
            // cierra el menu lateral
            binding.drawerLayoutAjustes.closeDrawer(GravityCompat.START)

            when (item.itemId) {
                R.id.menu_ajustes -> true
                R.id.menu_salir -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
            true
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnMenu -> {
                // abre el menu lateral
                binding.drawerLayoutAjustes.openDrawer(GravityCompat.START)
            }
            R.id.btnPerfil -> {
                // viaja al perfil
              startActivity(Intent(this, PerfilActivity::class.java))
            }
        }
    }
}