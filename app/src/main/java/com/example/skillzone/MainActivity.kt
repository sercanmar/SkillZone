package com.example.skillzone

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.skillzone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. ESCUCHAMOS LAS TARJETAS Y BOTONES DE ARRIBA
        binding.btnMenu.setOnClickListener(this)
        binding.btnPerfil.setOnClickListener(this)
        binding.cardTorneos.setOnClickListener(this)
        binding.cardSalas.setOnClickListener(this)

        // 2. LÓGICA DEL MENÚ DE ABAJO (EL NAV)
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true // Ya estamos en inicio

                R.id.nav_salas -> {
                    // Viaje a las salas desde el nav
                    startActivity(Intent(this@MainActivity, SalasActivity::class.java))
                    true
                }

                R.id.nav_torneos -> {
                    // Viaje a los torneos desde el nav
                    startActivity(Intent(this@MainActivity, TorneosActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // 3. LÓGICA DEL MENÚ LATERAL (AJUSTES Y SALIR)
        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayout.closeDrawer(GravityCompat.START)

            when (item.itemId) {
                R.id.menu_ajustes -> {
                    startActivity(Intent(this@MainActivity, AjustesActivity::class.java))
                }
                R.id.menu_salir -> {
                    startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                    finish() // Cerramos la app al salir
                }
            }
            true
        }
    }

    // 4. LÓGICA DE LAS TARJETAS GIGANTES
    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnMenu -> {
                // Abre el menú lateral
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
            R.id.btnPerfil -> {
               startActivity(Intent(this, PerfilActivity::class.java))
            }
            R.id.cardTorneos -> {
                // Viaja a torneos al tocar la foto
                startActivity(Intent(this, TorneosActivity::class.java))
            }
            R.id.cardSalas -> {
                // Viaja a salas al tocar la foto
                startActivity(Intent(this, SalasActivity::class.java))
            }
        }
    }
}