package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SampleViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initAdapter()
        initBottomNavi()
        setContentView(binding.root)
    }

    private fun initAdapter() {
        val fragmentList = listOf(OneFragment(), TwoFragment(), ThreeFragment())
        adapter = SampleViewPagerAdapter(this)
        adapter.fragments.addAll(fragmentList)
        binding.vp2Page.adapter = adapter
    }

    private fun initBottomNavi() {
        binding.vp2Page.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bnvSample.menu.getItem(position)
            }
        })
        binding.bnvSample.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_user -> {
                    binding.vp2Page.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_home -> {
                    binding.vp2Page.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.vp2Page.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }
//    private fun initTransactionEvent() {
//        val followers = FollowersFragment()
//        val repository = RepositoryFragment()
//        supportFragmentManager.beginTransaction().add(R.id.container, followers).commit()
//        binding.btFollower.setOnClickListener {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, followers)
//            transaction.commit()
//        }
//        binding.btRepository.setOnClickListener {
//            val transaction = supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.container, repository)
//            transaction.commit()
//        }
//    }
    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }
}