package com.example.apiendpoint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiendpoint.databinding.ActivityDisneyListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisneyListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDisneyListBinding
    lateinit var adapter: DisneyAdapter

    companion object {
        val TAG = "DisneyListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisneyListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var disneyList = listOf<DisneyCharactersInfo>()

        val disneyApi = RetrofitHelper.getInstance().create(DisneyCharacterService::class.java)
        val disneyCall = disneyApi.getDisneyCharacters(10)

        disneyCall.enqueue(object : Callback<List<DisneyCharactersInfo>> {
            override fun onResponse(
                call: Call<List<DisneyCharactersInfo>>,
                response: Response<List<DisneyCharactersInfo>>
            ) {
                // Here you know you got information back from the server
                // So any code that relies upon having this information
                // has to go here
                Log.d(TAG, "OnResponse: ${response.body()}")
                disneyList = response.body() ?: listOf<DisneyCharactersInfo>()
                adapter = DisneyAdapter(disneyList)
                binding.recyclerViewDisneyItem.adapter = adapter
                binding.recyclerViewDisneyItem.layoutManager = LinearLayoutManager(this@DisneyListActivity)
            }

            override fun onFailure(call: Call<List<DisneyCharactersInfo>>, t: Throwable) {
                Log.d(TAG, "onFailure :${t.message}")
            }
        }
        )
    }
}