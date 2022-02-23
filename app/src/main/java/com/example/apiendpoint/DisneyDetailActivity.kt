package com.example.apiendpoint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apiendpoint.databinding.ActivityDisneyDetailBinding

class DisneyDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisneyDetailBinding

    companion object {
        val EXTRA_CHARACTER = "The character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisneyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // extract our Hero object from the intent
        val character = intent.getParcelableExtra<DisneyCharaters>(EXTRA_CHARACTER)
        // put each field of the Hero object into the respective widgets
        binding.textViewDetailCountryName.text = character?.country ?: "Generic Character"
        val lastDay = character?.timeline?.lastKey()
        val lastDayNumber = character?.timeline?.get(lastDay).toString()
        binding.textViewDetailNumOfVacctinations.text = lastDayNumber


    }
}