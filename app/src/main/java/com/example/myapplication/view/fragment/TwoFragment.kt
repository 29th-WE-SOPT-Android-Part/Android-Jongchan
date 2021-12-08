package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.adapter.SampleTabViewPagerAdapter
import com.example.myapplication.databinding.FragmentTwoBinding
import com.google.android.material.tabs.TabLayoutMediator

class TwoFragment : Fragment() {
    private var _binding: FragmentTwoBinding? = null
    private val binding get() = _binding ?: error("OneFragment error")
    private lateinit var sampleViewPagerAdapter: SampleTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoBinding.inflate(layoutInflater, container, false)
        initAdapter()
        initTabLayout()
        return binding.root
    }

    private fun initAdapter() {
        val fragmentList = listOf<Fragment>(TabFragment1(), TabFragment2())
        sampleViewPagerAdapter = SampleTabViewPagerAdapter(this)
        sampleViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vp2Sample.adapter = sampleViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로잉", "팔로워")
        TabLayoutMediator(binding.tab, binding.vp2Sample) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}