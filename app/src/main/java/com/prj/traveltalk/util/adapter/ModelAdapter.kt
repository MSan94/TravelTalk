package com.prj.traveltalk.util.adapter

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.prj.traveltalk.R
import com.prj.traveltalk.databinding.ItemModelBinding
import com.prj.traveltalk.util.`interface`.OnItemClick
import com.prj.traveltalk.util.model.ModelItem
import com.prj.traveltalk.view.dialog.DetailFragmentDialog
import kotlin.coroutines.coroutineContext

class ModelAdapter(val onItemClick: OnItemClick) : RecyclerView.Adapter<Holder>(){
    var listData = mutableListOf<ModelItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Holder(binding,onItemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData[position]
        holder.setData(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(val binding : ItemModelBinding, val onItemClick: OnItemClick) : RecyclerView.ViewHolder(binding.root){

    fun setData(data : ModelItem){
        binding.textViewDataTitle.text = data.data_title
        binding.textViewCategoryName1.text = data.category_name1
        binding.textViewCategoryName3.text = data.category_name3
        binding.textViewTelno.text = data.telno
        binding.textViewUserAddress.text = data.user_address

        binding.imageViewJjim.setOnClickListener {
            binding.imageViewJjim.setImageResource(R.drawable.select_star)
        }


        binding.constraintLeft.setOnClickListener {
            onItemClick.onClick(data)
        }

    }
}