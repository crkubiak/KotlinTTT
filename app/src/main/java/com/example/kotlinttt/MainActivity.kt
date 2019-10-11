package com.example.kotlinttt

import android.graphics.Color
import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.tictactoe.Game
import com.tictactoe.Rules
import com.tictactoe.TicTacToe


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.game_selection.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        playButton.setOnClickListener {
            d("charles", "play pushed")
            supportFragmentManager.beginTransaction()
                .replace(R.id.constraintLayoutMain, GameSelection()).commit()
        }
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellID = 0
        when(buttonSelected.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
//        Toast.makeText(this, activePlayer.toString() + " " + player1.toString() + " " + player2.toString(), Toast.LENGTH_SHORT).show()
        playGame(cellID, buttonSelected)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.BLUE)
            buSelected.setTextColor(Color.WHITE)
            player1.add(cellID)
            activePlayer = 2
            checkWinner()
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.RED)
            buSelected.setTextColor(Color.WHITE)
            player2.add(cellID)
            activePlayer = 1
            checkWinner()
        }

        buSelected.isEnabled = false

    }

    private fun checkWinner() {
        var winner = -1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){ //row 1 VVV
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){ //row2 VVV
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){ // row 3VVV
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){ // col 1 VVV
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){ // col 2 VVV
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){ // col 3 VVV
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){ //diagonal VVV
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if( winner != -1){

            if (winner==1){
                Toast.makeText(this," Player 1  win the game", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this," Player 2  win the game", Toast.LENGTH_LONG).show()
            }
        }
    }


}

//    fun playGame() {
//        val rules = Rules()
//        rules.victoryCheck(arrayList){}
//    }

