package com.example.neostore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //on forget pwd click
        tv_login_forget_pwd.setOnClickListener {

            val intent = Intent(this, ForgetPwdActivity::class.java)
            startActivity(intent)
        }

    }
}
