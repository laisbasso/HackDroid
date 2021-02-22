package com.example.hackdroid_imc

import android.content.Intent
import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_definicao.*

class DefinicaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_definicao)

        btnVoltar4.setOnClickListener {

            startActivity(Intent(this@DefinicaoActivity,MainActivity::class.java))
        }

    }
}
