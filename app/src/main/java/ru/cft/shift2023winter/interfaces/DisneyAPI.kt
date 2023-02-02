package ru.cft.shift2023winter.interfaces

import retrofit2.Response
import ru.cft.shift2023winter.CharacterModel
import ru.cft.shift2023winter.Root
import ru.cft.shift2023winter.network.NetworkService

class DisneyAPI {
    private val apiService = NetworkService.retrofit.create(IDisneyAPI::class.java)
    suspend fun getListOfCharacter(): Response<Root> {
        return apiService.getListOfCharacter()
    }

    suspend fun getCharacterById(id: Int): Response<CharacterModel> {
        return apiService.getCharacterById(id)
    }
}