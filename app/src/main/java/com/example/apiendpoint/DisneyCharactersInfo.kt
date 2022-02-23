package com.example.apiendpoint

import android.os.Parcel
import android.os.Parcelable
import java.util.*

@Parcelize
data class DisneyCharactersInfo (
    val name: String,
    val image: String,
    val id: Int,
    val films: Array<String>,
    val tvshow: Array<String>
) : Parcelable
