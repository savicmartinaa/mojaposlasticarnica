package com.example.mojaposlasticarnica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mojaposlasticarnica.data.SharedPreferencesHelper

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.button_login)
        button.setOnClickListener {
            prijavaNaSistem()
        }
        otvoriMainActivity()  //ovo odkomentarusem za kucanje i proveru lozinke i kor imena
    }


    fun otvoriMainActivity() {
        val myIntent: Intent = Intent(this@LoginActivity, MainActivity::class.java)
        this@LoginActivity.startActivity(myIntent)
    }


    fun prijavaNaSistem() {
        val korisnicko_ime =
            findViewById<EditText>(R.id.kor_ime)
        val lozinka = findViewById<EditText>(R.id.lozinka)

        val sacuvaniKorisnik = SharedPreferencesHelper(this).getKorisnik()
        if (sacuvaniKorisnik != null && korisnicko_ime.text.toString() == sacuvaniKorisnik.korisnickoIme && lozinka.text
                .toString() == sacuvaniKorisnik.lozinka
        ) {
            otvoriMainActivity()
        } else {
            Toast.makeText(this, "Losi podaci", Toast.LENGTH_SHORT).show()
        }
    }
}

