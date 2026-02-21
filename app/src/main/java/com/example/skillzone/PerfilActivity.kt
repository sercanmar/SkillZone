package com.example.skillzone

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.skillzone.databinding.ActivityPerfilBinding

class PerfilActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenu.setOnClickListener(this)

        binding.layoutInscripciones.visibility = View.GONE
        binding.layoutHistorial.visibility = View.GONE

        binding.btnToggleInscripciones.setOnClickListener(this)
        binding.btnToggleHistorial.setOnClickListener(this)

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // limpio el historial y voy a inicio
                    val intento = Intent(this, MainActivity::class.java)
                    intento.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intento)
                    finish()
                    true
                }
                R.id.nav_salas -> {
                    startActivity(Intent(this, SalasActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_torneos -> {
                    startActivity(Intent(this, TorneosActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayoutPerfil.closeDrawer(GravityCompat.START)
            when (item.itemId) {
                R.id.menu_ajustes -> {
                    startActivity(Intent(this, AjustesActivity::class.java))
                }
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
                binding.drawerLayoutPerfil.openDrawer(GravityCompat.START)
            }
            R.id.btnToggleInscripciones -> {
                // si toco inscripciones muestro ese y oculto el otro
                if (binding.layoutInscripciones.visibility == View.GONE) {
                    binding.layoutInscripciones.visibility = View.VISIBLE
                    binding.layoutHistorial.visibility = View.GONE
                } else {
                    binding.layoutInscripciones.visibility = View.GONE
                }
            }
            R.id.btnToggleHistorial -> {
                // si toco historial muestro ese y oculto el otro
                if (binding.layoutHistorial.visibility == View.GONE) {
                    binding.layoutHistorial.visibility = View.VISIBLE
                    binding.layoutInscripciones.visibility = View.GONE
                } else {
                    binding.layoutHistorial.visibility = View.GONE
                }
            }
        }
    }
}