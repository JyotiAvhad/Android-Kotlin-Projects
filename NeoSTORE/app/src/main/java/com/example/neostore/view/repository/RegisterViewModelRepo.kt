package com.example.neostore.view.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.neostore.view.model.RegisterResponse
import com.example.neostore.view.network.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModelRepo(val context: Context) : ViewModelProvider.NewInstanceFactory() {

    companion object {

        var registerRepository: RegisterViewModelRepo? = null
        var mContext: Context? = null

        fun getInstance(context: Context): RegisterViewModelRepo {

            mContext = context

            if (registerRepository == null) registerRepository = RegisterViewModelRepo(context)
            return registerRepository!!
        }
    }

    fun loadRegisterData(
        firstName: String,
        lastName: String,
        email: String,
        pwd: String,
        confirmPwd: String
    ): LiveData<RegisterResponse?> {

        val registerData = MutableLiveData<RegisterResponse?>()

        RetrofitClient.retrofit.registerUser(
            firstName,
            lastName,
            email,
            pwd,
            confirmPwd,
            gender = "F",
            phone_no = "9999999990"
        ).enqueue(object : Callback<RegisterResponse> {

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Log.d("onFailure", "" + t)
                }

                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    var res = response

                    if (res.body()?.status == 200) {
                        Toast.makeText(
                            context,
                            res.body()?.user_msg,
                            Toast.LENGTH_LONG
                        ).show()

                        val user = response.body()
                        registerData.value = user

                    } else {
                        try {
                            val jObjError =
                                JSONObject(response.errorBody()!!.string())
                            Toast.makeText(
                                context,
                                jObjError.getString("user_msg"),
                                Toast.LENGTH_LONG
                            ).show()
                        } catch (e: Exception) {
                            Log.e("error", e.message.toString())
                        }
                    }
                }
            })
        return registerData
    }

}
