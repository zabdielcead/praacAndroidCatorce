package com.cead.androidcatorce.Models

import com.google.gson.GsonBuilder

class Town( var id:Int, var cities: List<City> ) {

// @SerializedName("ciudades") seria el nombre con el que viene del JSON y se pone arriba de la varaibles es decir nosotros podemos renombrarla el nombre del que viene el JSON


     fun parseJSON(response: String): City {
        var gson = GsonBuilder().create()
        var citys = gson.fromJson(response, City::class.java)
        return citys
    }
}