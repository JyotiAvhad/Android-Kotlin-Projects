package com.example.neostore.view.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.neostore.R
import com.example.neostore.view.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var loginViewModel: LoginViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(
            this,
            LoginViewModel.Factory(this)
        ).get(LoginViewModel::class.java)


        btn_login.setOnClickListener {

            val email = ed_username.text.toString()
            val password = ed_password.text.toString()
            when {
                email.isEmpty() -> {
                    ed_username.error = "Please enter valid username"
                }
                password.isEmpty() -> {
                    ed_password.error = "Please enter correct password"
                }
                else -> {

                    loginViewModel?.loginUser(email, password)
                        ?.observe(this, Observer { userLogin ->
                            if(userLogin!=null){
                            Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT)
                                .show()
                                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Login Failed, please try again",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })

                }
            }

        }

        tv_signup.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}