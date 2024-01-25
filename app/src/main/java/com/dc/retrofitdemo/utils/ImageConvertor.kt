package com.dc.retrofitdemo.utils

import android.graphics.Bitmap
import android.net.Uri
import android.util.Base64
import com.dc.retrofitdemo.presentation_layer.MainActivity
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

fun MainActivity.convertImageToBase64(selectedImageUri: Uri): String? {
    return try {
        val inputStream: InputStream? = contentResolver.openInputStream(selectedImageUri)
        val bytes = inputStream?.readBytes()
        inputStream?.close()

        Base64.encodeToString(bytes, Base64.DEFAULT)
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}
fun MainActivity.convertBitmapToBase64(bm: Bitmap): String {
    val baos = ByteArrayOutputStream()
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    val b = baos.toByteArray()
    return Base64.encodeToString(b, Base64.DEFAULT)
}