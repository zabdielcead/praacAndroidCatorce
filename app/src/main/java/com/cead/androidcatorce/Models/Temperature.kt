package com.cead.androidcatorce.Models

import com.google.gson.annotations.SerializedName

class Temperature (@SerializedName("temp") var temperature: Float, var pressure: Float,
                   var humidity: Float, @SerializedName("temp_min")var tempMin: Float,
                   @SerializedName("temp_max") var tempMax: Float
                    ) {

    override fun toString(): String {
        return "temperature $temperature pressure $pressure humidity $humidity tempMin $tempMin tempMax $tempMax"
    }
}