package com.example.mojaposlasticarnica.adapter;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.KorpaProizvod


class KorpaProizvodAdapter(private val proizvodiUKorpi: List<KorpaProizvod>, private val itemBrisanjeListener: (KorpaProizvod) -> Unit) : RecyclerView.Adapter<KorpaProizvodAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSlika: ImageView = itemView.findViewById(R.id.imageViewSlika)
        val naziv: TextView = itemView.findViewById(R.id.naziv)
        val plus_button: Button = itemView.findViewById(R.id.plus_button)
        val labela: EditText = itemView.findViewById(R.id.labela)
        val minus_button: Button = itemView.findViewById(R.id.minus_button)
        val cena: TextView = itemView.findViewById(R.id.cena)
        val brisanje: Button = itemView.findViewById(R.id.brisanje)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cart_product, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val proizvodKorpa = proizvodiUKorpi[position]

        holder.imageViewSlika.setImageResource(proizvodKorpa.slika)
        holder.naziv.text = proizvodKorpa.naziv
        holder.labela.setText(proizvodKorpa.kolicina.toString())

        holder.plus_button.setOnClickListener {
                incrementLabelValue(holder)
        }

        holder.minus_button.setOnClickListener {
                decrementLabelValue(holder)
        }

        holder.cena.text = proizvodKorpa.cena

        holder.brisanje.setOnClickListener {
            itemBrisanjeListener(proizvodKorpa)
            notifyDataSetChanged()
        }
    }


    private fun incrementLabelValue(holder: ViewHolder) {
        val currentValue = holder.labela.text.toString().toInt()
        holder.labela.setText((currentValue + 1).toString())
    }

    private fun decrementLabelValue(holder: ViewHolder) {
        val currentValue = holder.labela.text.toString().toInt()
        if (currentValue > 1) {
            holder.labela.setText((currentValue - 1).toString())
        }
    }
    override fun getItemCount(): Int = proizvodiUKorpi.size
}



