package com.galia.evilfriend.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.galia.evilfriend.R
import com.galia.evilfriend.data.model.PromptAndNotification
import com.galia.evilfriend.databinding.FragmentPromptItemBinding
import java.text.SimpleDateFormat
import java.util.*

class PromptRecyclerViewAdapter(
    private val prompts: List<PromptAndNotification>,
    private val itemClickHandler: (i: Int) -> Unit
) : RecyclerView.Adapter<PromptRecyclerViewAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val binding: FragmentPromptItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val item: ViewGroup = binding.promptItem
        val titleTextView: TextView = binding.titleTextView
        val dateTextView: TextView = binding.textView
        val levelView: View = binding.levelMarkView
        val notificationTimeTextView: TextView = binding.notificationTimeTextView
        val resource: Resources = binding.textView.resources
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = FragmentPromptItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = prompts[position]
        val date = item.prompt.createdAt
        val df = SimpleDateFormat("dd.MM.yy HH:mm", Locale.US)
        val localizedDate = df.format(date)

        holder.titleTextView.text = item.prompt.title
        holder.dateTextView.text = holder.resource.getString(R.string.prompt_date, localizedDate)
        holder.notificationTimeTextView.text = item.notification.getTime()
        holder.levelView.setBackgroundColor(holder.resource.getColor(R.color.secondaryDarkColor))
        holder.item.setOnClickListener {
            itemClickHandler(item.prompt.id)
        }

    }

    override fun getItemCount() = prompts.size

}