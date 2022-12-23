package com.example.appplepi_project.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.appplepi_project.R
import com.example.appplepi_project.model.data.WeatherRes

class ViewPagerAdapter(private val list: ArrayList<WeatherRes>) : PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.layout_weather, container, false)

        //findViewById 로 변수에 저장
        val humidity = view.findViewById<TextView>(R.id.tv_main_humidityvalue) // 습도
        val PM10 = view.findViewById<TextView>(R.id.tv_main_PM10value) // 미세먼지
        val PM2_5 = view.findViewById<TextView>(R.id.tv_main_PM2_5value) // 자외선
        val rain = view.findViewById<TextView>(R.id.tv_main_rainvalue) // 강수확률
        val temp = view.findViewById<TextView>(R.id.tv_main_tempvalue) // 기온
        val newsTitle = view.findViewById<TextView>(R.id.tv_main_newsTitle) // 뉴스 제목
        val newsContent = view.findViewById<TextView>(R.id.tv_main_newsContent) // 뉴스 내용

        val dateText = view.findViewById<TextView>(R.id.tv_main_weather) // 오늘/내일/어제 날씨
        val dateNum = view.findViewById<TextView>(R.id.tv_main_date) // 날짜

        humidity.text = list[position].humidity
        PM10.text = list[position].PM10
        PM2_5.text = list[position].PM2_5
        rain.text = list[position].rain
        temp.text = list[position].temp
        newsTitle.text = list[position].newsTitle
        newsContent.text = list[position].newsContent

        if(list[position].dt == -1 )
            dateText.text = "어제 날씨"
        else if(list[position].dt == 0)
            dateText.text = "오늘 날씨"
        else if(list[position].dt == 1)
            dateText.text = "내일 날씨"

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

}