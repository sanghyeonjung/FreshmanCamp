package com.example.appplepi_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.appplepi_project.TodayFragment
import com.example.appplepi_project.TomorrowFragment
import com.example.appplepi_project.ViewPagerAdapter
import com.example.appplepi_project.YesterdayFragment
import com.example.appplepi_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var ViewPagerAdapter: ViewPagerAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        //mpager.(ViewPagerAdapter)

        initAdapter()
        setContentView(binding.root)
    }

    private fun initAdapter() {
        //Adapter 안에 ViewPager2 상에 띄워줄 fragmentList 생성
        val fragmentList = listOf( TodayFragment(),TomorrowFragment(), YesterdayFragment())
        //val mpager : ViewPager2 = findViewById(R.id.vp_sample)
        //mpager.setCurrentItem()


        //ViewPagerAdapter 초기화

        ViewPagerAdapter = ViewPagerAdapter(this)
        ViewPagerAdapter.fragments.addAll(fragmentList)


        //ViewPager2와 Adapter 연동
        binding.vpSample.adapter = ViewPagerAdapter
    }
}