package ru.cft.shift2023winter.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.cft.shift2023winter.interfaces.IDisneyAPI

object NetworkService {

    private const val BASE_URL = "https://api.disneyapi.dev/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}