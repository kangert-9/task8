package com.example.task3.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.task3.data.DataModel
import com.example.task3.databinding.ItemBinding

class TranslateViewHolder(private val viewBinding: ItemBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(word: DataModel) {
        viewBinding.translateWord.text = word.meanings.toString()
    }
}