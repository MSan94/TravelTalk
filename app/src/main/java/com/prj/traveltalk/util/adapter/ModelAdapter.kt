package com.prj.traveltalk.util.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.prj.traveltalk.R
import com.prj.traveltalk.databinding.ItemModelBinding
import com.prj.traveltalk.util.model.ModelItem

class ModelAdapter() : RecyclerView.Adapter<Holder>(){

    var listData = mutableListOf<ModelItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(val binding : ItemModelBinding) : RecyclerView.ViewHolder(binding.root){
    fun setData(data : ModelItem){
        binding.textViewDataTitle.text = data.data_title
        binding.textViewCategoryName1.text = data.category_name1
        binding.textViewCategoryName3.text = data.category_name3
        binding.textViewTelno.text = data.telno
        binding.textViewUserAddress.text = data.user_address
    }
}