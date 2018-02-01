package com.example.sandeep.agefinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buAge.setOnClickListener {
            try {
                val yearofBirt: Int = textYear.text.toString().toInt()
                var year = Calendar.getInstance().get(Calendar.YEAR)
                val myage = year - yearofBirt
                tv.text = "your age is $myage"
            }catch (ex:Exception){
                println(ex.message)

            }
        }
    }
}
