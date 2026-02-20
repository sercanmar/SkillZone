package com.example.skillzone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.skillzone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // abre el menu lateral al tocar el icono de arriba
        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        // clics de las fotos grandes
        binding.cardTorneos.setOnClickListener {
            Toast.makeText(this, "torneos pronto", Toast.LENGTH_SHORT).show()
        }

        binding.cardSalas.setOnClickListener {
            Toast.makeText(this, "cargando salas...", Toast.LENGTH_SHORT).show()
            // aqui pondremos el intent para ir a la pantalla de salas
        }

        // logica de los botones de abajo
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_salas -> {
                    Toast.makeText(this, "vas a salas", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_perfil -> {
                    Toast.makeText(this, "vas al perfil", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        // logica del menu lateral
        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_salir -> {
                    // vuelve al login al salir
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
}