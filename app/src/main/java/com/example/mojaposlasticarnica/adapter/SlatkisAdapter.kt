package com.example.mojaposlasticarnica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.Slatkis

class SlatkisAdapter(private val slatkisList: List<Slatkis>, private val itemClickListener: (Slatkis) -> Unit) : RecyclerView.Adapter<SlatkisAdapter.ViewHolder>() {

    private val TYPE_OBICAN = 1
    private val TYPE_POPUST = 2
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSlika: ImageView = itemView.findViewById(R.id.imageViewSlika)
        val textViewIme: TextView = itemView.findViewById(R.id.textViewIme)
        val textViewCena: TextView = itemView.findViewById(R.id.textViewCena)
        val textViewCenaSaPopustom: TextView? = itemView.findViewById(R.id.textViewCenaSaPopustom)
    }

    override fun getItemViewType(position: Int): Int {
        val slatkis = slatkisList[position]
        return if (slatkis.isThereAPopust()){
            TYPE_POPUST
        }else{
            TYPE_OBICAN
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = when(viewType){
            TYPE_OBICAN->{
                LayoutInflater.from(parent.context).inflate(R.layout.item_sweet, parent, false)
            }

            TYPE_POPUST->{
                LayoutInflater.from(parent.context).inflate(R.layout.item_sweet_sale, parent, false)
            }

            else->{
                LayoutInflater.from(parent.context).inflate(R.layout.item_sweet, parent, false)
            }
        }

        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val slatkis = slatkisList[position]
        holder.textViewIme.text = slatkis.ime
        holder.textViewCena.text = "${slatkis.cena} ${slatkis.valuta}"
        holder.textViewCenaSaPopustom?.let{
            if (slatkis.isThereAPopust() )
                it.text = "${slatkis.cenaSaPopustom} ${slatkis.valuta}"
        }


        holder.imageViewSlika.setImageResource(slatkis.slika)
        holder.itemView.setOnClickListener {
           itemClickListener(slatkis)
        }


    }

    override fun getItemCount() = slatkisList.size
}
