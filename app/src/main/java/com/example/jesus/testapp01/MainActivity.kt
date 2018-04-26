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
        Toast.makeText(this, "Has clickeado el botón 1", Toast.LENGTH_SHORT).show()
    }
    fun button02OnClick (v: View){
        Toast.makeText(this, "Has clickeado el botón 2", Toast.LENGTH_SHORT).show()
    }
    fun button03OnClick (v: View){
        Toast.makeText(this, "Has clickeado el botón 3", Toast.LENGTH_SHORT).show()
    }
    fun button04OnClick (v: View){
        Toast.makeText(this, "Has clickeado el botón 4", Toast.LENGTH_SHORT).show()
    }
}