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

class CakeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inflatedView = inflater.inflate(R.layout.fragment_cake, container, false)

        val recyclerView = inflatedView?.findViewById<RecyclerView>(R.id.recyclerViewCakes)

        // Sample data
        val slatkisi = listOf(
            Slatkis("Badem torta", 570, "RSD", 480, R.drawable.badem),
            Slatkis("Oreo torta", 520, "RSD", 450, R.drawable.oreo),
            Slatkis("Kapri torta", 700, "RSD", 650, R.drawable.kapri) ,
            Slatkis("Beli anđeo torta", 520, "RSD", 450, R.drawable.beli_andjeo),
            Slatkis("Baron torta", 600, "RSD", 550, R.drawable.baron),
            Slatkis("Cheese cake", 700, "RSD", 650, R.drawable.cheese_cake)
        )

        // Set up the RecyclerView
        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = SlatkisAdapter(slatkisi)
        }
        // Inflate the layout for this fragment
        return inflatedView
    }

}