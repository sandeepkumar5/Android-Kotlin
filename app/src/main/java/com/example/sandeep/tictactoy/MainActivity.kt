package com.example.sandeep.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import java.nio.channels.spi.AbstractSelectableChannel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun buClick(view: View) {
        val buSelected = view as Button
        var cellId = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9

        }

        playgame(cellId, buSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun playgame(cellId: Int, buSelected: Button) {
        if (ActivePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.BLUE)
            player1.add(cellId)
            ActivePlayer = 2
        } else {
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.RED)
            player2.add(cellId)
            ActivePlayer = 1
        }

        buSelected.isEnabled = false
        checkwiner()
    }

    fun checkwiner() {

        var winer = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }
//row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }
//row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }
//col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }
//col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }
        //dig1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winer = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winer = 2
        }
//dig 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winer = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winer = 2
        }

        if (winer != -1) {
            if (winer == 1) {

                Toast.makeText(this, "PLAYER 1 is Winner", Toast.LENGTH_LONG).show()

            } else {

                Toast.makeText(this, "PLAYER 2 is Winner", Toast.LENGTH_LONG).show()
            }

        }


    }
}


