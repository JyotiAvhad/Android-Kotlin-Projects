package com.example.neostore.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.neostore.R
import com.example.neostore.api.RetrofitObject
import com.example.neostore.models.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //on add or login new user btn click
        btn_login_user.setOnClickListener {


            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)


//            val userName = et_username.text.toString().trim()
//            val pwd = et_pwd.text.toString().trim()
//
//            //validations
//            if (userName.isEmpty()) {
//                et_username.error = "Email Required"
//                et_username.requestFocus()
//                return@setOnClickListener
//            }
//
//            if (pwd.isEmpty()) {
//                et_pwd.error = "Password Required"
//                et_pwd.requestFocus()
//                return@setOnClickListener
//            }
//
//            Log.d(applicationContext.toString(), "Username is : " + et_username.text.toString())
//            Log.d(applicationContext.toString(), "Password is : " + et_pwd.text.toString())
//
//            //retrofit api calling - login
//            RetrofitObject.retrofit.loginUser(userName, pwd)
//                .enqueue(object : Callback<LoginResponse> {
//
//                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//
////                        Toast.makeText(applicationContext, "User login unsuccessful.", Toast.LENGTH_SHORT).show()
//                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT)
//                            .show()
//
//                    }
//
//                    override fun onResponse(
//                        call: Call<LoginResponse>,
//                        response: Response<LoginResponse>
//                    ) {
//
//                        if (response.isSuccessful) {
//
//                            //login successful open home screen
//                            val intent = Intent(applicationContext, HomeActivity::class.java)
//
//                            Toast.makeText(
//                                    applicationContext,
//                            response.body()?.message,
//                            Toast.LENGTH_SHORT
//                            ).show()
//
//                            startActivity(intent)
//
//                        }
//
//                        //login unsuccessful
//                        else {
//                            Toast.makeText(
//                                applicationContext,
//                                response.body()?.message,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//                })
        }

        //on forget pwd click
        tv_login_forget_pwd.setOnClickListener {

            val intent = Intent(this, ForgetPwdActivity::class.java)
            startActivity(intent)
        }

        //on add or register new user btn click
        btn_register_user.setOnClickListener {

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
