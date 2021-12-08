package com.example.myapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNavigationComponent1Binding

class NavigationComponent1 : Fragment() {
    private var _binding: FragmentNavigationComponent1Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationComponent1Binding.inflate(layoutInflater)
        Glide.with(this)
            .load("https://assets.gadgets360cdn.com/img/crypto/dogecoin-og-logo.png")
            .error(R.drawable.img_github)
            .into(binding.ivImage)
        binding.tvAbout.text = "SOPTHub에 오신걸 \n환영합니다."
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.navComp1_to_navComp2)
        }
        return binding.root
    }
}