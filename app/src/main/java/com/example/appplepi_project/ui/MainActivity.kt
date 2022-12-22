package com.example.appplepi_project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appplepi_project.databinding.ActivityMainBinding
import com.example.appplepi_project.model.data.WeatherRes
import com.example.appplepi_project.model.remote.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

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
            WeatherRes("1", "1", "1", "1", "1", "기사 제목", "기사 내용"),
            WeatherRes("2", "1", "1", "1", "1", "기사 제목", "기사 내용"),
            WeatherRes("3", "1", "1", "1", "1", "기사 제목", "기사 내용")
        )
    }
}