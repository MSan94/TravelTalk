package com.prj.traveltalk.util.adapter

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.prj.traveltalk.R
import com.prj.traveltalk.contract.LoginContract
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.math.sign

class MapKey : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        main()
    }
    fun main() {
        var packageInfo: PackageInfo = PackageInfo()
        try {
            packageInfo =
                packageManager.getPackageInfo("com.prj.traveltalk", PackageManager.GET_SIGNATURES)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        for (signature: Signature in packageInfo.signatures) {
            try {
                var md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KEY_HASH", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }
        }
    }
}