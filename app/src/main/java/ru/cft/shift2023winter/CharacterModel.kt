package ru.cft.shift2023winter

import java.util.*
import kotlin.collections.ArrayList

data class CharacterModel(
    var _id: Int = 0,
    var films: ArrayList<String>?,
    var shortFilms: ArrayList<String>?,
    var tvShows: ArrayList<String>?,
    var videoGames: ArrayList<String>?,
    var parkAttractions: ArrayList<String>?,
    var allies: ArrayList<Any>?,
    var enemies: ArrayList<Any>?,
    var sourceUrl: String?,
    var name: String?,
    var imageUrl: String?,
    var createdAt: Date?,
    var updatedAt: Date?,
    var url: String?,
    var __v: Int = 0
)

data class Root (
    var data: ArrayList<CharacterModel>? ,
    var count: Int = 0 ,
    var previousPage: String?  ,
    var nextPage: String?
)