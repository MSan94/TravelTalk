package com.prj.traveltalk.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.prj.traveltalk.contract.HomeContract
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.databinding.FragmentHomeBinding
import com.prj.traveltalk.presenter.HomePresenter
import com.prj.traveltalk.presenter.LoginPresenter
import com.prj.traveltalk.util.adapter.ModelAdapter
import com.prj.traveltalk.util.model.ModelItem
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class HomeFragment() : Fragment() , HomeContract.View{

    override lateinit var presenter: HomeContract.Presenter
    val binding by lazy { FragmentHomeBinding.inflate(layoutInflater)}
    lateinit var modelList : MutableList<ModelItem>

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = HomePresenter()
        presenter.setView(this)
        presenter.setJob()
        presenter.getData()

        Log.d("TestSize", "프래그먼트 : ${modelList.size}")

        return binding.root
    }

    override fun init() {
    }


    override fun initRecyclerView() {
        val adapter = ModelAdapter()
        adapter.listData = modelList!!
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun getModelData() {
//        _motelList = presenter.sendData()
    }

    override fun getData() = runBlocking {
        val job = launch {
            presenter.getData()
        }
        job.join()
        job.cancel()
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.cancelJob()
    }

}