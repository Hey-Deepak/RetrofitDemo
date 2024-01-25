package com.dc.retrofitdemo.data_layer.remote

import com.dc.retrofitdemo.presentation_layer.ui.model.Product
import com.dc.retrofitdemo.presentation_layer.ui.model.request_model.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

object RetrofitHelper {

    val retrofitApi = Retrofit.Builder()
        .baseUrl("https://api.clarifai.com/v2/users/clarifai/apps/main/models/general-image-detection/versions/1580bb1932594c93b7e2e04456af7c6f/")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()

}

