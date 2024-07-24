package com.example.mojaposlasticarnica.fragments

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.mojaposlasticarnica.LoginActivity
import com.example.mojaposlasticarnica.MainActivity
import com.example.mojaposlasticarnica.R

class ChangePasswordFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_change_password, container, false)

        val buttonChangePassword: Button = view.findViewById(R.id.change_password)


        buttonChangePassword.setOnClickListener {
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