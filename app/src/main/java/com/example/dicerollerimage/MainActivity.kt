package com.example.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice()}

        val rollEditText: EditText = findViewById(R.id.edtNumber)
        rollEditText.setOnClickListener{rollDice()}

    }

    private fun rollDice ()
    {
        val number = (1..6).random()
        val edit: EditText = findViewById(R.id.edtNumber)


        //val resultText: textView = findViewById(R.id.resultText)
        //resultText.text = number.toString()

        //Toast.makeText(this, resultText.text, Toast.LENGTH_SHORT).show()
        val diceImage: ImageView = findViewById(R.id.dice_image)


        val drawableResourse = when (number)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
                else -> R.drawable.empty_dice
        }
        diceImage.setImageResource(drawableResourse)

        if (edit.length() !=0)
        {
            if (number == Integer.parseInt(edit.text.toString()))
            {
                Toast.makeText(this, "You Win!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this,"You Loser!", Toast.LENGTH_SHORT).show()
            }
        }
        else
        {
            Toast.makeText(this,"Try Again!", Toast.LENGTH_SHORT).show()
        }
    }
}