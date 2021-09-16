package com.prj.traveltalk.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prj.traveltalk.databinding.ActivityJoinBinding

class JoinActivity : AppCompatActivity() {
    val binding by lazy { ActivityJoinBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}