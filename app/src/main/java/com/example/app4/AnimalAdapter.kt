package com.example.app4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalAdapter(private val animalList: List<AnimalModel>, private val onItemClick: (AnimalModel) -> Unit) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animalImage: ImageView = itemView.findViewById(R.id.animalImage)
        val animalName: TextView = itemView.findViewById(R.id.animalName)
        val animalDescription: TextView = itemView.findViewById(R.id.animalDescription)
        val viewDetailsButton: Button = itemView.findViewById(R.id.viewDetailsButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_animal, parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val currentItem = animalList[position]

        holder.animalImage.setImageResource(currentItem.imageResource)
        holder.animalName.text = currentItem.name
        holder.animalDescription.text = currentItem.description

        holder.viewDetailsButton.setOnClickListener {
            onItemClick(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return animalList.size
    }
}