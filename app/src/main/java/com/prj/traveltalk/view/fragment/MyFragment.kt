package com.prj.traveltalk.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.prj.traveltalk.contract.HomeContract
import com.prj.traveltalk.contract.MyContract
import com.prj.traveltalk.databinding.FragmentHomeBinding
import com.prj.traveltalk.databinding.FragmentMyBinding
import com.prj.traveltalk.presenter.MyPresnter
import com.prj.traveltalk.view.MainActivity

class MyFragment : Fragment() , MyContract.View{

    val binding by lazy { FragmentMyBinding.inflate(layoutInflater)}
    override lateinit var presenter: MyContract.Presenter
    var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter = MyPresnter()
        init()
        return binding.root
    }

    override fun init() {
        binding.btnLogOut.setOnClickListener {
            logoutEvent()
        }
    }

    override fun logoutEvent() {
        auth.signOut()
        Toast.makeText(activity,"로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
        val mActivity = activity as MainActivity
        mActivity.logoutEvent()
    }

}