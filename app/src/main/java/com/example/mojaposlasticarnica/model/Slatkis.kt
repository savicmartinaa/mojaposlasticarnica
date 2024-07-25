package com.example.mojaposlasticarnica.model

data class Slatkis(
    var ime: String,
    var cena: Int,
    var valuta: String,
    var cenaSaPopustom: Int = 0,
    var slika: Int
)
