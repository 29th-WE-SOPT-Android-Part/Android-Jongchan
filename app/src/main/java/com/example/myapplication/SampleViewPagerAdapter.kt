package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SampleViewPagerAdapter(fragmentActivity: MainActivity) : FragmentStateAdapter(fragmentActivity) {
    val fragments = mutableListOf<Fragment>()

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}