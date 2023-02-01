package com.example.neostore.view.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.neostore.view.model.LoginResponse
import com.example.neostore.view.model.RegisterResponse
import com.example.neostore.view.repository.LoginViewModelRepo
import com.example.neostore.view.repository.RegisterViewModelRepo


class RegisterViewModel(val context: Context) : ViewModel() {

    fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        pwd: String,
        confirmPwd: String
    ): LiveData<RegisterResponse?> {

        return RegisterViewModelRepo.getInstance(context).loadRegisterData(
            firstName,
            lastName,
            email,
            pwd,
            confirmPwd
        )
    }

    class Factory(val context: Context) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return RegisterViewModel(context) as T
        }
    }

}
