package com.dc.retrofitdemo.presentation_layer

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import com.dc.retrofitdemo.presentation_layer.ui.screen.HomeScreen
import com.dc.retrofitdemo.presentation_layer.ui.theme.RetrofitDemoTheme
import com.dc.retrofitdemo.utils.convertBitmapToBase64

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageState = mutableStateOf(Uri.parse(""));
        val imageStateInBase64 = mutableStateOf("");

        val retroViewModel: RetroViewModel by viewModels()
        setContent {
            RetrofitDemoTheme {
                // A surface container using the 'background' color from the theme
                HomeScreen(imageState, imageStateInBase64, retroViewModel){
                    convertBitmapToBase64(it)
                }
            }
        }
    }

}




