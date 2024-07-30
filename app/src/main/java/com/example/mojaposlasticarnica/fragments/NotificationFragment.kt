package com.example.mojaposlasticarnica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.adapter.NotificationAdapter
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper
import com.example.mojaposlasticarnica.model.Obavestenje
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NotificationFragment : Fragment() {

    private val obavestenja = mutableListOf<Obavestenje>()

    private lateinit var adapter: NotificationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflatedView = inflater.inflate(R.layout.fragment_notification, container, false)

        val recyclerView = inflatedView?.findViewById<RecyclerView>(R.id.recyclerViewNotifications)


        // Sample data
        obavestenja.addAll(
            SharedPreferencesHelper(requireContext()).getObavestenja()
        )


        // Set up the RecyclerView
        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = NotificationAdapter(obavestenja)
        }
        // Inflate the layout for this fragment
        return inflatedView
    }

    fun dodajObavestenje(opis: String) {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = sdf.format(Date())
        val novoObavestenje = Obavestenje(opis, currentDate)
        obavestenja.add(0, novoObavestenje) // Add to the top of the list
        adapter.notifyItemInserted(0)
    }

}