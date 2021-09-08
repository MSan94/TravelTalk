package com.prj.traveltalk.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prj.traveltalk.R
import com.prj.traveltalk.contract.MainContract
import com.prj.traveltalk.databinding.ActivityMainBinding
import com.prj.traveltalk.presenter.LoginPresenter
import com.prj.traveltalk.presenter.MainPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity() : AppCompatActivity() , MainContract.View{
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = MainPresenter()
        presenter.setView(this)
        presenter.setJob()
        presenter.getData()

    }
    override fun init() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.cancelJob()
    }
}