package com.example.jesus.testapp01.dto

class Plant( var guid : Int, var genus : String, var species : String, var cultivar : String, var common : String, var height : Int = 0) {
    constructor() : this(0, "", "", "", "")
}