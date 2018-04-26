package com.example.jesus.testapp01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun button01OnClick (v: View){
        displayToast("1")
    }
    fun button02OnClick (v: View){
        displayToast("2")
    }
    fun button03OnClick (v: View){
        displayToast("3")
    }
    fun button04OnClick (v: View){
        displayToast("4")
    }
    fun displayToast (buttonNumber: String){
        Toast.makeText(this, "Has clickeado el botón: $buttonNumber", Toast.LENGTH_SHORT).show()
    }
}