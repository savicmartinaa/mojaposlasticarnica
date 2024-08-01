package com.example.mojaposlasticarnica.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mojaposlasticarnica.MainActivity
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper
import com.example.mojaposlasticarnica.model.Korisnik
import com.example.mojaposlasticarnica.model.Obavestenje
import com.example.mojaposlasticarnica.utils.getCurrentDate

class PersonalDataFragment : Fragment() {

    var korisnik: Korisnik? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_data, container, false)
        SharedPreferencesHelper(requireContext()).getKorisnik()?.let { korisnik ->


            val editTextKorisnickoIme: EditText = view.findViewById(R.id.usernamelabel)

            editTextKorisnickoIme.setText(korisnik.korisnickoIme)


            val editTextIme: EditText = view.findViewById(R.id.namelabel)

            editTextIme.setText(korisnik.ime)


            val editTextPrezime: EditText = view.findViewById(R.id.lastnamelabel)

            editTextIme.setText(korisnik.prezime)


            val editTextTelefon: EditText = view.findViewById(R.id.phonelabel)

            editTextIme.setText(korisnik.kontaktTelefon)


            val editTextAdresa: EditText = view.findViewById(R.id.addresslabel)

            editTextIme.setText(korisnik.adresa)


            val buttonEditPersonalData: Button = view.findViewById(R.id.personal_button)
            val buttonChangePassword: Button = view.findViewById(R.id.password_button)

            buttonEditPersonalData.setOnClickListener {
                //uzmemo sve podatke iz view-a i sacuvamo u SharedPrefs
                val korisnickoIme = editTextKorisnickoIme.text.toString()
                val ime = editTextIme.text.toString()
                val prezime = editTextPrezime.text.toString()
                val kontaktTelefon = editTextTelefon.text.toString()
                val adresa = editTextAdresa.text.toString()


                val noviKorisnik = Korisnik(
                    korisnickoIme = korisnickoIme,
                    lozinka = korisnik.lozinka,
                    ime = ime,
                    prezime = prezime,
                    kontaktTelefon = kontaktTelefon,
                    adresa = adresa
                )
                SharedPreferencesHelper(requireContext()).saveKorisnik(noviKorisnik)

            }

            buttonChangePassword.setOnClickListener {
                SharedPreferencesHelper(requireContext()).addObavestenje(
                    Obavestenje(
                        "Uspešno ste izmenili lične podatke.",
                        getCurrentDate()
                    )
                )
                navigateToFragment(ChangePasswordFragment())
            }
        }

        return view
    }

    private fun showPersonalDataChangeDialog() {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle("Izmena ličnih podataka")
                .setMessage("Uspešno ste izmenili lične podatke.")
                .setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun notifyPersonalDataChangeSuccess() {
        val notificationFragment = (activity as? MainActivity)?.getNotificationFragment()
        notificationFragment?.dodajObavestenje("Uspešno ste promenili lične podatke.")
    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fl_content, fragment)
            .addToBackStack(null)
            .commit()
    }

    //parentFragmentManager je menadžer koji upravlja fragmentima u okviru roditeljskog fragmenta; započinje novu transakciju fragmenta
    //Metod replace zamenjuje fragment koji se trenutno nalazi u okviru R.id.fl_content sa novim fragmentom koji je prosleđen kao argument
    //R.id.fl_content je ID kontejnera u koji će novi fragment biti postavljen. U ovom slučaju, kontejner je FrameLayout ili bilo koji drugi ViewGroup sa ID-jem fl_content
    //addToBackStack(null): Ova linija dodaje transakciju na povratni stek, omogućavajući korisniku da se vrati na prethodni fragment pritiskom na dugme za povratak. Ako prosledite null kao argument, to znači da se koristi podrazumevano ime za povratnu transakciju
    //Metod commit potvrđuje transakciju i čini promene. Nakon poziva ovog metoda, zamena fragmenta će biti izvršena
}