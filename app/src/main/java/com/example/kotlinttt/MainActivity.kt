package com.example.kotlinttt

import android.os.Bundle
import android.util.Log.d
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        playButton.setOnClickListener {
            d("charles", "play pushed")
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, TicTacToeBoard()).commit()


        }
    }
}
