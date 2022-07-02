package com.yohannes.app.microlearn.activities.fragments.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.yohannes.app.microlearn.BounceEdgeEffectFactory
import com.yohannes.app.microlearn.activities.CourseAdapter
import com.yohannes.app.microlearn.activities.SliderAdapter
import com.yohannes.app.microlearn.databinding.FragmentHomeBinding
import com.yohannes.app.microlearn.models.*

/**
 *  This file was taken from this repo. check out the code here:- https://github.com/juanmeanwhile/BounceRecyclerView/blob/master/app/recyclerview_bounce/src/main/java/com/meanwhile/recyclerview_bounce/BounceEdgeEffectFactory.kt
 *  and the full medium article here:- https://medium.com/androidxx/say-hi-to-the-bounce-effect-in-recyclerview-without-headaches-589c157d0a92
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val sliderAdapter = SliderAdapter(activity!!)
        val sliderItems = ArrayList<SliderItem>()
        sliderItems.add(SliderItem("A simple Image", "https://picsum.photos/seed/picsum/200/200"))
        sliderItems.add(SliderItem("A simple second Image", "https://picsum.photos/seed/picsum/200/200"))
        sliderItems.add(SliderItem("A simple third Image", "https://picsum.photos/seed/picsum/200/200"))
        sliderItems.add(SliderItem("A simple fourth Image", "https://picsum.photos/seed/picsum/200/200"))
        sliderItems.add(SliderItem("A simple fifth Image", "https://picsum.photos/seed/picsum/200/200"))

        sliderAdapter.renewItems(sliderItems)

        binding.imageSlider.setSliderAdapter(sliderAdapter)
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        binding.imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        binding.imageSlider.indicatorSelectedColor = Color.WHITE
        binding.imageSlider.indicatorUnselectedColor = Color.GRAY
        binding.imageSlider.scrollTimeInSec = 4 //set scroll delay in seconds :
        binding.imageSlider.startAutoCycle()

        val videoList = arrayListOf(
            VideoItem("How to cook Macaroni", "Chapter 1", "https://picsum.photos/seed/picsum/200/200"),
            VideoItem("How to cook Endomi", "Chapter 2", "https://picsum.photos/seed/picsum/200/200"),
            VideoItem("How to cook Misir", "Chapter 3", "https://picsum.photos/seed/picsum/200/200")
        )

        val courseItems = ArrayList<Course>()
        val chapters = arrayListOf(Chapter("Basics of cooking", "2h", arrayListOf("asdfasdfa", "sdfadf", "asdfasdf")))
        courseItems.add(Course("How to cook", "2h",
            "https://loremflickr.com/400/250/cook", "https://picsum.photos/seed/picsum/200/200",
            Instructor("Rahel", "Bekele", "https://picsum.photos/seed/picsum/200/200", "Professional Cooker", "2021", "qweer1233", false, 2000),
            "Aug 2021",
            videoList,
            arrayListOf("sfsdfdsf", "asdfasdfa", "asdfsdfasd"),
            45,
            10,
            4.5f,
            chapters
        ))
        courseItems.add(Course("How to cook", "2h",
            "https://loremflickr.com/400/250/food", "https://picsum.photos/seed/picsum/200/200",
            Instructor("Rahel", "Bekele", "https://picsum.photos/seed/picsum/200/200", "Professional Cooker", "2021", "qweer1233", false, 2000),
            "Aug 2021",
            videoList,
            arrayListOf("sfsdfdsf", "asdfasdfa", "asdfsdfasd"),
            45,
            10,
            4.0f,
            chapters
        ))
        courseItems.add(Course("How to cook", "3h",
            "https://loremflickr.com/400/250/eating", "https://picsum.photos/seed/picsum/200/200",
            Instructor("Rahel", "Bekele", "https://picsum.photos/seed/picsum/400/200", "Professional Cooker", "2021", "qweer1233", false, 2000),
            "Aug 2021",
            videoList,
            arrayListOf("sfsdfdsf", "asdfasdfa", "asdfsdfasd"),
            45,
            10,
            3.4f,
            chapters
        ))

        val courseAdapter = CourseAdapter(activity!!, courseItems)
        binding.topCoursesRecyclerview.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        binding.topCoursesRecyclerview.adapter = courseAdapter
        binding.topCoursesRecyclerview.edgeEffectFactory = BounceEdgeEffectFactory()

        binding.coursesVerticalRecyclerview.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        binding.coursesVerticalRecyclerview.adapter = courseAdapter
        binding.coursesVerticalRecyclerview.edgeEffectFactory = BounceEdgeEffectFactory()

        binding.coursesSelfdevelopmentRecyclerview.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        binding.coursesSelfdevelopmentRecyclerview.adapter = courseAdapter
        binding.coursesSelfdevelopmentRecyclerview.edgeEffectFactory = BounceEdgeEffectFactory()

        binding.coursesHealthRecyclerview.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
        binding.coursesHealthRecyclerview.adapter = courseAdapter
        binding.coursesHealthRecyclerview.edgeEffectFactory = BounceEdgeEffectFactory()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}