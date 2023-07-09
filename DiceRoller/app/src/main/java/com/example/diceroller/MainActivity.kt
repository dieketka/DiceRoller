package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button) //определение кнопки
        rollButton.setOnClickListener {//функция нажатия кнопки
            rollDice() //функция выкидывания кубика после нажатия нопки
        }
    }

    private fun rollDice() { // создание кубика с 6 сторонами
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)  //определение картинки кубика
        val drawableResource = when (diceRoll) { //определение картинки в соостветстии с выкинутым числом
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)//появляется картинка в соответствии с выкинутым числом
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}