package ru.cft.shift2023winter.interfaces

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.cft.shift2023winter.CharacterModel
import ru.cft.shift2023winter.Root

interface IDisneyAPI {
    @GET("/characters?")
    suspend fun getListOfCharacter(@Query("page") pageNum: Int): Response<Root>

    @GET("/characters/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Response<CharacterModel>
}