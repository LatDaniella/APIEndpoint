package com.example.apiendpoint

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.disneyapi.dev/characters
interface DisneyCharacterService {
    @GET("characters")
    fun getVaccinations(@Query("lastdays") lastdays : Int) : Call<List<DisneyCharacters>>
    // The @Query is a helper for retrofit that allows you to call any number

    @GET("all")
    fun getWorldwide(@Query("lastdays") lastdays : Int) : Call<List<DisneyCharacters>>

}