package com.example.apiendpoint

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.disneyapi.dev/characters
interface DisneyCharacterService {
    @GET("characters")
    fun getDisneyCharacters(@Query("lastdays") lastdays : Int) : Call<List<DisneyCharactersInfo>>
    // The @Query is a helper for retrofit that allows you to call any number

}