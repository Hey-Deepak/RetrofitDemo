package com.dc.retrofitdemo.presentation_layer.ui.componentes

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ImagePicker(onImageSelected: (Bitmap) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) {
        onImageSelected(it!!)
    }

    Button(
        onClick = {
            launcher.launch()
        }
    ) {
        Text("Select Image")
    }
}