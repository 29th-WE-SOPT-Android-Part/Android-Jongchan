package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.FollowerData
import com.example.myapplication.adapter.FollowersAdapter
import com.example.myapplication.databinding.FragmentFollowersBinding

class FollowersFragment : Fragment() {
    private lateinit var followersAdapter: FollowersAdapter
    private var _binding: FragmentFollowersBinding? = null
    private val binding get() = _binding ?: error("FollowersBinding error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowersBinding.inflate(layoutInflater, container, false)
        initFollowersAdapter()
        return binding.root
    }

    private fun initFollowersAdapter() {
        followersAdapter = FollowersAdapter()
        binding.rvFollowers.adapter = followersAdapter
        followersAdapter.followerList.addAll(
            listOf(
                FollowerData("oxix", "비트코인 미리 사둘껄..."),
                FollowerData("Chan", "안녕하세요"),
                FollowerData("JONGCHAN", "이종찬입니다."),
                FollowerData("LEEJONGCHAN", "안드로이드 공부 열심히"),
                FollowerData("도지", "화성 갈끄니까~~~"),
                FollowerData("이종찬", "전동킥보드 타지 마세요 여러분"),
            )
        )
        followersAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}