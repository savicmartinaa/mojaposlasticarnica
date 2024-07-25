package com.example.mojaposlasticarnica.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.mojaposlasticarnica.LoginActivity
import com.example.mojaposlasticarnica.MainActivity
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper
import com.example.mojaposlasticarnica.model.Obavestenje
import com.example.mojaposlasticarnica.utils.getCurrentDate

class ChangePasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_change_password, container, false)

        val buttonChangePassword: Button = view.findViewById(R.id.change_password)


        buttonChangePassword.setOnClickListener {

            //Uradi: proveri prvo pre ovoga da li je password identican sa onim u memoriji

            SharedPreferencesHelper(requireContext()).addObavestenje(Obavestenje("Uspešno ste izmenili lozinku.", getCurrentDate()))
            val korisnik  = SharedPreferencesHelper(requireContext()).getKorisnik()
            korisnik?.let {
                it.lozinka = view.findViewById<EditText>(R.id.newpasswordlabel).text.toString()
                SharedPreferencesHelper(requireContext()).saveKorisnik(it)
            }

            showPasswordChangeDialog()
        }

        return view
    }

    private fun showPasswordChangeDialog() {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle("Izmena lozinke")
                .setMessage("Uspešno ste izmenili lozinku.")
                .setPositiveButton("OK") { dialog: DialogInterface, which: Int ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    private fun notifyPasswordChangeSuccess() {
        val notificationFragment = (activity as? MainActivity)?.getNotificationFragment()
        notificationFragment?.dodajObavestenje("Uspešno ste promenili lozinku.")
    }

    /*private fun navigateToLoginActivity() {
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish() // Završava trenutnu aktivnost
    }*/

}