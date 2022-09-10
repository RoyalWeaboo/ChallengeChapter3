package com.malikazizali.challengechapter3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(val listData : ArrayList<ListData>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    var clicked : ((ListData)->Unit)? = null
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view){
        var param = view.findViewById<TextView>(R.id.tv_alphabet)
        var card = view.findViewById<CardView>(R.id.cv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v  = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.param.text = listData[position].param
        holder.card.setOnClickListener {
            clicked?.invoke(listData[position])
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}