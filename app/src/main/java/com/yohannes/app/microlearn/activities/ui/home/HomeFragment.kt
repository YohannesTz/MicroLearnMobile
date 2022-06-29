package com.yohannes.app.microlearn.activities.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import com.yohannes.app.microlearn.activities.SliderAdapter
import com.yohannes.app.microlearn.databinding.FragmentHomeBinding
import com.yohannes.app.microlearn.models.SliderItem

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
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}