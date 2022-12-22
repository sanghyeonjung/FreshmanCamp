package com.example.appplepi_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TomorrowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TomorrowFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_tomorrow, container, false)
        val date : TextView = view.findViewById(R.id.tv_main_date)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM월 dd일")
        val formatted = current.format(formatter)


        val currentDate = Date()
        val calendar: Calendar = Calendar.getInstance()
        calendar.setTime(currentDate)
        val dayOfWeekNumber: Int = calendar.get(Calendar.DAY_OF_WEEK)
        var day = ""

        when (dayOfWeekNumber) {
            1 -> day = "월요일"
            2 -> day = "화요일"
            3 -> day = "수요일"
            4 -> day = "목요일"
            5 -> day = "금요일"
            6 -> day = "토요일"
            7 -> day = "일요일"
        }
        date.setText(formatted+" "+day)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tomorrow, container, false)

        // Inflate the layout for this fragment
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TomorrowFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TomorrowFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}