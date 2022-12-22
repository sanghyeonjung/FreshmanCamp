package com.example.appplepi_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appplepi_project.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var ViewPagerAdapter: ViewPagerAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vpSample.adapter = ViewPagerAdapter(weatherList)


        val retrofit = Retrofit
            .Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RetrofitService::class.java)
    }

    companion object {
        val weatherList = arrayListOf(
            //예시 데이터 데이터 타입 : Weather
            Weather("1", "1", "1", "1", "1","1"),
            Weather("2", "1", "1", "1", "1","1"),
            Weather("3", "1", "1", "1", "1","1")
        )
    }
}