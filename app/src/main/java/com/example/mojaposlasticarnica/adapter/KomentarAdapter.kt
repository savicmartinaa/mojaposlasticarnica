package com.example.mojaposlasticarnica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.Komentar

class KomentarAdapter(private val komentarList: List<Komentar>) :
    RecyclerView.Adapter<KomentarAdapter.KomentarViewHolder>() {

    class KomentarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewKomentar: TextView = itemView.findViewById(R.id.textViewKomentar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KomentarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_komentar, parent, false)
        return KomentarViewHolder(view)
    }

    override fun onBindViewHolder(holder: KomentarViewHolder, position: Int) {
        val komentari = komentarList[position]
        //TODO: promeni ime komentari u komentar jer je to u stvari jedan komentar iz liste na nekoj poziciji.
        holder.textViewKomentar.text = komentari.usernameOsobe + ": "+ komentari.komentar
    }

    override fun getItemCount(): Int = komentarList.size
}

