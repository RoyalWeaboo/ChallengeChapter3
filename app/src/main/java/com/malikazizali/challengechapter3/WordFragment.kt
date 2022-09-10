package com.malikazizali.challengechapter3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_word.*

class WordFragment : Fragment() {
    lateinit var word : ArrayList<ListData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil data alfabet yang dipilih
        val alph = arguments?.getSerializable("alphabet") as ListData
        val choosenAlph = alph.param

        // toolbar
        back.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_wordFragment_to_alphabetFragment)
        }
        toolbar_title.text = "Words That Start With $choosenAlph"


        //set data yang ditampilkan sesuai alphabet yang dipilih
        if(choosenAlph=="A"){
            word = arrayListOf(
                ListData("Air"),
                ListData("Akar"),
                ListData("Anjing")
            )
        }else if(choosenAlph=="B"){
            word = arrayListOf(
                ListData("Binatang"),
                ListData("Bintang"),
                ListData("Bulan")
            )
        }else if(choosenAlph=="C"){
            word = arrayListOf(
                ListData("Celana"),
                ListData("Cicak"),
                ListData("Cuaca")
            )
        }
        else if(choosenAlph=="D"){
            word = arrayListOf(
                ListData("Dasi"),
                ListData("Delman"),
                ListData("Durian")
            )
        }
        else if(choosenAlph=="E"){
            word = arrayListOf(
                ListData("Elang"),
                ListData("Emas"),
                ListData("Ergonomis")
            )
        }
        else if(choosenAlph=="F"){
            word = arrayListOf(
                ListData("Fajar"),
                ListData("Finlandia"),
                ListData("Frekuensi")
            )
        }else if(choosenAlph=="G"){
            word = arrayListOf(
                ListData("Garuda"),
                ListData("Gorontalo"),
                ListData("Gunung")
            )
        }
        else if(choosenAlph=="H"){
            word = arrayListOf(
                ListData("Halal"),
                ListData("Hewan"),
                ListData("Hotel")
            )
        }
        else if(choosenAlph=="I"){
            word = arrayListOf(
                ListData("Iguana"),
                ListData("Ikan"),
                ListData("Indonesia")
            )
        }
        else if(choosenAlph=="J"){
            word = arrayListOf(
                ListData("Jepang"),
                ListData("Jingga"),
                ListData("Jurang")
            )
        }
        else if(choosenAlph=="K"){
            word = arrayListOf(
                ListData("Kambing"),
                ListData("Kedelai"),
                ListData("Kursi")
            )
        }
        else if(choosenAlph=="L"){
            word = arrayListOf(
                ListData("Lagu"),
                ListData("Lampu"),
                ListData("Lontong")
            )
        }
        else if(choosenAlph=="M"){
            word = arrayListOf(
                ListData("Matahari"),
                ListData("Melodi"),
                ListData("Merak")
            )
        }
        else if(choosenAlph=="N"){
            word = arrayListOf(
                ListData("Nanas"),
                ListData("Negara"),
                ListData("Neptunus")
            )
        }
        else if(choosenAlph=="O"){
            word = arrayListOf(
                ListData("Ontel"),
                ListData("Organisasi"),
                ListData("Owa")
            )
        }
        else if(choosenAlph=="P"){
            word = arrayListOf(
                ListData("Panas"),
                ListData("Pegunungan"),
                ListData("Pintu")
            )
        }
        else if(choosenAlph=="Q"){
            word = arrayListOf(
                ListData("Qaf"),
                ListData("Qatar"),
                ListData("Quran")
            )
        }else if(choosenAlph=="R"){
            word = arrayListOf(
                ListData("Raja"),
                ListData("Racun"),
                ListData("Romawi")
            )
        }else if(choosenAlph=="S"){
            word = arrayListOf(
                ListData("Satu"),
                ListData("Sekolah"),
                ListData("Suara")
            )
        }else if(choosenAlph=="T"){
            word = arrayListOf(
                ListData("Tahu"),
                ListData("Telur"),
                ListData("Toraja")
            )
        }else if(choosenAlph=="U"){
            word = arrayListOf(
                ListData("Uap"),
                ListData("Uang"),
                ListData("Udara")
            )
        }else if(choosenAlph=="V"){
            word = arrayListOf(
                ListData("Vaksin"),
                ListData("Vektor"),
                ListData("Vitamin")
            )
        }
        else if(choosenAlph=="W"){
            word = arrayListOf(
                ListData("Wacana"),
                ListData("Wadah"),
                ListData("Warna")
            )
        }else if(choosenAlph=="X"){
            word = arrayListOf(
                ListData("Xenia"),
                ListData("Xenofobia"),
                ListData("Xenolit")
            )
        }else if(choosenAlph=="Y"){
            word = arrayListOf(
                ListData("Yoga"),
                ListData("Yoyo"),
                ListData("Yodium")
            )
        }else if(choosenAlph=="Z"){
            word = arrayListOf(
                ListData("Zat"),
                ListData("Zakat"),
                ListData("Zebra")
            )
        }

        //set adapter dan layout manager
        val adapterWord = WordAdapter(word)
        val layMan = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_word.layoutManager = layMan
        rv_word.adapter = adapterWord

        //ketika salah satu card di klik
        adapterWord.clicked = {
            val choosenWord = it.param
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$choosenWord"))
            startActivity(intent)
        }
    }

}