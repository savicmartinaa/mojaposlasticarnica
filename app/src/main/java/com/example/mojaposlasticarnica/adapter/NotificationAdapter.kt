package com.example.mojaposlasticarnica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.Obavestenje
import com.example.mojaposlasticarnica.model.Slatkis

class NotificationAdapter(private val obavestenjaList: List<Obavestenje>) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewObavestenje: TextView = itemView.findViewById(R.id.obavestenje)
        val textViewDatum: TextView = itemView.findViewById(R.id.datum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val notification = obavestenjaList[position]
        holder.textViewObavestenje.text = notification.obavestenje
        holder.textViewDatum.text = notification.datum.toString()
    }

    override fun getItemCount() = obavestenjaList.size

    // da NotificationAdapter može da ažurira podatke i da se pravilno prikazuje kad se podaci promene
    fun updateData(newList: List<Obavestenje>) {
        (obavestenjaList as MutableList).clear()
        (obavestenjaList as MutableList).addAll(newList)
        notifyDataSetChanged()
    }
}
