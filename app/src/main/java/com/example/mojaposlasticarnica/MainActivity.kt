package com.example.mojaposlasticarnica

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mojaposlasticarnica.fragments.ContactFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu);
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.tortaItem -> {
                toastMessage("torta")
            }

            R.id.kolaciItem -> {
                toastMessage("kolaciItem")

            }

            R.id.kontaktItem -> {
                ucitajKontaktFragment()

            }

            R.id.korpaItem -> {
                toastMessage("korpaItem")
            }
        }
        return super.onOptionsItemSelected(item)
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

