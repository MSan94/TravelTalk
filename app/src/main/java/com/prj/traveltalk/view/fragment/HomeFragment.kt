package com.prj.traveltalk.view.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.prj.traveltalk.contract.HomeContract
import com.prj.traveltalk.contract.LoginContract
import com.prj.traveltalk.databinding.FragmentHomeBinding
import com.prj.traveltalk.presenter.HomePresenter
import com.prj.traveltalk.presenter.LoginPresenter
import com.prj.traveltalk.util.`interface`.OnItemClick
import com.prj.traveltalk.util.adapter.ModelAdapter
import com.prj.traveltalk.util.model.ModelItem
import com.prj.traveltalk.view.dialog.DetailFragmentDialog
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.concurrent.thread

class HomeFragment() : Fragment() , HomeContract.View, OnItemClick{


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
        getData()
        initRecyclerView()

        binding.btnSelect.setOnClickListener {
            Log.d("DialogTest","클릭")
            getCategoryList()
        }


        return binding.root
    }

    override fun init() {
    }


    override fun initRecyclerView() {
        val adapter = ModelAdapter(this)
        adapter.listData = modelList
        thread(start = true) {
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun getData() {
        presenter.getData()
        Log.d("TestView", "끝남")
        modelList = presenter.returnList()
    }

    fun getCategoryList(){
        var dataArr = arrayOf("전체","민박","펜션","호텔")
        var builder = AlertDialog.Builder(context)
        builder.setTitle("카테고리를 선택해주세요.")
        builder.setNegativeButton("취소", null)
        var listener = DialogInterface.OnClickListener { _, which ->
            binding.btnSelect.text = "${dataArr[which]}"
        }
        builder.setItems(dataArr, listener)
        builder.show()
    }

    /** 어댑터 아이템 클릭시 호출 이벤트트 **/
    override fun onClick(data : ModelItem) {
        showDialog(data)
    }

    fun showDialog(data : ModelItem){

        val dialog : DialogFragment = DetailFragmentDialog()
        fragmentManager?.let {
            val args : Bundle = Bundle()
            args.putString("title",data.data_title)
            args.putString("category",data.category_name1)
            args.putString("gugun",data.category_name3)
            args.putString("address",data.user_address)
            args.putString("telno",data.telno)
            args.putString("homepage",data.user_homepage)
            dialog.arguments = args
            dialog.show(it,"dialog")
        }

    }

}