package medina.proyects.mayoredad

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import medina.proyects.mayoredad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val num: EditText = findViewById<EditText>(R.id.editTextText2)
        val boton: Button = findViewById<Button>(R.id.button)
        val texto: TextView = findViewById<TextView>(R.id.textView)
        val botonRestar : Button = findViewById<Button>(R.id.botonRestar)
        val botonSumar : Button = findViewById<Button>(R.id.botonSumar)
        val botonFactorial : Button = findViewById<Button>(R.id.botonFactorial)

        botonFactorial.setOnClickListener {
            var numeroFactorial = num.text.toString().toInt()

            var resultado : Int =1
            while(numeroFactorial>1){
                resultado = resultado*numeroFactorial
                numeroFactorial--
            }
            texto.setText(resultado.toString())
        }
        fun actualizarMensaje(edad : Int?, textoResultado : TextView){
            val mensaje = when{
                edad == null -> "Introduzca un valor"
                edad < 18 -> "Eres menor de edad"
                edad > 18 -> "Eres mayor de edad"
                else -> "Tienes justo 18 años"
            }
            textoResultado.text = mensaje
        }
        boton.setOnClickListener {
            //recoger el valor del campo del texto, pasarlo a entero o null
            //poner un if, pero hau que distinguir si es nulo o no
            val numeroResultado = num.text.toString().toIntOrNull()
           actualizarMensaje(numeroResultado, texto)

        }
            botonSumar.setOnClickListener {
                var numeroSeleccionado = num.text.toString().toInt()
                numeroSeleccionado++
                num.setText(numeroSeleccionado.toString())
                actualizarMensaje(numeroSeleccionado, texto)
            }
            botonRestar.setOnClickListener {
                var numeroSeleccionado= num.text.toString().toInt()
                numeroSeleccionado--
                num.setText(numeroSeleccionado.toString())
                actualizarMensaje(numeroSeleccionado, texto)
            }


    }

}

