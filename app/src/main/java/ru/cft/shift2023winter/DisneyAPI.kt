package ru.cft.shift2023winter

import retrofit2.Response

class DisneyAPI {
    private val apiService = NetworkService.retrofit.create(IDisneyAPI::class.java)
    suspend fun getListOfCharacter(): Response<Root> {
        return apiService.getListOfCharacter()
    }
}