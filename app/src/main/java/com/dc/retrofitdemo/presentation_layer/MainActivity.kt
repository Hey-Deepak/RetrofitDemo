package com.dc.retrofitdemo.presentation_layer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dc.retrofitdemo.presentation_layer.ui.theme.RetrofitDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RetrofitDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val retroViewModel: RetroViewModel by viewModels()

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = retroViewModel.quoteState.value.toString())

                        Button(onClick = {

                            retroViewModel.getQuoteResult()

                        }) {
                            Text(text = "Fetch Result")
                        }

                        Spacer(modifier = Modifier.size(10.dp))

                        Text(text = retroViewModel.ramdomQuoteResultState.value.toString())

                        Button(onClick = {

                            retroViewModel.getRandomQuoteResult()

                        }) {
                            Text(text = "Fetch Random Result")
                        }
                    }



                }
            }
        }
    }
}

