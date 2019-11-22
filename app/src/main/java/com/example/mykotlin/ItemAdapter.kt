package com.example.mykotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val items: List<ListItem>, private val itemClick: OnItemClick) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    interface OnItemClick{
        operator fun invoke(item: ListItem, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val textView = TextView(parent.context)
//        textView.textSize = 25f
//        textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent,false)

        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindListItem(items[position], position)
    }

    class ViewHolder(view: View,val clickItem: OnItemClick) : RecyclerView.ViewHolder(view){

        private val imageView: ImageView = view.findViewById(R.id.imageView)
        private val textView: TextView = view.findViewById(R.id.textView)

        fun bindListItem(listItem: ListItem, position: Int){
            imageView.setBackgroundResource(R.drawable.ic_launcher_background)
            imageView.setImageResource(R.drawable.ic_launcher_foreground)
            textView.text = "类型${listItem.type} ${listItem.title}"
            itemView.setOnClickListener {
                clickItem(listItem, position)
            }
        }
    }
}