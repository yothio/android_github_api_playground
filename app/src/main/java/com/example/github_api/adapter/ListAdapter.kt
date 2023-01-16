package com.example.github_api.adapter


import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.github_api.R
import com.example.github_api.network.Repository


class GithubRecycleViewAdapter(list: List<Repository>) :
    RecyclerView.Adapter<GithubViewHolder>() {
    private val list: List<Repository>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return GithubViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.titleView.setText(list[position].name)
        holder.detailView.setText(list[position].language)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    init {
        this.list = list
    }
}