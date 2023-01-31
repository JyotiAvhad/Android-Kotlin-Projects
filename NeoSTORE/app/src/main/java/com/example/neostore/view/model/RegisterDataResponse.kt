package com.example.neostore.view.model

data class RegisterDataResponse(

    val status : Int,
    val data : RegisterUserDataInput,
    val message : String,
    val user_msg : String

)

