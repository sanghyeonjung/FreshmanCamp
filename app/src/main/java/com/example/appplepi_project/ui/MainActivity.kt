package com.example.appplepi_project.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.appplepi_project.databinding.ActivityMainBinding
import com.example.appplepi_project.model.data.WeatherRes
import com.example.appplepi_project.model.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var yesterdayData: WeatherRes
    private lateinit var todayData: WeatherRes
    private lateinit var tomorrowData: WeatherRes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RetrofitService::class.java)

        service.getWeather(0)?.enqueue(object : Callback<WeatherRes> {
            override fun onResponse(call: Call<WeatherRes>, response: Response<WeatherRes>) {
                if (response.isSuccessful) {
                    val result: WeatherRes? = response.body()
                    todayData = WeatherRes(
                        result!!.humidity,
                        result.PM10,
                        result.PM2_5,
                        result.rain,
                        result.temp,
                        result.newsTitle,
                        result.newsContent,
                        result.dt
                    )
                    yesterdayData = WeatherRes(
                        result!!.humidity,
                        result.PM10,
                        result.PM2_5,
                        result.rain,
                        result.temp,
                        result.newsTitle,
                        result.newsContent,
                        result.dt
                    )
                    tomorrowData = WeatherRes(
                        result!!.humidity,
                        result.PM10,
                        result.PM2_5,
                        result.rain,
                        result.temp,
                        result.newsTitle,
                        result.newsContent,
                        result.dt
                    )
                    Log.d("GetWeatherData", result.toString())
                } else {
                    Log.d("GetWeatherData", "onResponse 실패")
                }
            }

            override fun onFailure(call: Call<WeatherRes>, t: Throwable) {
                Log.d("GetWeatherData", "onFailure 에러 : " + t.message.toString())
            }

        })

        val weatherList = arrayListOf(
            //예시 데이터 데이터 타입 : Weather
            yesterdayData,
            todayData,
            tomorrowData
//            WeatherRes("1", "1", "1", "1", "1", "기사 제목", "기사 내용", -1),
//            WeatherRes("2", "1", "1", "1", "1", "기사 제목", "기사 내용", 0),
//            WeatherRes("3", "1", "1", "1", "1", "기사 제목", "기사 내용", 1)
        )

        binding.vpSample.adapter = ViewPagerAdapter(weatherList)
    }

    companion object {
        const val BaseUrl = ""
    }
}