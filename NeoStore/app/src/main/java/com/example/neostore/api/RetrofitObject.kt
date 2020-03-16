package com.example.neostore.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//use same as retrofit singleton class/instance in java
object RetrofitObject {

    private const val BASE_URL = "http://staging.php-dev.in:8844/trainingapp/api/users/"

    val instance: ApiInterface by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiInterface::class.java)
    }

}