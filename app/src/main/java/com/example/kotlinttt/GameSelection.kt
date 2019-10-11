package com.example.kotlinttt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.game_selection.*

class GameSelection : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hvhButton.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.constraintLayoutMain, TicTacToeBoard())?.commit()
        }
    }
}

//supportFragmentManager.beginTransaction()
//.replace(R.id.constraintLayoutMain, GameSelection()).commit()