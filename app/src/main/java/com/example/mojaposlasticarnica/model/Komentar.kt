package com.example.mojaposlasticarnica.model

data class Komentar(
    //ovo je jedinstveni id, koristimo umesto id-a, inace treba id koristiti
    var imeSlatkisa: String = "forAll",
    var usernameOsobe:String = "username",
    var komentar: String
)