package com.example.skillzone

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.skillzone.databinding.ActivityTorneosBinding

class TorneosActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityTorneosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTorneosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // escucha los clicks de los botones de arriba
        binding.btnMenu.setOnClickListener(this)
        binding.btnPerfil.setOnClickListener(this)

        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
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
                R.id.nav_torneos -> true
                else -> false
            }
        }

        binding.navView.setNavigationItemSelectedListener { item ->
            binding.drawerLayoutTorneos.closeDrawer(GravityCompat.START)
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
                binding.drawerLayoutTorneos.openDrawer(GravityCompat.START)
            }
            R.id.btnPerfil -> {
                // va a la pantalla perfil
                startActivity(Intent(this, PerfilActivity::class.java))
            }
        }
    }
}