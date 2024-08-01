package com.example.mojaposlasticarnica.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.adapter.KomentarAdapter
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper
import com.example.mojaposlasticarnica.model.Komentar
import com.example.mojaposlasticarnica.model.KorpaProizvod
import com.example.mojaposlasticarnica.model.Slatkis
import com.example.mojaposlasticarnica.utils.showCustomDialog
import com.google.gson.Gson

private const val ARG_PARAM1 = "param1"

class ProductFragment : Fragment() {

    private lateinit var recyclerViewKomentari: RecyclerView
    private lateinit var komentarAdapter: KomentarAdapter
    private val komentari: MutableList<String> = mutableListOf()
    private var mSlatkis: Slatkis? = null

    private lateinit var plusButton: Button
    private lateinit var minusButton: Button
    private lateinit var labela: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mSlatkis = Gson().fromJson(it.getString(ARG_PARAM1), Slatkis::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflatedView = inflater.inflate(R.layout.fragment_product, container, false)

        val komentari = SharedPreferencesHelper(requireContext()).getKomentari().toMutableList()


        val editTextKomentar: EditText = inflatedView.findViewById(R.id.editTextKomentar)
        val buttonDodajKomentar: Button = inflatedView.findViewById(R.id.buttonDodajKomentar)

        recyclerViewKomentari = inflatedView.findViewById(R.id.recyclerViewKomentari)
        recyclerViewKomentari.layoutManager = LinearLayoutManager(activity)
        komentarAdapter = KomentarAdapter(komentari)
        recyclerViewKomentari.adapter = komentarAdapter

        popuniPoljaSlatkisa(inflatedView)

        buttonDodajKomentar.setOnClickListener {
            val noviKomentar = editTextKomentar.text.toString()
            if (noviKomentar.isNotBlank()) {
                komentari.add(Komentar(imeSlatkisa = mSlatkis?.ime ?: "forAll",
                    usernameOsobe = SharedPreferencesHelper(requireContext()).getKorisnik()?.korisnickoIme
                        ?: "n/a",
                    komentar = noviKomentar
                )
                )
                komentarAdapter.notifyItemInserted(komentari.size - 1)
                editTextKomentar.text.clear()
                recyclerViewKomentari.scrollToPosition(komentari.size - 1)
            }
        }

        // Inflate the layout for this fragment
        return inflatedView
    }

    private fun popuniPoljaSlatkisa(inflatedView: View) {
        val textViewNaziv: TextView = inflatedView.findViewById(R.id.naziv_proizvoda)
        val textViewOpis: TextView = inflatedView.findViewById(R.id.opis)

        val imageViewSlika: ImageView = inflatedView.findViewById(R.id.slika)

        mSlatkis?.let {
            textViewNaziv.text = it.ime
            textViewOpis.text = it.opisProizvoda
            imageViewSlika.setImageResource(it.slika)

        }

        plusButton = inflatedView.findViewById(R.id.plus_button)
        minusButton = inflatedView.findViewById(R.id.minus_button)
        labela = inflatedView.findViewById(R.id.labela)

        // Set initial value for labela
        labela.setText("1")

        // Set onClickListeners for the buttons
        plusButton.setOnClickListener {
            incrementLabelValue()
        }

        minusButton.setOnClickListener {
            decrementLabelValue()
        }


        inflatedView.findViewById<Button>(R.id.dodavanjeUKorpu).setOnClickListener {
            val kolicina = labela.text.toString().toInt()
            mSlatkis?.let {
                val proizvod = KorpaProizvod(it.slika,it.ime, kolicina, (kolicina * it.dajKonacnuCenu()).toString() + " RSD")


                SharedPreferencesHelper(requireContext()).dodajProizvodUKorpu(proizvod)
                //TODO: Prikazi dijalog da je uspesno dodato
                requireContext().showCustomDialog("Uspesno dodat proizvod u korpu")
            }
        }

    }

    private fun incrementLabelValue() {
        val currentValue = labela.text.toString().toInt()
        labela.setText((currentValue + 1).toString())
    }

    private fun decrementLabelValue() {
        val currentValue = labela.text.toString().toInt()
        if (currentValue > 1) {
            labela.setText((currentValue - 1).toString())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(slatkis: Slatkis) =
            ProductFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, Gson().toJson(slatkis))
                }
            }
    }

}