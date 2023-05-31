package com.example.barbershop

import android.content.Intent
import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.barbershop.databinding.ActivityHomeBinding
import com.example.barbershop.databinding.ActivityMainBinding
import com.example.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {

            val nome = binding.editNome.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                nome.isEmpty() -> {
                    mensagem(it, "Coloque o seu nome!")
                }
                senha.isEmpty() -> {
                    mensagem(it, "Preencha sua senha!")
                }
                senha.length <= 5 -> {
                    mensagem(it, "A senha precisa ter no mínimo 6 caractéres")
                }else -> {
                    navegarPraHome(nome)
                }
            }
        }
    }

    private fun mensagem(view: View, mensagem: String) {

        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navegarPraHome(nome: String) {
        val intent = Intent(this,Home::class.java)
        intent.putExtra("nome",nome)
        startActivity(intent)
    }

}