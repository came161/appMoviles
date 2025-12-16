package medina.proyects.misegundocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import medina.proyects.misegundocompose.ui.theme.MiSegundoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiSegundoComposeTheme {
                Miboton()
                }
            }
        }
    }



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun MiFuncion1(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Greeting("Cynthia",
            modifier = Modifier.background(Color.Yellow)
        )
        Greeting("Aitor" ,
            modifier = Modifier.align(Alignment.BottomEnd).background(Color.Red))
    }

}
@Composable
fun Mifuncion2(){
    Column(modifier =
        Modifier.fillMaxWidth()
            .height(250.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
    Greeting("Cynthia",
        modifier = Modifier
            .background(Color.Yellow).weight(2f))
        Greeting("San Juan de la Cruz",
            modifier = Modifier
                .background(Color.Red).weight(1f))
    }


}
@Composable
fun Mifuncion3() {
    Row(modifier = Modifier.fillMaxWidth()
        .height(200.dp),
        verticalAlignment = Alignment.CenterVertically  ,
        horizontalArrangement = Arrangement.SpaceAround
        )
    {
        Greeting(
            "Cynthia", Modifier.background(Color.Yellow)
        )
        Greeting("Android", Modifier.background(Color.Magenta))

    }
}
@Composable
fun Miboton(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Pulsa aquí", modifier = Modifier
            .clickable{
                //falta lo que hace
            }
            .background(Color.Green)
            .border(width = 2.dp, color = Color.Magenta)
            .padding(horizontal = 20.dp , vertical = 10.dp)

            )



    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting("Cynthia")

    }
/*
@Preview(showBackground = true, name= "Cynthia")
@Composable
fun GreetingPrewiew1(){
    MiSegundoComposeTheme {
        MiFuncion1()
    }
} */
/*
@Preview(showBackground = true, name= "Cynthia")
@Composable
fun GreetingPrewiew2(){
    MiSegundoComposeTheme {
        Mifuncion2()
    }
} */
/*
@Preview(showBackground = true, name= "Boton", widthDp = 200, heightDp = 100)
@Composable
fun GreetingPrewiew3() {
    MiSegundoComposeTheme {
        Miboton()
    }
} */
@Preview(showBackground = true, name= "Boton", widthDp = 500, heightDp = 500)
@Composable
fun Textos() {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = stringResource (id = R.string.lore),
            color = Color.Magenta,
            fontSize = 25.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Italic,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Right,
            lineHeight = 2.em,
            maxLines = 2


        )

        //color = Color(255,0,0)
        //color = colorResource(id = R.color.black)

    }
}

