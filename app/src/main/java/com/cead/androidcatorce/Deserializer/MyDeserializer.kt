package com.cead.androidcatorce.Deserializer


import com.cead.androidcatorce.Models.CityesDesiarilize
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class MyDeserializer : JsonDeserializer<CityesDesiarilize> {



    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): CityesDesiarilize? {

        var id = json!!.asJsonObject.get("id").asInt
        var name = json!!.asJsonObject.get("name").asString
        var country = json!!.asJsonObject.get("sys").asJsonObject.get("country").asString

        var city = CityesDesiarilize(id,name, country)

      return city
    }
}