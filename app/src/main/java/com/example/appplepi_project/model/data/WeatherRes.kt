package com.example.appplepi_project.model.data

data class WeatherRes (
        val humidity : String, // 습도
        val dust : String, // 미세먼지
        val uv : String, // 자외선
        val rain : String, // 강수 확률
        val temp : String, // 기온
        val newsTitle : String, // 뉴스제목
        val newsContent : String // 뉴스내용
)