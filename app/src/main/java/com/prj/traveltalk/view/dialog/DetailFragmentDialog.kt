package com.prj.traveltalk.view.dialog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.naver.maps.map.MapView
import com.prj.traveltalk.databinding.DialogDetailBinding

class DetailFragmentDialog : DialogFragment() {
    val binding by lazy { DialogDetailBinding.inflate(layoutInflater) }
    lateinit var mapView : MapView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCancelable = true
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var bundle : Bundle? = arguments
        binding.title.text = if(bundle?.getString("title") == null || bundle?.getString("title").equals("")) "정보 없음" else bundle?.getString("title")
        binding.category.text = if(bundle?.getString("category") == null || bundle?.getString("category").equals("")) "정보 없음" else bundle?.getString("category")
        binding.gugun.text = if(bundle?.getString("gugun") == null || bundle?.getString("gugun").equals("")) "정보 없음" else bundle?.getString("gugun")
        binding.address.text = if(bundle?.getString("address") == null || bundle?.getString("address").equals("")) "정보 없음" else bundle?.getString("address")
        binding.tel.text = if(bundle?.getString("telno") == null || bundle?.getString("telno").equals("")) "정보 없음" else bundle?.getString("telno")
        binding.homepage.text = if(bundle?.getString("homepage") == null || bundle?.getString("homepage").equals("")) "정보 없음" else bundle?.getString("homepage")
        mapView = binding.naverMap
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.setLayout(750,1000)
    }

}