package model

import android.graphics.Color

class CuadradoBordes (color : Int, alto : Int , ancho : Int, var bordeColor : Int = Color.BLACK):
    Cuadrado(color,ancho,alto) {
    fun cambiarColorBorde(nuevoColorBorde: Int ){
        bordeColor = nuevoColorBorde;
    }
    class ManejoColor{
        //definir un objeto comun a toda la clase que son los colores
        companion object{
            val ROJO = Color.RED
            val AZUL = Color.BLUE
            val VERDE = Color.GREEN
            val NEGRO = Color.BLACK
            //definimos el metodo de cambiar color
            fun obtenerCuatroColoresRandom() : Int{
                //creamos una lista con los valores de companion object
                val colores = listOf(ROJO, AZUL, VERDE, NEGRO)
                return colores.random()
            }
        }

    }

}