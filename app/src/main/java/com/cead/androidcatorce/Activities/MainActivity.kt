package com.cead.androidcatorce.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cead.androidcatorce.API.API
import com.cead.androidcatorce.API.APIDeserializer
import com.cead.androidcatorce.API.APIServices.WeatherService
import com.cead.androidcatorce.Models.City
import com.cead.androidcatorce.Models.CityesDesiarilize
import com.cead.androidcatorce.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    /*
        APARTADO DE TRADUCCIONES
        POR DEFECTO UTILIZARA EL ARCHIVO strings.xml Cuando el dispositivo busque su lenguaje bucara en los archivos strings.xml paracrearlo se hace de la
        siguiente manera:

        click derecho en values -> Values Resource File en Locale agregamos y nos desplegara una lista de paises escogemos el que utilicemos

        el archivo se tiene que llamar strings

        getString(R.string.welcome)



        /////////////

      HTTP REQUEST

        https://openweathermap.org/
    * */




    var city: City? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /*
        var mJson = JSONObject(json)

        var id = mJson.getInt("id")
        var name = mJson.getString("name")
        city = City(id, name)
        */
        //Toast.makeText(this, ""+ city!!.id + " - "+ city!!.name, Toast.LENGTH_SHORT).show()

        /*
            var json: String = "{\n" +
            "id: 1 ,\n" +
            "name: CEAD" +
            "}"
        * */
        //var gson = Gson() // regresa el objeto city
        //var citygson = gson.fromJson(json, City::class.java)
        //Toast.makeText(this, "gson:  "+ citygson.id + " - "+ citygson.name, Toast.LENGTH_SHORT).show()

        /*
            var json: String = "{\n" +
            "id: 1 ,\n" +
            "name: CEAD" +
            "}"
        * */
        // va a mandar el objeto que tenga la notacion exclude en city
        // var gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        // var citygson = gson.fromJson(json, City::class.java)
        // Toast.makeText(this, "gson:  "+ citygson.toString(), Toast.LENGTH_SHORT).show()

        //otro ejemplo

       /* var json: String = "{" +
                "id: 0 ," +
                "cities: [{" +
                "id: 1," +
                "name: 'London'" +
                "}," +
                "{"+
                "id: 2," +
                "name: 'CDMX'" +
                "}"+
                "]"+
                "}"
        var gson = GsonBuilder().create()
        var town  = gson.fromJson(json, Town::class.java)
            Toast.makeText(this, "gson:  "+ town.id + " - "+ town.cities, Toast.LENGTH_SHORT).show()
            */


        /*
        var retofitWeather = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
         */



        var service: WeatherService = API.getApi()!!.create(WeatherService::class.java)
            //.create(WeatherService::class.java)

        var cities : Call<City> = service.getCity("Seville,ES", API.APP_KEY)

        // llamada asincrona
        cities.enqueue(object : Callback<City>{
            override fun onFailure(call: Call<City>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<City>?, response: Response<City>?) {
               var city: City =  response!!.body()
            }

        })


        var citiesCelsius : Call<City> = service.getCityCelsius("Seville,ES", API.APP_KEY, "metric")

        citiesCelsius.enqueue(object : Callback<City>{
            override fun onFailure(call: Call<City>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<City>?, response: Response<City>?) {
                var city: City =  response!!.body()
            }

        })




        // desiarilizer
        var serviceDes: WeatherService = APIDeserializer.getApi()!!.create(WeatherService::class.java)

        var citiesCelsiusDes : Call<CityesDesiarilize> = serviceDes.getCityCelsiusDes("Seville,ES", API.APP_KEY, "metric")

        citiesCelsiusDes.enqueue(object : Callback<CityesDesiarilize>{
            override fun onFailure(call: Call<CityesDesiarilize>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<CityesDesiarilize>?, response: Response<CityesDesiarilize>?) {
                var city: CityesDesiarilize =  response!!.body()
            }

        })
    }
}
