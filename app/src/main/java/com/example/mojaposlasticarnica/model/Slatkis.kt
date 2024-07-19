package com.example.mojaposlasticarnica.model

data class Slatkis(
    val ime: String,
    val cena: Int,
    val valuta: String,
    val cenaSaPopustom: Int = 0,
    val slika: Int
)
