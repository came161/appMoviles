package medina.proyects.photoproject.data
import  medina.proyects.photoproject.R
import medina.proyects.photoproject.data.RepositorioServicio.listaServicio

data class Servicio (val id: Int, val nombre: String, val imagen: Int, val descripcion : String)
 object RepositorioServicio {
     val listaServicio = listOf(
         Servicio(1, "Servicio1", R.drawable.google, "Descripcion servicio 1"),
         Servicio(2, "Servicio2", R.drawable.google, "Descripcion servicio 2")
     )
     //funcion que devuelva la casa por id, si no encuentra que devuelva null
     fun getServicioById(id :Int): Servicio? {
         return listaServicio.find { it.id ==id }

     }
 }





