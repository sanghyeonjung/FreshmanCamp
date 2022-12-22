package com.example.appplepi_project.model.data

data class Weather (
        //습도, 미세먼지, 자외선 지수, 강수 확률, 기온, 온도, 뉴스기사 String 형으로
        val humidity : String,
        val dust : String,
        val uv : String,
        val rain : String,
        val temp : String,
        val news : String
)