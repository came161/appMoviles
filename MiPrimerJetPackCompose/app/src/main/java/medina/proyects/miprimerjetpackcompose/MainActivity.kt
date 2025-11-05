package medina.proyects.miprimerjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //MiPrimeraComposable()
            MiSegundaComposable()
        }
    }
}

@Composable
fun MiPrimeraComposable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp)
    ) {
        Row {
            Text(text = "Primera fila")
            Spacer(modifier = Modifier.width(35.dp))
            Text(text = "Segunda fila")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Esta es mi primera función")
        Text(text = "Aquí escribimos la segunda línea")
    }
}

@Composable
fun MiSegundaComposable() {
    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
            Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
            Text(text = "TopCenter", modifier = Modifier.align(Alignment.Center))
            Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
            Text(text = "CenterStart", modifier = Modifier.align(Alignment.CenterStart))
            Text(text = "BottomStart", modifier = Modifier.align(Alignment.BottomStart))
            Text(text = "TopCenter", modifier = Modifier.align(Alignment.TopCenter))
            Text(text = "BottomCenter", modifier = Modifier.align(Alignment.BottomCenter))
            Text(text = "TopEnd", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "CenterEnd", modifier = Modifier.align(Alignment.CenterEnd))


    }
    }


@Preview(showBackground = true, name = "Segunda")
@Composable
fun MiSegundaComposablePreview() {
    MiSegundaComposable()
}
/*
@Preview(showBackground = true, name = "Primera")
@Composable
fun MiPrimeraComposablePreview() {
    MiPrimeraComposable()
}
*/