package com.dc.retrofitdemo.data_layer.remote

import com.dc.retrofitdemo.presentation_layer.ui.model.Product
import com.dc.retrofitdemo.presentation_layer.ui.model.request_model.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ProductApi {
    @Headers("Authorization: Key b71202ab2e26423387b235df5f8fdbe9")
    @POST("outputs/")
    suspend fun getProductInfo(@Body body: RequestBody): Response<Product>

}