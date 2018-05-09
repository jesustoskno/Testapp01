package com.example.jesus.testapp01

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.jesus.testapp01.dto.Plant
import com.example.jesus.testapp01.service.PlantService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun button01OnClick (v: View){
        displayToast("1")
    }
    fun button02OnClick (v: View){
        var redbud = Plant(83, "Cercis", "canadensis", "", "Eastern Redbud")
        var pawpaw = Plant(100, "Asmina", "Triloba", "Alleghany", "Alleghany Pawpaw", 10)
    }
    fun button03OnClick (v: View){
        //Instantiate our GetPlantsActivity
        var getPlantsActivity = GetPlantsActivity()
        getPlantsActivity.execute("1")
        //execute will create a new thread and invoke doInBackground in that new thread.
    }
    fun button04OnClick (v: View){
        displayToast("4")
    }
    fun displayToast (buttonNumber: String){
        Toast.makeText(this, "Has clickeado el botón: $buttonNumber", Toast.LENGTH_SHORT).show()
    }

    inner class GetPlantsActivity : AsyncTask<String, Int, List<Plant>?>() {

        override fun onPostExecute(result: List<Plant>?) {
            super.onPostExecute(result)
        }

        /**
        * Open a connection to a data feed to retrieve data over a network.
        * @param search the search text that will narrow down the result
        * @return a collection of Plant objects that were parsed from JSON.
        */
        override fun doInBackground(vararg search: String?): List<Plant>? {

            var difficulty = search[0]
            var plantService = PlantService()
            plantService.parsePlantFromJsonData(difficulty)
            var allPlants = plantService.parsePlantFromJsonData(difficulty)
            return allPlants
        }

    }
}