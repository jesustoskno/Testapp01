package com.example.jesus.testapp01.service

import com.example.jesus.testapp01.dto.Plant

class PlantService {
    fun parsePlantFromJsonData (difficulty :String?) : List<Plant>? {

        //Open connection to a data feed.
        var allPlants = ArrayList<Plant>()
        var plant = Plant()
        // Parse to plant objects

        // Add plant objects to a collection
        allPlants.add(plant)
        // Return collection
        return allPlants
    }
}