package com.example.neostore.api

import com.example.neostore.models.DefaultResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    fun loginUser(

        @Field("email") email: String,
        @Field("password") password: String

    ): Call<DefaultResponse>
}