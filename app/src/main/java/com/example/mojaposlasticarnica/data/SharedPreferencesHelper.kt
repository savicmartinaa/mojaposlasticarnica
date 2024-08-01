package com.example.mojaposlasticarnica.data

import android.content.Context
import android.content.SharedPreferences
import com.example.mojaposlasticarnica.R
import com.example.mojaposlasticarnica.model.Komentar
import com.example.mojaposlasticarnica.model.Korisnik
import com.example.mojaposlasticarnica.model.KorpaProizvod
import com.example.mojaposlasticarnica.model.Obavestenje
import com.example.mojaposlasticarnica.model.Slatkis
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreferencesHelper(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        private const val SHARED_PREFS_KEY = "com.example.mojaposlasticarnica.PREFS"
        private const val KEY_TORTE = "com.example.mojaposlasticarnica.TORTE"
        private const val KEY_OBAVESTENJA = "com.example.mojaposlasticarnica.OBAVESTENJA"
        private const val KEY_KOLACI = "com.example.mojaposlasticarnica.KOLACI"
        private const val KEY_KORISNIK = "com.example.mojaposlasticarnica.KORISNIK"
        private const val KEY_FIRST_LAUNCH = "com.example.mojaposlasticarnica.FIRST_LAUNCH"
        private const val KEY_KOMENTARI = "com.example.mojaposlasticarnica.KOMENTARI"
        private const val KEY_KORPA = "com.example.mojaposlasticarnica.KORPA"

    }

    // Initialize the data if it's the first launch
    fun initializeDataIfFirstLaunch() {
        val isFirstLaunch = sharedPreferences.getBoolean(KEY_FIRST_LAUNCH, true)
        if (isFirstLaunch) {
            // Predefined list of torte
            val torte = listOf(
                Slatkis("Badem torta", 570, "RSD", 480, R.drawable.badem, opisProizvoda = "Martina, dodaj svuda opise proizvoda"),
                Slatkis("Oreo torta", 520, "RSD", 450, R.drawable.oreo, "Martina, dodaj svuda opise proizvoda"),
                Slatkis("Kapri torta", 540, "RSD", 540, R.drawable.kapri,  "Martina, dodaj svuda opise proizvoda"),
                Slatkis("Beli anđeo torta", 520, "RSD", 450, R.drawable.beli_andjeo, "Martina, dodaj svuda opise proizvoda"),
                Slatkis("Baron torta", 540, "RSD", 540, R.drawable.baron, "Martina, dodaj svuda opise proizvoda"),
                Slatkis("Cheese cake", 540, "RSD", 540, R.drawable.cheese_cake, "Martina, dodaj svuda opise proizvoda")
            )
            saveList(KEY_TORTE, torte)

            // Predefined list of obavestenja
            val obavestenja = listOf(
                Obavestenje("Uspešno ste poručili proizvode iz korpe.", "2024-07-24"),
                Obavestenje("Uspešno ste poručili proizvode iz korpe.", "2024-07-04")
            )
            saveList(KEY_OBAVESTENJA, obavestenja)

            // Predefined list of kolaci
            val kolaci = listOf(
                Slatkis("Beli kolac", 520, "RSD", 520, R.drawable.belikolac),
                Slatkis("Tri leće kolac", 540, "RSD", 540, R.drawable.trilece),
                Slatkis("Malina kolac", 520, "RSD", 520, R.drawable.malinakolac),
                Slatkis("Princes krofna", 480, "RSD", 480, R.drawable.princeskrofna),
                Slatkis("Krempita", 480, "RSD", 480, R.drawable.krempita),
                Slatkis("Tiramisu", 540, "RSD", 460, R.drawable.tiramisu)
            )
            saveList(KEY_KOLACI, kolaci)

            val korisnik = Korisnik(
                korisnickoIme = "admin",
                lozinka = "admin123",
                ime = "Marija",
                prezime = "Simic",
                kontaktTelefon = "0628945786",
                adresa = "Vojvode Misica 15, Novi Sad"
            )
            saveKorisnik(korisnik)

            // Predefined list of komentari
            val komentari = listOf(
                Komentar(komentar = "Torta je kremasta i ukusna."),
                Komentar(komentar = "Odličan izbor za proslave.")
            )
            saveList(KEY_KOMENTARI, komentari)

            // Mark the first launch as completed
            sharedPreferences.edit().putBoolean(KEY_FIRST_LAUNCH, false).apply()
        }
    }

    // Generic function to save list of any type
    private fun <T> saveList(key: String, list: List<T>) {
        val json = gson.toJson(list)
        sharedPreferences.edit().putString(key, json).apply()
    }

    // Generic function to get list of any type
    private inline fun <reified T> getList(key: String): List<T> {
        val json = sharedPreferences.getString(key, null) ?: return emptyList()
        val type = object : TypeToken<List<T>>() {}.type
        return gson.fromJson(json, type)
    }

    // Specific functions to get lists of Slatkis and Obavestenje
    fun getTorte(): List<Slatkis> = getList(KEY_TORTE)
    fun getObavestenja(): List<Obavestenje> = getList(KEY_OBAVESTENJA)
    fun getKolaci(): List<Slatkis> = getList(KEY_KOLACI)
    fun getKomentari(): List<Komentar> = getList(KEY_KOMENTARI)

    fun getKorpaProizvodi():  List<KorpaProizvod> = getList(KEY_KORPA)

    // Function to add one more Obavestenje to the list
    fun addObavestenje(obavestenje: Obavestenje) {
        val currentObavestenja = getObavestenja().toMutableList()
        currentObavestenja.add(obavestenje)
        saveList(KEY_OBAVESTENJA, currentObavestenja)
    }

    // Function to save Korisnik object
    fun saveKorisnik(korisnik: Korisnik) {
        val json = gson.toJson(korisnik)
        sharedPreferences.edit().putString(KEY_KORISNIK, json).apply()
    }

    // Function to get Korisnik object
    fun getKorisnik(): Korisnik? {
        val json = sharedPreferences.getString(KEY_KORISNIK, null) ?: return null
        return gson.fromJson(json, Korisnik::class.java)
    }

    fun clearAllSharedPreferences() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply() // or editor.commit() if you want to do it synchronously
    }

    fun vratiMiAktuelnePromocije(): List<List<Slatkis>> {
        val lista = mutableListOf<List<Slatkis>>()

        val listaKolacaSaPromocijom = mutableListOf<Slatkis>()
        getKolaci().forEach {
            if (it.isThereAPopust() && listaKolacaSaPromocijom.size<2)listaKolacaSaPromocijom.add(it)
        }
        val listaTortiSaPromocijom = mutableListOf<Slatkis>()
        getTorte().forEach {
            if (it.isThereAPopust() && listaTortiSaPromocijom.size<2)listaTortiSaPromocijom.add(it)
        }
        lista.add(0, listaKolacaSaPromocijom)
        lista.add(1, listaTortiSaPromocijom)
        return lista
    }

    fun dodajProizvodUKorpu(proizvod: KorpaProizvod){
        val lista = getKorpaProizvodi()
        val novaLista = lista.toMutableList()
        novaLista.add(proizvod)
        saveList(KEY_KORPA, novaLista)
    }

    fun sacuvajKorpu(korpaProizvodi: MutableList<KorpaProizvod>) {
        saveList(KEY_KORPA, korpaProizvodi)
    }

}

