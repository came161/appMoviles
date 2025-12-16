package medina.proyects.foto

import androidx.compose.ui.graphics.Color
import android.media.Image
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import medina.proyects.foto.ui.theme.FotoTheme
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FotoTheme {
                MiFoto()

            }
        }
    }
}

@Composable
fun MiFoto(){
    //declaramos una variable observable para almacenar el color de fondo
    //val colorFondo = remember {mutableStateOf(Color.White)}
    var colorFondo by remember { mutableStateOf(Color.White) }
    var textoPosicion by remember { mutableStateOf(Offset(0f,0f))}
    //calculamos el ancho y el alto de la pantalla
    var anchoPantalla by remember { mutableStateOf(0f) }
    var altoPantalla by remember { mutableStateOf(0f) }
    //calculamos el alto y el ancho del texto
    var anchoTexto by remember { mutableStateOf(0f) }
    var altoTexto by remember { mutableStateOf(0f) }


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(colorFondo)
        .onGloballyPositioned{ coordinates ->
            altoPantalla = coordinates.size.height.toFloat()
            anchoPantalla = coordinates.size.width.toFloat()

        })

    {
      /*  Image(
            painter = painterResource(id = R.drawable.minovio),
            contentDescription = "Imagen de mi novio",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()

                ) */
        imagenInteractive()
        Text(
            text = "Mi novio uwu",
            fontStyle = FontStyle.Italic,
            textDecoration = TextDecoration.Underline,
            color = Color.Magenta,
            fontSize = 50.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            //modifier = Modifier.align(Alignment.Center)
            modifier = Modifier
                .onGloballyPositioned{ coordinates ->
                    anchoTexto = coordinates.size.width.toFloat()
                    altoTexto = coordinates.size.height.toFloat()
                    if(textoPosicion ==Offset(0f,0f)){
                        textoPosicion = Offset((anchoPantalla-anchoTexto)/2, (altoPantalla-altoTexto)/2)
                    }

                }
                .offset{
                    IntOffset(textoPosicion.x.toInt(), textoPosicion.y.toInt())
                }
                .pointerInput(Unit){
                    detectDragGestures {
                        change, dragAmount ->
                        change.consume() //evita que se activen otros eventos al pasar por encima de otros obj
                        textoPosicion = Offset (
                                textoPosicion.x + dragAmount.x,
                                textoPosicion.y + dragAmount.y
                                )
                    }
                }
        )
        Button(
            onClick = {
                colorFondo = colorAleatorio()
            } ,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Text(text = "Cambiar fondo",)
        }
    }
}
@Composable
fun imagenInteractive(){
    //necesitamos almacenar y observar la escala de la imagen
    var escala by remember { mutableStateOf(1f) }
    //neceistamos la posicion de la imagen
    var posicion by remember { mutableStateOf(Offset.Zero) }
    var rotacion by remember { mutableStateOf(0f) }
    Box(modifier = Modifier
        .pointerInput(Unit){
            detectTransformGestures { _, desplazamiento, zoom, rotation ->
                posicion += desplazamiento //aplicamos el desplazamiento
                //aplicamos el zoom a la escala
                escala *= zoom
                rotacion +=rotation
                }
            },
            contentAlignment = Alignment.Center)
    { Image(
            painter = painterResource(id = R.drawable.minovio),
            contentDescription = "Mi novio",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    translationX = posicion.x,
                    translationY = posicion.y,
                    scaleX = escala.coerceIn(0.5f, 3.5f),
                    scaleY = escala.coerceIn(0.5f, 3.5f),



                )

        )
    }





/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FotoTheme {
        Greeting("Android")
    }
}
*/

    }
fun colorAleatorio() : Color{
    var rojo = kotlin.random.Random.nextFloat()
    val rojoNuevo = (0..255).random().toFloat()
    var verde = kotlin.random.Random.nextFloat()
    val verdeNuevo = (0..255).random().toFloat()
    var azul = kotlin.random.Random.nextFloat()
    val azulNuevo = (0..255).random().toFloat()
    return Color(rojo, verde, azul)
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview1() {
    MiFoto()
    imagenInteractive()
}