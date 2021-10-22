package com.example.sopt_week1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt_week1.databinding.ActivityHomeBinding
import com.example.sopt_week1.databinding.FragmentFollowersBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        initTransactionEvent()
        setContentView(binding.root)
    }
    private fun initTransactionEvent() {
        val followers = FollowersFragment()
        val repository = RepositoryFragment()
        supportFragmentManager.beginTransaction().add(R.id.container,followers).commit()
        binding.btFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,followers)
            transaction.commit()
        }
        binding.btRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,repository)
            transaction.commit()
        }
    }
}