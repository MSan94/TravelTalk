package com.prj.traveltalk.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prj.traveltalk.databinding.FragmentHomeBinding
import com.prj.traveltalk.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    val binding by lazy { FragmentInfoBinding.inflate(layoutInflater)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

}