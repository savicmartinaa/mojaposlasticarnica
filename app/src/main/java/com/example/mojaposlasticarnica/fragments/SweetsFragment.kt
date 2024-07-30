package com.example.mojaposlasticarnica.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.adapter.SlatkisAdapter
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper
import com.example.mojaposlasticarnica.model.Slatkis


class SweetsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inflatedView = inflater.inflate(R.layout.fragment_sweets, container, false)
        val recyclerView = inflatedView?.findViewById<RecyclerView>(R.id.recyclerViewSweets)

        // Sample data
        val kolaci = SharedPreferencesHelper(requireContext()).getKolaci()

        // Set up the RecyclerView
        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = SlatkisAdapter(kolaci){ slatkis ->
                openDetailsFragment(slatkis)
            }
        }
        // Inflate the layout for this fragment
        return inflatedView
    }
    private fun openDetailsFragment(slatkis: Slatkis) {
       // val fragment = ProductFragment.newInstance(slatkis)
       // val ft: FragmentTransaction =parentFragmentManager.beginTransaction()
      //  ft.add(R.id.fl_content, fragment).commit()
    }
}