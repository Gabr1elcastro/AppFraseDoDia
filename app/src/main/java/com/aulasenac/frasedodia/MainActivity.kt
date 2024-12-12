package com.aulasenac.frasedodia

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    var frasesDoDia = arrayOf(
        "Enfrente os problemas e leve a melhor!",
        "Dê mais atenção ao que você tem de bom na sua vida",
        "Preste atenção nas oportunidades que estão à sua frente!",)

    fun fraseAleatoria(view: View){
        val text_frase = findViewById<TextView>(R.id.text_frase)
        val frase_aleatoria = Random().nextInt(frasesDoDia.size)
        text_frase.setText(frasesDoDia[frase_aleatoria])
    }

    fun todasAsFrases(view: View){
        val text_frase = findViewById<TextView>(R.id.text_frase)
        val frases = StringBuilder()
        for(i in frasesDoDia.indices) {
            frases.append(frasesDoDia[i] + "\n \n")
        }
        val todas_frases = frases.toString()
        text_frase.setText(todas_frases)
    }

    fun captandoFrases(view: View) {
        val Input_RecebeFrases = findViewById<TextInputEditText>(R.id.Input_RecebeFrases)
        val lerInput = Input_RecebeFrases.getText()
        frasesDoDia += "$lerInput"
    }
}