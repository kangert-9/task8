package com.example.task3.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.task3.data.DataModel
import com.example.task3.databinding.ItemBinding

class TranslateAdapter: ListAdapter<DataModel, TranslateViewHolder>(TranslateDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslateViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return TranslateViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TranslateViewHolder, position: Int) =
        holder.bind(getItem(position))

}