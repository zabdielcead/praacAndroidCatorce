package com.cead.androidcatorce.Models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CityesDesiarilize ( var id: Int, var name: String , var country: String) {

    override fun toString(): String {
        return "id: "+ id+"name: "+ name+ "Temperatur: "+ "country "+country
    }


}