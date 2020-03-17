package com.example.neostore.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.neostore.R
import com.example.neostore.api.RetrofitObject
import com.example.neostore.models.ForgotPwdResponse
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ForgetPwdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        //on login button click
        btn_forget_pwd_login.setOnClickListener {

            val forgotEmail = et_forgot_email.text.toString().trim()

            //validations
            if (forgotEmail.isEmpty()) {
                et_forgot_email.error = "Please Enter Email"
                et_forgot_email.requestFocus()
                return@setOnClickListener
            }

            Log.d(applicationContext.toString(),"Email is : "+et_forgot_email.text.toString())

            //retrofit api calling - forgot password
            RetrofitObject.retrofit.forgotUserPwd(forgotEmail)
                .enqueue(object : Callback<ForgotPwdResponse> {
                    override fun onFailure(call: Call<ForgotPwdResponse>, t: Throwable) {

                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onResponse(
                        call: Call<ForgotPwdResponse>,
                        response: Response<ForgotPwdResponse>
                    ) {

                        if (response.isSuccessful) {

                            //forgot pwd operation successful open login screen
                            val intent = Intent(applicationContext, LoginActivity::class.java)

                            Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_SHORT
                            ).show()

                            startActivity(intent)

                        }

                        //forgot pwd operation unsuccessful
                        else {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.user_msg,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                })
        }
    }
}
