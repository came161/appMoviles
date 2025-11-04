package medina.proyects.cuadrado

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import model.Cuadrado
import model.CuadradoBordes
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //identificacion del cuadrado vista
        val cuadradoView : View = findViewById(R.id.cuadrado)
        //usamos el metodo post para que se ejecute este bloque de codigo en el hilo de la interfaz de usuario justo después de
        // que se ejecute la vista


        cuadradoView.post {
            //variables que recogen los datos de la vista inicial
            val inicialAncho = cuadradoView.width
            val inicialAlto = cuadradoView.height
            val inicialX: Int = cuadradoView.x.toInt()
            val inicialY: Int = cuadradoView.y.toInt()
            //asociar a la vista con el objeto cuadrado
            //ContextCompat es una clase para acceder a recursos
            /*val cuadrado : Cuadrado = Cuadrado(ContextCompat.getColor(this, R.color.red), inicialAncho, inicialAlto).apply {
            //damos los valores de X e Y de la vista
            x = inicialX
            y = inicialY
        } */


            val cuadrado: CuadradoBordes = CuadradoBordes(
                ContextCompat.getColor(this, R.color.red),
                inicialAncho, inicialAlto,
                ContextCompat.getColor(this, R.color.black)
            ).apply {
                //damos los valores de X e Y de la vista
                x = inicialX
                y = inicialY
            }


            //identifiacacion de botones

            val botonArriba: Button = findViewById<Button>(R.id.buttonArriba)
            val botonAbajo: Button = findViewById<Button>(R.id.buttonAbajo)
            val botonIzquierda: Button = findViewById<Button>(R.id.buttonIzquierda)
            val botonDerecha: Button = findViewById<Button>(R.id.buttonDerecha)
            val botonCambiarColor: Button = findViewById<Button>(R.id.buttonCambiarColor)
            val botonAumentarTamanio: Button = findViewById<Button>(R.id.aumentarTamaño)
            val botonDismuniurTamanio: Button = findViewById<Button>(R.id.disminuirTamanio)
            val botonCambiarBordeColor: Button = findViewById<Button>(R.id.cambiarColorBorde)
            val botonCuatroColor : Button = findViewById<Button>(R.id.cuatroColor)


            botonCuatroColor.setOnClickListener {
                //llamamos a la funcion de la clase nested
                cuadrado.cambiarColorBorde(CuadradoBordes.ManejoColor.obtenerCuatroColoresRandom())
                actualizarVista(cuadrado, cuadradoView)

            }
            botonCambiarBordeColor.setOnClickListener {
                cuadrado.cambiarColorBorde(generarColorAleatiorio())
                actualizarVista(cuadrado, cuadradoView)
            }
            //ponemos botones a la escucha
            botonArriba.setOnClickListener {
                cuadrado.moverArriba()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonAbajo.setOnClickListener {
                cuadrado.moverAbajo()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonDerecha.setOnClickListener {
                cuadrado.moverDerecha()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonIzquierda.setOnClickListener {
                cuadrado.moverIzquierda()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonAumentarTamanio.setOnClickListener {
                cuadrado.aumentarTamanio()
                actualizarVista(cuadrado, cuadradoView)
            }
            botonDismuniurTamanio.setOnClickListener {
                cuadrado.disminuirTamanio()
                actualizarVista(cuadrado, cuadradoView)

            }
            botonCambiarColor.setOnClickListener {
                cuadrado.color = ContextCompat.getColor(this, R.color.blue)
                cuadrado.color = generarColorAleatiorio()
                actualizarVista(cuadrado, cuadradoView)

            }
        }

        }// post
    }
    private fun actualizarVista(cuadrado : CuadradoBordes, cuadradoView: View){
        //aqui es donde enlazamos la vista con el objeto
        //la vista actualizará su ancho y alto con los datos del objeto
        cuadradoView.layoutParams.width = cuadrado.ancho
        cuadradoView.layoutParams.height = cuadrado.alto
        //Cambiamos color
        cuadradoView.setBackgroundColor(cuadrado.color)
        //actualizar cordenadas
        cuadradoView.x = cuadrado.x.toFloat()
        cuadradoView.y= cuadrado.y.toFloat()
        //ejecutar los cambios

        val drawable : GradientDrawable = GradientDrawable()
        drawable.setColor(cuadrado.color)
        drawable.setStroke(10,cuadrado.bordeColor)
        cuadradoView.background  =drawable
        cuadradoView.requestLayout()
        cuadradoView.requestLayout()


    }
    private fun generarColorAleatiorio() : Int{
        //creamos un Random.Default que garantiza mas compatibilidad
        //generar 3 numeros aleatorios R G B entre 0 y 255 incluidos
        // creamos una variable random
        val random = Random.Default
        val rojo = random.nextInt(256)
        val verde = random.nextInt(256)
        val azul = random.nextInt(256)
            //Color es la clase para almacenar colores y el metodo rgb() saca el codigo numerico
            return Color.rgb(rojo, verde, azul)
        //generar 3 numeros aleatorios
    }
