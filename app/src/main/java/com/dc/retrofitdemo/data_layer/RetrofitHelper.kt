package com.dc.retrofitdemo.data_layer

import com.dc.retrofitdemo.presentation_layer.ui.model.Quotes
import com.dc.retrofitdemo.presentation_layer.ui.model.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitHelper {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.quotable.io/")
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build()

}

interface QuoteApi {

    @GET("quotes")
    suspend fun getQuotes(): Response<Quotes>

    @GET("random")
    suspend fun getRandomQuotes(): Response<Result>

}