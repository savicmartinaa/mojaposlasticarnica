package com.example.mojaposlasticarnica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
        if (korisnicko_ime.getText().toString() == "admin" && lozinka.getText()
                .toString() == "admin123"
        ) {
            otvoriMainActivity()
        } else {
            Toast.makeText(this, "Losi podaci", Toast.LENGTH_SHORT).show()
        }
    }
}

