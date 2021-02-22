package com.example.hackdroid_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tabela_masc.*

class TabelaMascActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabela_masc)

        btnVoltar2.setOnClickListener {

            startActivity(Intent(this@TabelaMascActivity,MainActivity::class.java))
        }

    }
}
