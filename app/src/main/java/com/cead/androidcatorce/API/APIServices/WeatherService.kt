package com.cead.androidcatorce.API.APIServices

import com.cead.androidcatorce.Models.City
import com.cead.androidcatorce.Models.CityesDesiarilize
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {

        //http://api.openweathermap.org/data/2.5/weather?q=Seville,es&appid=9fcf0b3af833ecf680416626b1854950

    // 9fcf0b3af833ecf680416626b1854950
    // weather?q=Seville,es&appid=9fcf0b3af833ecf680416626b1854950
    @GET("weather")
    fun getCity(@Query("q") city: String, @Query("appid") key: String ): Call<City>

    @GET("weather")
    fun getCityCelsius(@Query("q") city: String, @Query("appid") key: String , @Query("units") value: String): Call<City>


    @GET("weather")
    fun getCityCelsiusDes(@Query("q") city: String, @Query("appid") key: String , @Query("units") value: String): Call<CityesDesiarilize>


}