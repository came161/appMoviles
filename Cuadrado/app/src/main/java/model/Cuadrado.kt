package model

open class Cuadrado (var color: Int, var ancho: Int, var alto : Int ) {
    // Coordenadas iniciales
    var x : Int = 0
    var y : Int = 0

    //métodos para mover-cambiar el cuadrado
    fun moverArriba(){
        y-= 10 //y = y - 10

    }
    fun moverAbajo(){
        y+=10; //
    }
    fun moverDerecha(){
        x+=10;
    }
    fun moverIzquierda(){
        x-=10;
    }

    fun aumentarTamanio() {
        alto = alto+10
        ancho = ancho+10
    }
    fun disminuirTamanio(){
        alto = alto-10
        ancho = ancho-10
    }




}