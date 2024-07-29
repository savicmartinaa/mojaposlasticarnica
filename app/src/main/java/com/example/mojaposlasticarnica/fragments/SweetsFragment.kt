package com.example.mojaposlasticarnica.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.adapter.SlatkisAdapter
import com.example.mojaposlasticarnica.model.Slatkis


class SweetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inflatedView = inflater.inflate(R.layout.fragment_sweets, container, false)
        val recyclerView = inflatedView?.findViewById<RecyclerView>(R.id.recyclerViewSweets)

        val slatkisi = listOf(
            Slatkis("Beli kolac", 562, "RSD", 555, R.drawable.belikolac),
            Slatkis("Tri leće kolac", 562, "RSD", 555, R.drawable.trilece),
            Slatkis("Malina kolac", 562, "RSD", 555, R.drawable.malinakolac),
            Slatkis("Princes krofna", 562, "RSD", 555, R.drawable.princeskrofna),
            Slatkis("Krempita", 562, "RSD", 555, R.drawable.krempita),
            Slatkis("Tiramisu", 540, "RSD", 460, R.drawable.tiramisu)

        )

        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = SlatkisAdapter(slatkisi)
            { slatkis ->
                //openDetailsFragment(slatkis)
            }
        }
        return inflatedView
    }


}