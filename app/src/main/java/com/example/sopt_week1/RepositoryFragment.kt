package com.example.sopt_week1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sopt_week1.databinding.FragmentFollowersBinding
import com.example.sopt_week1.databinding.FragmentRepositoryBinding

class RepositoryFragment : Fragment() {
    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding ?: error("RepositoryBinding error")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        initRepositoryAdapter()
        return binding.root
    }

    private fun initRepositoryAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.rvRepository.adapter = repositoryAdapter
        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData("oxix", "비트코인 미리 사둘껄..."),
                RepositoryData("Chan", "안녕하세요"),
                RepositoryData("JONGCHAN", "이종찬입니다."),
                RepositoryData("LEEJONGCHAN", "안드로이드 공부 열심히"),
                RepositoryData("도지", "화성 갈끄니까~~~"),
                RepositoryData("이종찬", "전동킥보드 타지 마세요 여러분"),
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}