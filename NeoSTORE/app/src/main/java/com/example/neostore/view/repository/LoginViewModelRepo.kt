package com.example.neostore.view.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.neostore.view.model.LoginResponse
import com.example.neostore.view.network.RetrofitClient
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModelRepo(val context: Context) : ViewModelProvider.NewInstanceFactory() {

    companion object {

         var loginRepository: LoginViewModelRepo? = null
         var mContext: Context? = null

        fun getInstance(context: Context): LoginViewModelRepo {

            mContext = context

            if (loginRepository == null) loginRepository = LoginViewModelRepo(context)
            return loginRepository!!
        }
    }

    fun loadLoginData(email: String, password: String): LiveData<LoginResponse?> {
        val loginData= MutableLiveData<LoginResponse?>()

        RetrofitClient.retrofit.loginUser(email, password)
            .enqueue(object : Callback<LoginResponse> {

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("onFailure", "" + t)
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    var res = response

                    if (res.body()?.status == 200) {
                        Toast.makeText(
                            context,
                            res.body()?.user_msg,
                            Toast.LENGTH_LONG
                        ).show()

                        val user=response.body()
                        loginData.value=user

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
        return loginData
    }

}
