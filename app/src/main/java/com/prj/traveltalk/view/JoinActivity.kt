package com.prj.traveltalk.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.prj.traveltalk.contract.JoinContract
import com.prj.traveltalk.databinding.ActivityJoinBinding
import com.prj.traveltalk.presenter.JoinPresenter
import com.prj.traveltalk.util.model.UserDto
import kotlinx.coroutines.coroutineScope

class JoinActivity : AppCompatActivity(), JoinContract.View {
    private val binding by lazy { ActivityJoinBinding.inflate(layoutInflater) }
    override lateinit var presenter: JoinContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = JoinPresenter()
        presenter.setView(this)
        init()
    }

    override fun init() {
        binding.btnCheckNick.setOnClickListener {
            clickEvent("1")
        }
        binding.btnSignIn.setOnClickListener {
            clickEvent("2")
        }
        binding.btnCancel.setOnClickListener {
            clickEvent("3")
        }
    }

    /** 정보 전송 **/
    override fun sendUserData(model: UserDto) {
        presenter.singIn(model)
    }

    /** 회원가입 성공 여부 **/
    override fun resultSignIn(result : String){
        when (result) {
            "1" -> {
                Toast.makeText(this, "회원가입 성공... 로그인페이지로 이동합니다.", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            "2" -> {
                Toast.makeText(this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show()
            }
            "3" ->{
                Toast.makeText(this, "장애가 발생하였습니다. 관리자에게 문의해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /** 버튼 이벤트 **/
    private fun clickEvent(type: String) {
        when (type) {
            "1" -> {
            }
            "2" -> {
                when (true) {
                    /** 아이디 검증 **/
                    binding.editTextInputId.text.isEmpty() or (binding.editTextInputId.text.length < 5) -> {
                        Toast.makeText(this, "아이디는 5자 이상으로 작성해주세요.", Toast.LENGTH_SHORT).show()
                        return
                    }
                    /** 패스워드 검증 **/
                    binding.editTextInputPw.text.isEmpty() or (binding.editTextInputPw.text.length < 5) -> {
                        Toast.makeText(this, "비밀번호는 5자 이상으로 작성해주세요.", Toast.LENGTH_SHORT).show()
                        return
                    }
                    /** 패스워드 확인 검증 **/
                    binding.editTextInputPwCheck.text.isEmpty() -> {
                        Toast.makeText(this, "비밀번호 확인칸을 작성해주세요.", Toast.LENGTH_SHORT).show()
                        return
                    }
                    /** 패스워드 & 패스워드 검사 일치 여부 검증 **/
                    binding.editTextInputPw.text.toString() != binding.editTextInputPwCheck.text.toString() -> {
                        Toast.makeText(this, "비밀번호가 서로 다르게 작성되었습니다.", Toast.LENGTH_SHORT).show()
                        return
                    }
                    /** 닉네임 검증 **/
                    binding.editTextInputNickName.text.isEmpty() or (binding.editTextInputNickName.text.length < 3) -> {
                        Toast.makeText(this, "별명은 3글자 이상으로 작성해주세요.", Toast.LENGTH_SHORT).show()
                        return
                    }
                    /** 닉네임 사용여부 검증 **/

                    /** 가입 진행 **/
                    else -> {
                        val model: UserDto = UserDto(
                            binding.editTextInputId.text.toString().trim(),
                            binding.editTextInputPw.text.toString().trim(),
                            binding.editTextInputNickName.text.toString().trim()
                        )
                        sendUserData(model)
                    }
                }
            }
            "3" -> {
                Toast.makeText(this, "3번", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}