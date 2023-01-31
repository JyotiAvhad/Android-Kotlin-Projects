package com.example.neostore.view.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neostore.view.model.LoginResponse
import com.example.neostore.view.repository.LoginViewModelRepo


class LoginViewModel(val context: Context) : ViewModel() {


    fun loginUser(email: String, password: String):LiveData<LoginResponse?> {
        return LoginViewModelRepo.getInstance(context).loadLoginData(email, password)
    }

    class Factory(val context: Context) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return LoginViewModel(context) as T
        }
    }

}
