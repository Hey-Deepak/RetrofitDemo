package com.dc.retrofitdemo.presentation_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dc.retrofitdemo.data_layer.QuoteApi
import com.dc.retrofitdemo.data_layer.RetrofitHelper
import com.dc.retrofitdemo.presentation_layer.ui.model.Quotes
import com.dc.retrofitdemo.presentation_layer.ui.model.Result
import kotlinx.coroutines.launch

class RetroViewModel: ViewModel() {

    val retro = RetrofitHelper.retrofit.create(QuoteApi::class.java)

    var quoteState = mutableStateOf(Quotes(0,0,0, emptyList(), 0, 0 ))
    var ramdomQuoteResultState = mutableStateOf(Result("","","","","","",0, emptyList()))

    fun getQuoteResult(){
        viewModelScope.launch {
            try {
                if (retro.getQuotes().body() != null) {
                    quoteState.value = retro.getQuotes().body()!!
                }

            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
    fun getRandomQuoteResult(){
        viewModelScope.launch {
            try {
                if (retro.getRandomQuotes().body() != null) {
                    ramdomQuoteResultState.value = retro.getRandomQuotes().body()!!
                }

            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

}