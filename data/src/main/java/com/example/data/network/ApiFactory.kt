package com.example.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object ApiFactory {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/DariaOzmitel/b7f6c0916c4e0a52b42ba4c0dd23fbd7/raw/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}