package com.example.mojaposlasticarnica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.adapter.NotificationAdapter
import com.example.mojaposlasticarnica.adapter.SlatkisAdapter
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper
import com.example.mojaposlasticarnica.model.Slatkis
import com.google.gson.Gson

class ProductFragment : Fragment() {

   /* private lateinit var recyclerViewKomentari: RecyclerView
    private lateinit var komentarAdapter: KomentarAdapter
    private val komentari: MutableList<String> = mutableListOf()*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflatedView = inflater.inflate(R.layout.fragment_product, container, false)
        val recyclerView = inflatedView?.findViewById<RecyclerView>(R.id.recyclerViewKomentari)

        val komentari = SharedPreferencesHelper(requireContext()).getKomentari()
/*
        val editTextKomentar: EditText = view.findViewById(R.id.editTextKomentar)
        val buttonDodajKomentar: Button = view.findViewById(R.id.buttonDodajKomentar)

        recyclerViewKomentari = view.findViewById(R.id.recyclerViewKomentari)
        recyclerViewKomentari.layoutManager = LinearLayoutManager(activity)
        komentarAdapter = KomentarAdapter(komentari)
        recyclerViewKomentari.adapter = komentarAdapter

        buttonDodajKomentar.setOnClickListener {
            val noviKomentar = editTextKomentar.text.toString()
            if (noviKomentar.isNotBlank()) {
                komentari.add(noviKomentar)
                komentarAdapter.notifyItemInserted(komentari.size - 1)
                editTextKomentar.text.clear()
                recyclerViewKomentari.scrollToPosition(komentari.size - 1)
            }
        }

        // Set up the RecyclerView
        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = KomentarAdapter(komentari -> openDetailsFragment(komrntari))
        }*/
        // Inflate the layout for this fragment
        return inflatedView
}
}