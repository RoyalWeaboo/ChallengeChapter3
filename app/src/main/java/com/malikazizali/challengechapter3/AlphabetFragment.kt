package com.malikazizali.challengechapter3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        alphabet_toolbar.setTitle("Words")

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
            val wordFragment = WordFragment()

            val bun = Bundle()
            bun.putSerializable("alphabet",it)
            wordFragment.arguments = bun

            val mgr = fragmentManager
            val ft = mgr?.beginTransaction()
            ft?.replace(R.id.fragment_container, wordFragment)
            ft?.commit()
        }

        fun refreshCurrentFragment(){
            val thisFragment = AlphabetFragment()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, thisFragment)?.commit()
        }

        grid.setOnClickListener {
            val adapterAlphabet = AlphabetAdapter(alphabet)
            val layMan = GridLayoutManager(context, 3)
            rv_alphabet.layoutManager = layMan
            rv_alphabet.adapter = adapterAlphabet

            adapterAlphabet.clicked = {
                val wordFragment = WordFragment()

                val bun = Bundle()
                bun.putSerializable("alphabet",it)
                wordFragment.arguments = bun

                val mgr = fragmentManager
                val ft = mgr?.beginTransaction()
                ft?.replace(R.id.fragment_container, wordFragment)
                ft?.commit()
            }
            grid.setImageResource(R.drawable.ic_baseline_view_linear_24)

            grid.setOnClickListener {
                refreshCurrentFragment()
            }

        }
    }

}