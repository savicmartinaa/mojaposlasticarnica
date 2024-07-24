package com.example.mojaposlasticarnica

import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mojaposlasticarnica.fragments.ContactFragment
import com.example.mojaposlasticarnica.fragments.CakeFragment
import com.example.mojaposlasticarnica.fragments.CartFragment
import com.example.mojaposlasticarnica.fragments.NotificationFragment
import com.example.mojaposlasticarnica.fragments.PersonalDataFragment
import com.example.mojaposlasticarnica.fragments.SweetsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var notificationFragment: NotificationFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupMenu()

        notificationFragment = NotificationFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_content, notificationFragment)
            .commit()


        val buttonPersonalData: ImageButton = findViewById(R.id.button1)
        val buttonNotifications: ImageButton = findViewById(R.id.button2)

        buttonPersonalData.setOnClickListener {
            showPersonalDataFragment()
        }

        buttonNotifications.setOnClickListener {
            showNotificationsFragment()
        }
    }

    private fun setupMenu() {
        val menuButton: ImageButton = findViewById(R.id.menuButton)

        menuButton.setOnClickListener {
            val popup = PopupMenu(this, menuButton)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.menu, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                        R.id.tortaItem -> {
                            ucitajTorteFragment()
                            true

                        }

                        R.id.kolaciItem -> {
                            ucitajKolaciFragment()
                            true


                        }

                        R.id.kontaktItem -> {
                            ucitajKontaktFragment()
                            true

                        }

                        R.id.korpaItem -> {
                            ucitajKorpaFragment()
                            true

                        }
                    else -> false
                }
            }
            popup.show()
        }

    }

    private fun ucitajTorteFragment() {
        val cakeFragment: Fragment = CakeFragment()
        val ft: FragmentTransaction =supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, cakeFragment).commit()
    }

    private fun ucitajKolaciFragment() {
        val sweetFragment: Fragment = SweetsFragment()
        val ft: FragmentTransaction =supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, sweetFragment).commit()
    }

    private fun ucitajKorpaFragment() {
        val cartFragment: Fragment = CartFragment()
        val ft: FragmentTransaction =supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, cartFragment).commit()
    }

    fun ucitajKontaktFragment(){
        val newFragment: Fragment = ContactFragment()
        val ft: FragmentTransaction =supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, newFragment).commit()
    }


    private fun showPersonalDataFragment() {
        val fragment = PersonalDataFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_content, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun showNotificationsFragment() {
        val fragment = NotificationFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_content, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun getNotificationFragment(): NotificationFragment {
        return notificationFragment
    }


    /*fun toastMessage(message: String) {
        Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart();
        Log.i("poruka", "on start method");
    }

    override fun onResume() {
        super.onResume();
        Log.i("poruka", "on resume method");
    }

    override fun onPause() {
        super.onPause();
        Log.i("poruka", "on pause method");
    }

    override fun onStop() {
        super.onStop();
        Log.i("poruka", "on stop method");
    }

    override fun onDestroy() {
        super.onDestroy();
        Log.i("poruka", "on destroy method");
    }

    override fun onRestart() {
        super.onRestart();
        Log.i("poruka", "on restart method");
    }*/
}

