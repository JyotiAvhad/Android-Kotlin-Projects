package com.example.neostore.models

data class RegisterResponse(

    val status : Int,
    val data : RegisterUserDataInput,
    val message : String,
    val user_msg : String

)

//if you don't want to give same name as parameter then use it like....
//@SerializedName("error") & give any name to parameter