package com.example.myapplication.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.view.Activity.SignInActivity
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
            startActivity(Intent(requireActivity(), SignInActivity::class.java))
        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}