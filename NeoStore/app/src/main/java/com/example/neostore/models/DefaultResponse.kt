package com.example.neostore.models

data class DefaultResponse(

    val status: Int,
    val data: UserDataInput,
    val message: String,
    val user_msg: String
)

//if you don't want to give same name as parameter then use it like....
//@SerializedName("error") & give any name to parameter