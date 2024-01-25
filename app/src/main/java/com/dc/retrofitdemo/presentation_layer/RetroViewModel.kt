package com.dc.retrofitdemo.presentation_layer

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dc.retrofitdemo.data_layer.remote.ProductApi
import com.dc.retrofitdemo.data_layer.remote.RetrofitHelper
import com.dc.retrofitdemo.presentation_layer.ui.model.Product
import com.dc.retrofitdemo.presentation_layer.ui.model.StatusXX
import com.dc.retrofitdemo.presentation_layer.ui.model.request_model.Data
import com.dc.retrofitdemo.presentation_layer.ui.model.request_model.Image
import com.dc.retrofitdemo.presentation_layer.ui.model.request_model.Input
import com.dc.retrofitdemo.presentation_layer.ui.model.request_model.RequestBody
import kotlinx.coroutines.launch

class RetroViewModel : ViewModel() {

    val produtApi = RetrofitHelper.retrofitApi.create(ProductApi::class.java)

    val loading = mutableStateOf(false)

    var productInfo = mutableStateOf(Product(emptyList(), StatusXX()))

    fun getProductInfo(imageStateInBase64: String) {
        loading.value = true;
        viewModelScope.launch {
            try {
                productInfo.value = produtApi.getProductInfo(
                    RequestBody(
                        listOf(
                            Input(
                                Data(
                                    Image(
                                        imageStateInBase64
                                    )
                                )
                            )
                        )
                    )
                ).body()!!

                loading.value = false

                Log.e("xyzabc", "ProductInfo.value (VM) ->  ${productInfo.value}")

            } catch (e: Exception) {
                loading.value = false
                e.printStackTrace()
            }
        }
    }

}