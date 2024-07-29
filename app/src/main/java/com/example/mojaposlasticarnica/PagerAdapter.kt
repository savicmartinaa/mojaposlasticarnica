package com.example.mojaposlasticarnica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.adapter.SlatkisAdapter
import com.example.mojaposlasticarnica.model.Slatkis

class PagerAdapter(private val slatkisLists: List<List<Slatkis>>,private val itemClickListener: (Slatkis) -> Unit) : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewSlatkis)

        fun bind(slatkisList: List<Slatkis>) {
            recyclerView.layoutManager = LinearLayoutManager(itemView.context)
            recyclerView.adapter = SlatkisAdapter(slatkisList) { slatkis ->
                itemClickListener(slatkis)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.page_layout, parent, false)
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(slatkisLists[position])
    }

    override fun getItemCount(): Int = slatkisLists.size
}
