package com.example.myapplication.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.adapter.RepositoryAdapter
import com.example.myapplication.data.repository.RepositoryData
import com.example.myapplication.databinding.FragmentRepositoryBinding

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
                RepositoryData("김혜인님의 repository", ""),
                RepositoryData("김효림님의 repository", "안녕하세요"),
                RepositoryData("이강민님의 repository", "이종찬입니다."),
                RepositoryData("최유림님의 repository", "안드로이드 공부 열심히"),
                RepositoryData("이종찬님의 repository", "전동킥보드 타지 마세요 여러분"),
                RepositoryData("도지", "화성 갈끄니까~~~"),
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}