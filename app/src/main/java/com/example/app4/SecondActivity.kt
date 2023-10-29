package com.example.app4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val animalImage = findViewById<ImageView>(R.id.animalImage)
        val animalName = findViewById<TextView>(R.id.animalName)
        val animalDescription = findViewById<TextView>(R.id.animalDescription)

        val animal = intent.getParcelableExtra<AnimalModel>("animal")

        animalImage.setImageResource(animal?.imageResource ?: R.drawable.lion)
        animalName.text = animal?.name ?: "Animal Name"
        animalDescription.text = animal?.description ?: "Animal Description"
    }
}
