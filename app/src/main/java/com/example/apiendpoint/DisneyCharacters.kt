package com.example.apiendpoint

import java.util.*

data class DisneyCharacters (
    val name: String,
    val image: String,
    val id: Int,
    val films: Array<String>,
    val tvshow: Array<String>
)