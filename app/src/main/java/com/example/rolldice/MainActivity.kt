package com.example.rolldice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // conectando la variable con el ID del botton
        var btnLanzar: Button = findViewById(R.id.ibtnLanzar)

        //configurando el boton
        btnLanzar.setOnClickListener{

            tiempo()


        }

        rollDice()
    }
    //configurando la funcion de rol
    private fun rollDice(){
        var numero: Int = lanzar(6)
        // variable que encuentra en texto
        val txtResult: TextView = findViewById(R.id.ibNumro)
        txtResult.text = numero.toString()
        //el mensaje y el tiempo que durara cuando se precione el boton
        //Toast.makeText(this, numero.toString(), Toast.LENGTH_SHORT).show()


        // creamos una variable y con un when le damos vista a cada numero
        val drawableResorce = when(numero){
            1 -> R.drawable.dado1
            2 -> R.drawable.dado2
            3 -> R.drawable.dado3
            4 -> R.drawable.dado4
            5 -> R.drawable.dado5
            else  -> R.drawable.dado6
        }

        // en otra variable donde le decimos que es de tipo ImageView y le damos la ID
        val imgDado: ImageView = findViewById(R.id.imageView)
        //luego unimos las variables drawableResorce y imaDado para que el dado cambie cada vez que se le da click
        imgDado.setImageResource(drawableResorce)


    }
    //generando el numero alatorio
    private fun lanzar(max: Int): Int{
        return (1..max). random()

    }

    //creamos una funcion para darle tiempo a la animacion de las imagenes
    private fun tiempo(){
        object: CountDownTimer(1000, 150){
            override fun onTick(p0: Long) {
                rollDice()
            }

            override fun onFinish() {

            }

        }.start()

    }
}