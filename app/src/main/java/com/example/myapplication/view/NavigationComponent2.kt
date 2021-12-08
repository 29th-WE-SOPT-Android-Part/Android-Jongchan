package com.example.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationComponent1Binding
import com.example.myapplication.databinding.FragmentNavigationComponent2Binding

class NavigationComponent2 : Fragment() {
    private var _binding: FragmentNavigationComponent2Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationComponent2Binding.inflate(layoutInflater)
        binding.tvAbout.text = "SOPTHub에서 즐거운 시간\n보내시길 바랍니다."
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.navComp2_to_navComp3)
        }
        return binding.root
    }

}