package com.cead.androidcatorce.Models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City (@Expose var id: Int, var name: String, @SerializedName("main" )var temperature: Temperature) {

    override fun toString(): String {
        return "id: "+ id+"name: "+ name+ "Temperatur: "+ temperature.toString()
    }

    fun parseJSON(response: String): Temperature {
        var gson = GsonBuilder().create()
        var temp = gson.fromJson(response, Temperature::class.java)
        return temp
    }
}