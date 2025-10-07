package medina.proyects.aleatorio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            val numeroIntroducido : EditText = findViewById<EditText>(R.id.entradaValor)
            val miBoton : Button = findViewById<Button>(R.id.miBoton)
            val mensajeSalida : TextView = findViewById<TextView>(R.id.salidaValor)
        var contador= 0
            var aleatorio = Random.nextInt(1,101)
            miBoton.setOnClickListener {
                contador++
                val valorIntroducido = numeroIntroducido.text.toString().toIntOrNull()
                    if (valorIntroducido == null) mensajeSalida.text = "Debe introducir un valor"
                    else if (aleatorio < valorIntroducido) mensajeSalida.text = "Más bajo"
                    else if (aleatorio > valorIntroducido) mensajeSalida.text = "Más alto"
                else mensajeSalida.text = "Número correcto lo adivinaste en " +contador+" intentos"



            }

            }

        }


