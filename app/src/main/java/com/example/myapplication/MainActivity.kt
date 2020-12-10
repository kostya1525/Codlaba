package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

import android.widget.Toast


class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var diceImage1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage1 = findViewById(R.id.dice_image1)

        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener { rollDice() }

        val undoButton: Button = findViewById(R.id.button2)
        undoButton.setOnClickListener{ reset() }
    }

    private fun rollDice() {
        diceImage.setImageResource(getRandomInt())
        diceImage1.setImageResource(getRandomInt())
        Toast.makeText(this, "Dice rolled!",
            Toast.LENGTH_SHORT).show()
    }

    private fun reset(){
        diceImage.setImageResource(undoImageView())
        diceImage1.setImageResource(undoImageView())
    }

    private fun getRandomInt() : Int {

        return when((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

    }
    private fun undoImageView() : Int {

        return R.drawable.empty_dice

    }

}

