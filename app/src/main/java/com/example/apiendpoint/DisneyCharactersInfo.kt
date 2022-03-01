package com.example.apiendpoint

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class DisneyCharactersInfo (
    val name: String,
    val image: String,
    val id: Int,
    val films: Array<String>,
    val tvshow: Array<String>
) : Parcelable, Comparable<DisneyCharactersInfo> {
    override fun compareTo(other: DisneyCharactersInfo): Int {
        TODO("Not yet implemented")
    }
}

