package com.example.sandeep.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun buClickEvent(view:View){
       if(isnewvalue)
       {
           etShowNumber.setText("")
       }
        isnewvalue=false

        val buSelect = view as Button
        var buClk:String=etShowNumber.text.toString()

        when(buSelect.id){
            bu0.id->{
                buClk+="0"
            }
            bu1.id->{
                buClk+="1"
            }
            bu2.id->{
                buClk+="2"
            }
            bu3.id->{
                buClk+="3"
            }
            bu4.id->{
                buClk+="4"
            }
            bu5.id->{
                buClk+="5"
            }
            bu6.id->{
                buClk+="6"
            }
            bu7.id->{
                buClk+="7"
            }
            bu8.id->{
                buClk+="8"
            }
            bu9.id->{
                buClk+="9"
            }
            budot.id->{
                buClk+="."
            }
            bupm.id->{
                buClk+="-" + buClk
            }

        }

        etShowNumber.setText(buClk)

    }
var op=""
var oldvalue=""
var isnewvalue=true
     fun buOp(view: View){


         val buSelect = view as Button

         when(buSelect.id){
             budiv.id->{
             op="/"
             }
             buminus.id->{
                 op="-"
             }
             bumulti.id->{
                 op="*"
             }
             buplus.id->{
                 op="+"
             }

             }
         oldvalue=etShowNumber.text.toString()
         isnewvalue=true

     }
    fun buEq(view: View){
 var newnumber=etShowNumber.text.toString()
        var result:Double?=null
        when(op){
            "*"->{
                result=oldvalue.toDouble()*newnumber.toDouble()
            }
            "-"->{
                result=oldvalue.toDouble()-newnumber.toDouble()
            }
            "+"->{
                result=oldvalue.toDouble()+newnumber.toDouble()

            }
            "/"->{
                result=oldvalue.toDouble()/newnumber.toDouble()

            }
        }
        etShowNumber.setText(result.toString())
      isnewvalue=true
    }

   fun bupercenrt(view: View){
       var num=etShowNumber.text.toString().toDouble()/100
       etShowNumber.setText(num.toString())
   }



    fun buClear(view: View){
     etShowNumber.setText("0")
        isnewvalue=true

   }
}
