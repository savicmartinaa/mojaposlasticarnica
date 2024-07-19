package com.example.mojaposlasticarnica

import android.os.Bundle
import android.util.Log
import android.view.MenuInflater
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mojaposlasticarnica.fragments.ContactFragment
import com.example.mojaposlasticarnica.fragments.CakeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupMenu()

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
                            toastMessage("kolaciItem")
                            true


                        }

                        R.id.kontaktItem -> {
                            ucitajKontaktFragment()
                            true

                        }

                        R.id.korpaItem -> {
                            toastMessage("korpaItem")
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

    fun toastMessage(message: String) {
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
    }

    fun ucitajKontaktFragment(){
        val newFragment: Fragment = ContactFragment()
        val ft: FragmentTransaction =supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_content, newFragment).commit()
    }


}

