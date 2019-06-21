package com.cead.androidcatorce.API

import com.cead.androidcatorce.Deserializer.MyDeserializer
import com.cead.androidcatorce.Models.CityesDesiarilize
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIDeserializer {

    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        var  retrofit : Retrofit?  = null
        val APP_KEY = "9fcf0b3af833ecf680416626b1854950"

        fun getApi(): Retrofit? {
            if(retrofit == null){

               var builders = GsonBuilder()
                builders.registerTypeAdapter(CityesDesiarilize::class.java, MyDeserializer())

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builders.create()))
                    .build()
            }


            return retrofit
        }


    }

}