package com.example.mojaposlasticarnica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R

private class KomentarAdapter(private val komentarList: List<String>) :
    RecyclerView.Adapter<KomentarAdapter.KomentarViewHolder>() {

    class KomentarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewKomentar: TextView = itemView.findViewById(R.id.recyclerViewKomentari)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KomentarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_komentar, parent, false)
        return KomentarViewHolder(view)
    }

    override fun onBindViewHolder(holder: KomentarViewHolder, position: Int) {
        val komentari = komentarList[position]
       // holder.textViewKomentar.text = komentari.komentar
    }

    override fun getItemCount(): Int = komentarList.size
}

