package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.FragmentOneBinding
import com.example.myapplication.view.SettingActivity
import com.google.android.material.tabs.TabLayoutMediator

class OneFragment : Fragment() {
    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding ?: error("OneFragment error")
    private lateinit var sampleViewPagerAdapter: SampleTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(layoutInflater, container, false)
        initAdapter()
        initTransactionEvent()
        binding.btFollower.isSelected = true
        initSetting()
        return binding.root
    }

    private fun initSetting() {
        binding.ivSetting.setOnClickListener {
            startActivity(Intent(requireActivity(), SettingActivity::class.java))
        }
    }

    private fun initAdapter() {
        val fragmentList = listOf<Fragment>(TabFragment1(), TabFragment2())
        sampleViewPagerAdapter = SampleTabViewPagerAdapter(this)
        sampleViewPagerAdapter.fragments.addAll(fragmentList)
        binding.vp2Sample.adapter = sampleViewPagerAdapter
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowersFragment()
        val repositoryFragment = RepositoryFragment()

        activity?.supportFragmentManager

        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.container, followerFragment)?.commit()

        binding.btFollower.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, followerFragment)?.commit()
            binding.btFollower.isSelected = true;
            binding.btRepository.isSelected = false;
        }

        binding.btRepository.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, repositoryFragment)?.commit()
            binding.btRepository.isSelected = true;
            binding.btFollower.isSelected = false;
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}