package com.dc.retrofitdemo.presentation_layer.ui.screen

import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dc.retrofitdemo.presentation_layer.RetroViewModel
import com.dc.retrofitdemo.presentation_layer.ui.componentes.ImagePicker
import com.dc.retrofitdemo.presentation_layer.ui.componentes.IndeterminateCircularIndicator

@Composable
fun HomeScreen(
    imageState: MutableState<Uri>,
    imageStateInBase64: MutableState<String>,
    retroViewModel: RetroViewModel,
    convertBitmapToBase64: (Bitmap) -> String
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        if (retroViewModel.loading.value) {
            IndeterminateCircularIndicator(retroViewModel.loading.value)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier.weight(0.9f),
            ) {
                if (retroViewModel.productInfo.value.outputs.isNotEmpty() && !retroViewModel.loading.value) {
                    LazyColumn(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        items(retroViewModel.productInfo.value.outputs.get(0).data.regions) {

                            it.data.concepts.forEach {
                                Card(
                                    modifier = Modifier
                                        .padding(4.dp),
                                    elevation = CardDefaults.cardElevation(
                                        defaultElevation = 4.dp
                                    ),
                                    border = BorderStroke(1.dp, Color.Magenta)
                                ) {
                                    Text(
                                        text = "Value (%) -> ${it.value}",
                                        modifier = Modifier.padding(8.dp),
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "Product Name -> ${it.name}",
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                            }
                        }

                    }
                }
            }

            Column(
                modifier = Modifier.weight(0.1f)
            ) {
                ImagePicker {

                    imageStateInBase64.value = convertBitmapToBase64(it)
                    imageState.value = Uri.parse(imageStateInBase64.value)
                    retroViewModel.getProductInfo(imageStateInBase64.value)
                }
            }
        }
    }

}