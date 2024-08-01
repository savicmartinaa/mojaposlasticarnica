package com.example.mojaposlasticarnica.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.adapter.KorpaProizvodAdapter
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper


class CartFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedView =  inflater.inflate(R.layout.fragment_cart, container, false)
        val recyclerView = inflatedView?.findViewById<RecyclerView>(R.id.recyclerViewCart)


        val korpaProizvodi = SharedPreferencesHelper(requireContext()).getKorpaProizvodi().toMutableList()
       /* val korpaProizvodi = listOf(
            KorpaProizvod(R.drawable.malinakolac, "Malina kolač", 5, "2500 din"),
            KorpaProizvod(R.drawable.cheese_cake, "Cheese cake", 2, "1000 din")
        )*/

        recyclerView?.let {
            it.layoutManager = LinearLayoutManager(activity)
            it.adapter = KorpaProizvodAdapter(korpaProizvodi){
                korpaProizvodi.remove(it)
                SharedPreferencesHelper(requireContext()).sacuvajKorpu(korpaProizvodi)
            }
        }

        val buttonFinish: Button = inflatedView.findViewById(R.id.cartbutton)

        buttonFinish.setOnClickListener {
            showCartDialog()
        }


        /*val buttonIncrease: Button = view.findViewById(R.id.plus_button)
        val buttonDecrease: Button = view.findViewById(R.id.minus_button)
        val editTextQuantity: EditText = view.findViewById(R.id.labela)

        buttonIncrease.setOnClickListener {
            val currentQuantity = editTextQuantity.text.toString().toInt()
            editTextQuantity.setText((currentQuantity + 1).toString())
        }

        buttonDecrease.setOnClickListener {
            val currentQuantity = editTextQuantity.text.toString().toInt()
            if (currentQuantity > 1) {
                editTextQuantity.setText((currentQuantity - 1).toString())
            }
        }*/

        return inflatedView;
    }
    private fun showCartDialog() {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle("Poručivanje proizvoda iz korpe")
                .setMessage("Uspešno ste završili kupovinu.")
                .setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
                    dialog.dismiss()
                }
                .show()
        }
    }

}