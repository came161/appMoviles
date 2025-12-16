package medina.proyects.photoproject.ui.pantalla

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import medina.proyects.photoproject.data.RepositorioServicio

@Composable
fun PantallaDetalleCasa(navController: NavController, id : Int){
    //Crear una variable Casa donde almacenar el objeto casa que
    //Se tiene que cargar segun sea el id que recibamos
    //La casa está en el fichero de datos en un objeto Casa en el objeto RepositorioServicio
    //Para evitar errores de id no validos, se pone que no devuelva nada
    val casa = RepositorioServicio.getServicioById(id)?:return
    Spacer(modifier = Modifier.height(8.dp))
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick =  {navController.popBackStack() },
            modifier = Modifier.align(Alignment.Start)){
            Text(text = "Volver")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(casa.nombre,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(12.dp))
        Box(modifier = Modifier.fillMaxSize().height(300.dp)
            , contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = casa.imagen), contentDescription = casa.nombre)
        }
        Spacer(modifier = Modifier.height(24.dp))

    }

}