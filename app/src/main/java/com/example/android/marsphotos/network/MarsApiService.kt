package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com" //creamos constante con la URL de base del servicio web que usaremos

private val retrofit = Retrofit.Builder()                           //creamos objeto retrofit
    .addConverterFactory(ScalarsConverterFactory.create())        //le pasamos el conversor
    .baseUrl(BASE_URL)                                            //le pasamos la constante de la base url del servicio web
    .build()


interface MarsApiService {
    @GET("photos") //agrega el extremo photos al final del url, como si pusieramos /photos en el navegador
    suspend fun getPhotos() : String
}

//objeto publico para inicializar el servicio retrofit
object MarsApi {

    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}
