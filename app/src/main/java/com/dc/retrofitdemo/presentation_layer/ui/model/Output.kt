package com.dc.retrofitdemo.presentation_layer.ui.model

data class Output(
    val created_at: String,
    val `data`: Data,
    val id: String,
    val input: Input,
    val model: Model,
    val status: StatusX
)