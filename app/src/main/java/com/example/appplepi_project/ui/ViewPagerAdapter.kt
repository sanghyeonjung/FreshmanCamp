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
        view.findViewById<TextView>(R.id.tv_main_humidityvalue).text = list[position].humidity
        view.findViewById<TextView>(R.id.tv_main_finedustvalue).text = list[position].dust
        view.findViewById<TextView>(R.id.tv_main_sunvalue).text = list[position].uv
        view.findViewById<TextView>(R.id.tv_main_rainvalue).text = list[position].rain
        view.findViewById<TextView>(R.id.tv_main_airtempvalue).text = list[position].temp
        view.findViewById<TextView>(R.id.tv_first_news1).text = list[position].newsTitle
        view.findViewById<TextView>(R.id.tv_second_news1).text = list[position].newsContent
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