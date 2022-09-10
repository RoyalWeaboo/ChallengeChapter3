package com.malikazizali.challengechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_alphabet.*

class AlphabetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alphabet_toolbar.title = "Words"

        val alphabet = arrayListOf(
            ListData("A"),
            ListData("B"),
            ListData("C"),
            ListData("D"),
            ListData("E"),
            ListData("F"),
            ListData("G"),
            ListData("H"),
            ListData("I"),
            ListData("J"),
            ListData("K"),
            ListData("L"),
            ListData("M"),
            ListData("N"),
            ListData("O"),
            ListData("P"),
            ListData("Q"),
            ListData("R"),
            ListData("S"),
            ListData("T"),
            ListData("U"),
            ListData("V"),
            ListData("W"),
            ListData("X"),
            ListData("Y"),
            ListData("Z")
        )

        val adapterAlphabet = AlphabetAdapter(alphabet)
        val layMan = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_alphabet.layoutManager = layMan
        rv_alphabet.adapter = adapterAlphabet

        adapterAlphabet.clicked = {
            val choosenAlphabet = Bundle()
            choosenAlphabet.putSerializable("alphabet", it)

            Navigation.findNavController(view).navigate(R.id.action_alphabetFragment_to_wordFragment,choosenAlphabet)
        }

        fun refreshCurrentFragment(){
            val id = Navigation.findNavController(view).currentDestination?.id
            Navigation.findNavController(view).popBackStack(id!!,true)
            Navigation.findNavController(view).navigate(id)
        }

        grid.setOnClickListener {
            val adapterAlphabet = AlphabetAdapter(alphabet)
            val layMan = GridLayoutManager(context, 3)
            rv_alphabet.layoutManager = layMan
            rv_alphabet.adapter = adapterAlphabet

            adapterAlphabet.clicked = {
                val choosenAlphabet = Bundle()
                choosenAlphabet.putSerializable("alphabet", it)

                Navigation.findNavController(view).navigate(R.id.action_alphabetFragment_to_wordFragment,choosenAlphabet)
            }
            grid.setImageResource(R.drawable.ic_baseline_view_linear_24)

            grid.setOnClickListener {
                refreshCurrentFragment()
            }

        }

    }



}