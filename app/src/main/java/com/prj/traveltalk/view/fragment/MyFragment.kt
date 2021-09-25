package com.prj.traveltalk.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
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
        userCheck()
        return binding.root
    }

    override fun init() {
        binding.btnLogOut.setOnClickListener {
            logoutEvent()
        }
    }

    /** 로그아웃 **/
    override fun logoutEvent() {
        auth.signOut()
        Toast.makeText(activity,"로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
        val mActivity = activity as MainActivity
        mActivity.logoutEvent()
    }

    /** 로그인후 접속인지 체크 실행 **/
    override fun userCheck() {
        val currentUser : FirebaseUser? = auth?.currentUser
        resultLogin(currentUser)
    }

    /** 로그인 세션 검색( 게스트 인지 회원인지 여부 체크 ) **/
    override fun resultLogin(currentUser: FirebaseUser?) {
        when(currentUser){
            null -> {
                binding.textViewUserInfo.text = "안녕하세요. Guest로 접속하셨습니다."
                binding.btnLogOut.text = "종료"
                binding.button1.isEnabled = false
                binding.button2.isEnabled = false
                binding.button3.isEnabled = false
            }
            else -> {
                binding.textViewUserInfo.text = "안녕하세요. ${auth.currentUser?.email}님"
                binding.btnLogOut.text = "로그아웃"
                binding.button1.isEnabled = true
                binding.button2.isEnabled = true
                binding.button3.isEnabled = true
            }
        }
    }

}