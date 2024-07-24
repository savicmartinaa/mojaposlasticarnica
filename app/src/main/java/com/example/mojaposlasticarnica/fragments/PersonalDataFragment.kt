package com.example.mojaposlasticarnica.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.mojaposlasticarnica.R


/**
 * A simple [Fragment] subclass.
 * Use the [PersonalDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PersonalDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_personal_data, container, false)

        val buttonEditPersonalData: Button = view.findViewById(R.id.personal_button)
        val buttonChangePassword: Button = view.findViewById(R.id.password_button)

        buttonEditPersonalData.setOnClickListener {
            navigateToFragment(EditPersonalDataFragment())
        }

        buttonChangePassword.setOnClickListener {
            navigateToFragment(ChangePasswordFragment())
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

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fl_content, fragment)
            .addToBackStack(null)
            .commit()
    }


}