package com.example.mojaposlasticarnica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.Slatkis

class SlatkisAdapter(private val slatkisList: List<Slatkis>) : RecyclerView.Adapter<SlatkisAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSlika: ImageView = itemView.findViewById(R.id.imageViewSlika)
        val textViewIme: TextView = itemView.findViewById(R.id.textViewIme)
        val textViewCena: TextView = itemView.findViewById(R.id.textViewCena)
        val textViewCenaSaPopustom: TextView = itemView.findViewById(R.id.textViewCenaSaPopustom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sweet_sale, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val slatkis = slatkisList[position]
        holder.textViewIme.text = slatkis.ime
        holder.textViewCena.text = "${slatkis.cena} ${slatkis.valuta}"
        if (slatkis.cenaSaPopustom!= 0 )
            holder.textViewCenaSaPopustom.text = "${slatkis.cenaSaPopustom} ${slatkis.valuta}"
        else
            holder.textViewCenaSaPopustom.visibility = View.GONE

        holder.imageViewSlika.setImageResource(slatkis.slika)

    }

    override fun getItemCount() = slatkisList.size
}
