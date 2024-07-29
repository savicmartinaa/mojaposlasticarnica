package com.example.mojaposlasticarnica.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.example.mojaposlasticarnica.PagerAdapter
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.Slatkis
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PromotionsFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private val handler = Handler(Looper.getMainLooper())
    private var page = 0

    private val slatkisLists = listOf(
        listOf(
            Slatkis("Badem torta", 570, "RSD", 480, R.drawable.badem),
            Slatkis("Oreo torta", 520, "RSD", 450, R.drawable.oreo)
        ),
        listOf(
            Slatkis("Kapri torta", 700, "RSD", 650, R.drawable.kapri),
            Slatkis("Beli anđeo torta", 520, "RSD", 450, R.drawable.beli_andjeo)
        )
    )

    private val runnable = object : Runnable {
        override fun run() {
            page = (page + 1) % slatkisLists.size
            viewPager.currentItem = page
            handler.postDelayed(this, 3000)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_promotions, container, false)

        viewPager = view.findViewById(R.id.viewPager)
        viewPager.adapter = PagerAdapter(slatkisLists)
        { slatkis ->
            openDetailsFragment(slatkis)
        }

        val tabLayout =  view.findViewById<TabLayout>(R.id.tab_layout);
        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        // Start the page switcher
        handler.post(runnable)

        return view
    }

    private fun openDetailsFragment(slatkis: Slatkis) {
        val fragment = ProductFragment.newInstance(slatkis)
        val ft: FragmentTransaction =parentFragmentManager.beginTransaction()
        ft.add(R.id.fl_content, fragment).commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler.removeCallbacks(runnable)
    }


}