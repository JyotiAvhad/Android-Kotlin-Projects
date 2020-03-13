package com.example.neostore.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.neostore.R
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

        //on add or register new user btn click
        btn_register_user.setOnClickListener {

            val username=et_username.text.toString().trim()
            val pwd=et_pwd.text.toString().trim()

            if (username.isEmpty()){
                et_username.error="Email Required"
                et_username.requestFocus()
                return@setOnClickListener
            }

            if (pwd.isEmpty()){
                et_pwd.error="Password Required"
                et_pwd.requestFocus()
                return@setOnClickListener
            }

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        //on add or login new user btn click
        btn_login_user.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

}
