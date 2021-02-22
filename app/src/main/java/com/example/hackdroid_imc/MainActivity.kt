package com.example.hackdroid_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var seekPeso: SeekBar
    lateinit var textPeso: TextView
    lateinit var seekAltura: SeekBar
    lateinit var textAltura: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekPeso = findViewById(R.id.skbPeso) as SeekBar
        textPeso = findViewById(R.id.txvPeso) as TextView

        seekPeso.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textPeso.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekAltura = findViewById(R.id.skbAltura) as SeekBar
        textAltura = findViewById(R.id.txvAltura) as TextView

        seekAltura.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textAltura.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })


        //criando uma lista para o spinner

        val listaSexo = arrayListOf("Selecione o sexo:", "Feminino", "Masculino")

        //criando o adapter
        val adapterSexo = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )

        spnSexo.adapter = adapterSexo

        //funções do botão tabela

        btnTabela.setOnClickListener {

            if (spnSexo.selectedItem == "Selecione o sexo:") {

                Toast.makeText(this@MainActivity, "Por favor, selecione o sexo!", Toast.LENGTH_LONG)
                    .show()

            } else if (spnSexo.selectedItem == "Feminino") {

                startActivity(Intent(this@MainActivity, TabelaFemActivity::class.java))

            } else (
                    startActivity((Intent(this@MainActivity, TabelaMascActivity::class.java)))
                    )
        }

        //função do botão definição

        btnDefinicao.setOnClickListener {

            startActivity(Intent(this@MainActivity, DefinicaoActivity::class.java))
        }
        //função do botão calcular

        btnCalcular.setOnClickListener {

            var peso = txvPeso.text.toString()
            var altura = txvAltura.text.toString()
            var peso2 = peso.toDouble()
            var altura2 = altura.toDouble()




            if (peso == "0" || altura == "0") {
                Toast.makeText(this@MainActivity, "Alguma coisa deu errado", Toast.LENGTH_LONG)
                    .show()
            } else {
                var imc = peso2 / (altura2 * altura2)
                var imc2 = imc * 10000


                if (peso2 < 1 || altura2 < 1 || spnSexo.selectedItem == "Selecione o sexo:") {
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor, coloque os dados corretos ",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }


                if (imc2 < 19 && spnSexo.selectedItem == "Feminino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PERIGO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, você está muito abaixo do peso.
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 >= 19 && imc2 < 24 && spnSexo.selectedItem == "Feminino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PARABÉNS!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Parabéns! Você está na sua faixa de peso ideal!.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 >= 24 && imc2 < 29 && spnSexo.selectedItem == "Feminino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("CUIDADO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, sua faixa de peso representa obesidade leve.
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }


                if (imc2 >= 29 && imc2 < 39 && spnSexo.selectedItem == "Feminino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("CUIDADO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, sua faixa de peso representa obesidade moderada.
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 >= 39 && spnSexo.selectedItem == "Feminino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PERIGOOOO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, sua faixa de peso representa obesidade mórbida
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 < 20 && spnSexo.selectedItem == "Masculino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PERIGO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, você está muito abaixo do peso.
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 > 20 && imc2 < 25 && spnSexo.selectedItem == "Masculino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PARABÉNS!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Parabéns! Você está na sua faixa de peso ideal!
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 >= 25 && imc2 < 30 && spnSexo.selectedItem == "Masculino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Cuidado!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, sua faixa de peso representa obesidade leve.
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 >= 30 && imc2 < 40 && spnSexo.selectedItem == "Masculino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PERIGO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, sua faixa de peso representa obesidade moderada.
Procure orientação médica..
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }

                if (imc2 > 40 && spnSexo.selectedItem == "Masculino") {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("PERIGO!!!")
                        .setMessage(
                            """Seu IMC é de ${imc2.toInt()}
                            |
Fique alerta, sua faixa de peso representa obesidade mórbida
Procure orientação médica.
                        """.trimMargin()
                        )
                        .setPositiveButton("ok") { _, _ ->
                        }
                        .create()
                        .show()
                }
            }

            btnTabela.setOnClickListener {
                if (spnSexo.selectedItem == "Masculino") {
                    startActivity(Intent(this@MainActivity, TabelaMascActivity::class.java))
                } else if (spnSexo.selectedItem == "Feminino") {
                    startActivity(Intent(this@MainActivity, TabelaFemActivity::class.java))
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Por favor, selecione um sexo para mostrar a tabela correta.",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }


        }
    }
}
