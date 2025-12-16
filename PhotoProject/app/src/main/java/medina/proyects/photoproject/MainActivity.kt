package medina.proyects.photoproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import medina.proyects.photoproject.ui.pantalla.PantallaDetalleCasa
import medina.proyects.photoproject.ui.pantalla.PantallaGaleria
import medina.proyects.photoproject.ui.pantalla.PantallaInfo
import medina.proyects.photoproject.ui.pantalla.PantallaInicio
import medina.proyects.photoproject.ui.theme.PhotoProjectTheme



class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhotoProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()){
                    ServicioApp()
                }
            }
        }
    }

    @Composable
//Creamos un controlador para navegar
    fun ServicioApp(){
        val navController = rememberNavController()
        //creamos contenedor
        NavHost(navController = navController, startDestination = "inicio"){
            composable ( "inicio") {PantallaInicio(navController)}
            composable ( "info" ) { PantallaInfo(navController) }
            composable ("galeria") { PantallaGaleria(navController) }
            }

        }
    }

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhotoProjectTheme {
        ServicioApp()
    }
}

 */