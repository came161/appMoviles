package medina.proyects.photoproject.ui.pantalla

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import medina.proyects.photoproject.data.RepositorioServicio
import medina.proyects.photoproject.data.Servicio

@Composable
fun PantallaGaleria(navController: NavController) {
    //LazyColumn que ocupe todo con margen de 8
    //con cada elemnto de la lista meterlo en un Card
    LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        //Empezamos a meter los elementos sacándolos de la lista
        items(RepositorioServicio.listaServicio.size) { index: Int ->
            val servicio = RepositorioServicio.listaServicio[index]
            Card(modifier = Modifier.padding(8.dp).fillMaxWidth().clickable {}) {
                Row(modifier = Modifier.padding(8.dp)) {
                    //Dentro de la imagen añadimos descripcion
                    Image(
                        painter = painterResource(id = servicio.imagen),
                        servicio.nombre,
                        modifier = Modifier.size(80.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(servicio.nombre, style = MaterialTheme.typography.titleLarge)
                        //Descripcion solo queremos que se visualice las 2 primeras lineas
                        Text(servicio.descripcion, maxLines = 2)
                    }

                }
                //Items
                //Boton tiene que estar dentro de un item


            }
        }
        item {
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {navController.popBackStack()},
                Modifier.fillMaxSize().padding()) {
                Text("Volver al inicio")
            }
        }
    }
}

