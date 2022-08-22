package com.galia.evilfriend.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.galia.evilfriend.data.model.LevelAndPrompt
import com.galia.evilfriend.databinding.FragmentPromptItemBinding

class PromptRecyclerViewAdapter(
    private val prompts: List<LevelAndPrompt>
) : RecyclerView.Adapter<PromptRecyclerViewAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val binding: FragmentPromptItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val textView: TextView = binding.textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = FragmentPromptItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = prompts[position]
        holder.textView.text = item.prompt.title
    }

    override fun getItemCount() = prompts.size

}