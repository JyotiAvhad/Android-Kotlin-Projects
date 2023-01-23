package com.example.neostore.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.neostore.R
import com.example.neostore.view.api.ApiInterface
import com.example.neostore.view.api.RegisterDataResponse
import com.example.neostore.view.api.RetrofitClient
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        //on register btn click
        btn_register.setOnClickListener {

            val firstName = ed_firstName.text.toString().trim()
            val lastName = ed_lastName.text.toString().trim()
            val email = ed_email.text.toString().trim()
            val pwd = ed_password.text.toString().trim()
            val confirmPwd = ed_confirm_password.text.toString().trim()


            if (firstName.isEmpty()) {
                ed_firstName.error = "Please Enter First Name"
                ed_firstName.requestFocus()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                ed_lastName.error = "Please Enter Last Name"
                ed_lastName.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                ed_email.error = "Please Enter Email"
                ed_email.requestFocus()
                return@setOnClickListener
            }

            if (pwd.isEmpty()) {
                ed_password.error = "Please Enter Password"
                ed_password.requestFocus()
                return@setOnClickListener
            }

            if (confirmPwd.isEmpty()) {
                ed_confirm_password.error = "Please Confirm Password"
                ed_confirm_password.requestFocus()
                return@setOnClickListener
            }

            Log.d(applicationContext.toString(), "first name is : " + ed_firstName.text.toString())
            Log.d(applicationContext.toString(), "last name is : " + ed_lastName.text.toString())
            Log.d(applicationContext.toString(), "email is : " + ed_email.text.toString())
            Log.d(applicationContext.toString(), "password is : " + ed_password.text.toString())
            Log.d(
                applicationContext.toString(),
                "confirm password is : " + ed_confirm_password.text.toString()
            )

            //retrofit api calling - register
            RetrofitClient.retrofit
                .registerUser(firstName, lastName, email, pwd, confirmPwd)
                .enqueue(object : Callback<RegisterDataResponse> {
                    override fun onResponse(
                        call: Call<RegisterDataResponse>,
                        response: Response<RegisterDataResponse>
                    ) {

                        //registration successful
                        if (response.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_SHORT
                            ).show()

                            Log.d("TAG", "onResponse success: "+ response.body()?.message)
                            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                            Log.d("TAG", "onResponse: #######################")
                        }

                        //registration unsuccessful
                        else {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        Log.d("TAG", "onResponse unsuccessful: "+  response.body()?.message,)
                    }

                    override fun onFailure(call: Call<RegisterDataResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT)
                            .show()

                        Log.d("TAG", "onFailure: ")
                    }

                })

        }


    }

}