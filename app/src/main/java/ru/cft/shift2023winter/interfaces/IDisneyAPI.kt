package ru.cft.shift2023winter.interfaces

import retrofit2.Response
import retrofit2.http.GET
import ru.cft.shift2023winter.CharacterModel
import ru.cft.shift2023winter.Root

interface IDisneyAPI {
    @GET("/characters")
    suspend fun getListOfCharacter(): Response<Root>
}