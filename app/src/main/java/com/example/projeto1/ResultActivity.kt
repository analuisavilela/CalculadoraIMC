package com.example.projeto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvImc = findViewById<TextView>(R.id.textview_imc)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)


        val imc = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvImc.text = imc.toString()


        var classificacao = ""

        if (imc<18.5f){
            classificacao = "Abaixo do peso normal"
        }else if(imc>=18.5f && imc<=24.9f){
            classificacao = "Peso Normal"
        }else if(imc>=25.0f && imc<=29.9f){
            classificacao = "Excesso de Peso"
        }else if(imc>=30.0f && imc<=34.9f){
            classificacao = "Obesidade Classe I"
        }else if(imc>=35.0f && imc<=39.9f){
            classificacao = "Obesidade Classe II"
        }else if(imc>=40.0f){
            classificacao = "Obesidade Classe III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}