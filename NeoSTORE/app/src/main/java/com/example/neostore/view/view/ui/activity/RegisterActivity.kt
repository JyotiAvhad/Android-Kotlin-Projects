package com.example.neostore.view.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.neostore.R
import com.example.neostore.view.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_login.ed_password
import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private var registerViewModel: RegisterViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerViewModel = ViewModelProviders.of(
            this,
            RegisterViewModel.Factory(this)
        ).get(RegisterViewModel::class.java)


        btn_register.setOnClickListener {

            val firstName = ed_firstName.text.toString().trim()
            val lastName = ed_lastName.text.toString().trim()
            val email = ed_email.text.toString().trim()
            val pwd = ed_password.text.toString().trim()
            val confirmPwd = ed_confirm_password.text.toString().trim()

            when {
                firstName.isEmpty() -> {
                    ed_firstName.error = "Please enter first name"
                }
                lastName.isEmpty() -> {
                    ed_lastName.error = "Please enter last name"
                }
                email.isEmpty() -> {
                    ed_email.error = "Please enter email"
                }
                pwd.isEmpty() -> {
                    ed_password.error = "Please enter password"
                }
                confirmPwd.isEmpty() -> {
                    ed_confirm_password.error = "Please enter confirm password"
                }
                else -> {
                    registerViewModel?.registerUser(firstName, lastName, email, pwd, confirmPwd)
                        ?.observe(this, Observer { userRegister ->
                            if (userRegister != null) {
                                Toast.makeText(
                                    applicationContext,
                                    "Registration Successful",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    applicationContext,
                                    "Registration Failed, please try again",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                }
            }

//            if (firstName.isEmpty()) {
//                ed_firstName.error = "Please Enter First Name"
//                ed_firstName.requestFocus()
//                return@setOnClickListener
//            }
//
//            if (lastName.isEmpty()) {
//                ed_lastName.error = "Please Enter Last Name"
//                ed_lastName.requestFocus()
//                return@setOnClickListener
//            }
//
//            if (email.isEmpty()) {
//                ed_email.error = "Please Enter Email"
//                ed_email.requestFocus()
//
//                if (!isValidString(email)) {
//                    Toast.makeText(
//                        application,
//                        "Email have to be in proper format",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//                return@setOnClickListener
//            }
//
//            if (pwd.isEmpty()) {
//                ed_password.error = "Please Enter Password"
//                ed_password.requestFocus()
//
//                if (pwd.length <= 5) {
//                    Toast.makeText(
//                        application,
//                        "Password should more than 6 letters or digits",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//                return@setOnClickListener
//            }
//
//            if (confirmPwd.isEmpty()) {
//                ed_confirm_password.error = "Please Confirm Password"
//                ed_confirm_password.requestFocus()
//
//                if (confirmPwd.length <= 5) {
//                    Toast.makeText(
//                        application,
//                        "Confirm Password should match the password",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//                return@setOnClickListener
//            }

            Log.d(applicationContext.toString(), "first name is : " + ed_firstName.text.toString())
            Log.d(applicationContext.toString(), "last name is : " + ed_lastName.text.toString())
            Log.d(applicationContext.toString(), "email is : " + ed_email.text.toString())
            Log.d(applicationContext.toString(), "password is : " + ed_password.text.toString())
            Log.d(
                applicationContext.toString(),
                "confirm password is : " + ed_confirm_password.text.toString()
            )

//            //retrofit api calling - register
//            RetrofitClient.retrofit
//                .registerUser(
//                    firstName,
//                    lastName,
//                    email,
//                    pwd,
//                    confirmPwd,
//                    gender = "M",
//                    phone_no = "9999999990"
//                )
//                .enqueue(object : Callback<RegisterResponse> {
//                    override fun onResponse(
//                        call: Call<RegisterResponse>,
//                        response: Response<RegisterResponse>
//                    ) {
//
//                        var res = response
//                        //registration successful
//                        if (response.isSuccessful && response.body() != null) {
//                            Toast.makeText(
//                                applicationContext,
//                                res.body()?.message,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                            Log.d("TAG", "onResponse success: " + res.body()?.message)
//
//
//                            val intent =
//                                Intent(this@RegisterActivity, LoginActivity::class.java)
//                            startActivity(intent)
//                            finish()
//                            Log.d("TAG", "onResponse: #######################")
//                        }
//
//
//                        //registration unsuccessful
//                        else {
//                            Toast.makeText(
//                                applicationContext,
//                                response.body()?.message,
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                        Log.d("TAG", "onResponse unsuccessful: " + response.body()?.message)
//                    }
//
//                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
//                        Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_SHORT)
//                            .show()
//                        Log.d("TAG", "onFailure:${t.message.toString()} ")
//                    }
//
//                })

        }


    }


    val EMAIL_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isValidString(email: String): Boolean {
        return EMAIL_PATTERN.matcher(email).matches()
    }


}