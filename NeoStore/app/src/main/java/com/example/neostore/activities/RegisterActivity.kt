package com.example.neostore.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.neostore.R
import com.example.neostore.api.RetrofitObject
import com.example.neostore.models.RegisterResponse
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.custom_toolbar_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //on back img view click
        iv_back_register.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //on register btn click
        btn_register.setOnClickListener {

            val firstName = et_firstName.text.toString().trim()
            val lastName = et_lastName.text.toString().trim()
            val email = et_email.text.toString().trim()
            val rPwd = et_reg_pwd.text.toString().trim()
            val confirmPwd = et_confirmPwd.text.toString().trim()
            val gender = radioGroup.checkedRadioButtonId.toString().trim()
            val phoneNumber = et_phoneNumber.text.toString().trim()

            if (firstName.isEmpty()) {
                et_firstName.error = "Please Enter First Name"
                et_firstName.requestFocus()
                return@setOnClickListener
            }

            if (lastName.isEmpty()) {
                et_lastName.error = "Please Enter Last Name"
                et_lastName.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                et_email.error = "Please Enter Email"
                et_email.requestFocus()
                return@setOnClickListener
            }

            if (rPwd.isEmpty()) {
                et_reg_pwd.error = "Please Enter Password"
                et_reg_pwd.requestFocus()
                return@setOnClickListener
            }

            if (confirmPwd.isEmpty()) {
                et_confirmPwd.error = "Please Confirm Password"
                et_confirmPwd.requestFocus()
                return@setOnClickListener
            }

            if (phoneNumber.isEmpty()) {
                et_phoneNumber.error = "PPlease Enter Phone Number"
                et_phoneNumber.requestFocus()
                return@setOnClickListener
            }

            Log.d(applicationContext.toString(), "first name is : " + et_firstName.text.toString())
            Log.d(applicationContext.toString(), "last name is : " + et_lastName.text.toString())
            Log.d(applicationContext.toString(), "email is : " + et_email.text.toString())
            Log.d(applicationContext.toString(), "password is : " + et_reg_pwd.text.toString())
            Log.d(
                applicationContext.toString(),
                "confirm password is : " + et_confirmPwd.text.toString()
            )
            Log.d(
                applicationContext.toString(),
                "phone number is : " + et_phoneNumber.text.toString()
            )
            Log.d(
                applicationContext.toString(),
                "selected gender is : " + radioGroup.checkedRadioButtonId.toString()
            )

            //retrofit api calling - register
            RetrofitObject.retrofit.registerUser(
                    firstName,
                    lastName,
                    email,
                    rPwd,
                    confirmPwd,
                    gender,
                    phoneNumber
                )
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {

                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {

                        //registration successful
                        if (response.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        //registration unsuccessful
                        else {
                            Toast.makeText(
                                applicationContext,
                                response.body()?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                })
        }
    }
}

