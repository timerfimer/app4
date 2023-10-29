package com.example.app4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.animalRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val animalList = listOf(
            AnimalModel("Lion", "Lion is a large carnivorous cat.", R.drawable.lion),
            AnimalModel("Giraffe", "Large African hoofed mammal belonging to the genus Giraffa", R.drawable.giraffe),
            AnimalModel("Coala", "Koalas are herbivorous, and while most of their diet consists of eucalypt leaves", R.drawable.coala)
        )

        val adapter = AnimalAdapter(animalList) { animal ->
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("animal", animal)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}