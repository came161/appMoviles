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
        boton.setOnClickListener {
            //recoger el valor del campo del texto, pasarlo a entero o null
            //poner un if, pero hau que distinguir si es nulo o no
            val numeroResultado = num.text.toString().toIntOrNull()
            if (numeroResultado == null) {
                texto.text = "Introduzca un valor"
            } else if (numeroResultado != null) {
                if(numeroResultado<18){
                texto.text = "Eres menor de edad"
            } else if (numeroResultado > 18)
                texto.text = "Eres mayor de edad"
            else {
                texto.text = "Tienes justo 18 años!!"
            }
        }

    }

        }
    }
