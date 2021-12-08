package com.example.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationComponent1Binding
import com.example.myapplication.databinding.FragmentNavigationComponent3Binding

class NavigationComponent3 : Fragment() {
    private var _binding: FragmentNavigationComponent3Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationComponent3Binding.inflate(layoutInflater)
        binding.tvAbout.text = "SOPTHub를\n시작해볼까요?"
        binding.btnNext.setOnClickListener {
            requireActivity().finish()
        }
        return binding.root
    }


}