package com.example.sopt_week1

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt_week1.databinding.FollowerListBinding

class FollowersAdapter : RecyclerView.Adapter<FollowersAdapter.FollowersViewHolder>() {
    val followerList = mutableListOf<FollowerData>()

    interface ItemClickListener {
        fun onClick(view: View, position: Int)
    }

    private lateinit var itemClickListener: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    class FollowersViewHolder(private val binding: FollowerListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: FollowerData) {
            binding.tvTitle.text = data.title
            binding.tvText.text = data.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val binding = FollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size
}