package com.example.mojaposlasticarnica.model

data class Slatkis(
    var ime: String,
    var cena: Int,
    var valuta: String,
    var cenaSaPopustom: Int = 0,
    var slika: Int,
    var opisProizvoda: String = ""
){
    fun isThereAPopust():Boolean{
        return if (cenaSaPopustom>0 && cenaSaPopustom<cena) true
        else false
    }

    fun dajKonacnuCenu():Int{
        return if (isThereAPopust()){
            cenaSaPopustom
        }else cena
    }
}
