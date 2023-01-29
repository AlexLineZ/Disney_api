package ru.cft.shift2023winter

import retrofit2.Response
import retrofit2.http.GET

interface IDisneyAPI {
    @GET("characters")
    suspend fun getListOfCharacter(): Response<Root>
}