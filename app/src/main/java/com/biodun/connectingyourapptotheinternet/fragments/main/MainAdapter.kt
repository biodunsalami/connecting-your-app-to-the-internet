package com.biodun.connectingyourapptotheinternet.fragments.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.biodun.connectingyourapptotheinternet.api.Character
import com.biodun.connectingyourapptotheinternet.databinding.CharacterRecyclerItemBinding

class MainAdapter (private val characters : List<Character>) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    inner class MainViewHolder (private val binding: CharacterRecyclerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(character:Character){
            binding.nameTv.text = character.characterName
            binding.imageIv.load(character.characterImage) //load method is from coil library
            binding.specieValueTv.text = character.characterSpecie
            binding.statusValueTv.text = character.characterStatus
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CharacterRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(characters[position])
    }


}