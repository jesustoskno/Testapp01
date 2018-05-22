package com.example.jesus.testapp01

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.jesus.testapp01.dto.Plant
import com.example.jesus.testapp01.service.PlantService

class MainActivity : AppCompatActivity() {

    val CAMERA_ACTIVITY_REQUEST = 10
    var imageView:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById<ImageView>(R.id.imageView) as ImageView
    }
    fun button01OnClick (v: View){
        displayToast("1")
    }
    fun button02OnClick (v: View){
        var allPlants = ArrayList<Plant>()
        var redbud = Plant(83, "Cercis", "canadensis", "", "Eastern Redbud")
        allPlants.add(redbud)
        var pawpaw = Plant(100, "Asmina", "Triloba", "Alleghany", "Alleghany Pawpaw", 10)
        allPlants.add(pawpaw)
    }
    fun button03OnClick (v: View){
        //Instantiate our GetPlantsActivity
        var getPlantsActivity = GetPlantsActivity()
        getPlantsActivity.execute("1")
        //execute will create a new thread and invoke doInBackground in that new thread.
    }
    fun button04OnClick (v: View){
        var cameraActivityIntent = Intent (MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraActivityIntent, CAMERA_ACTIVITY_REQUEST)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            if(requestCode == CAMERA_ACTIVITY_REQUEST){
                var image = data?.extras?.get("data") as Bitmap
                imageView?.setImageBitmap(image)
            }
        }
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