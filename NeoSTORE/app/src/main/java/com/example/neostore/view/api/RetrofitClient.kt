package com.example.neostore.view.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://staging.php-dev.in:8844/trainingapp/api/users/"

    val retrofit: ApiInterface by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiInterface::class.java)
    }


//    fun getInstance(): Retrofit {
//        var mHttpLoggingInterceptor = HttpLoggingInterceptor()
//            .setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        var mOkHttpClient = OkHttpClient
//            .Builder()
//            .addInterceptor(mHttpLoggingInterceptor)
//            .build()
//
//
//        var retrofit: Retrofit = retrofit2.Retrofit.Builder()
//            .baseUrl("https://reqres.in")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(mOkHttpClient)
//            .build()
//        return retrofit
//    }
}