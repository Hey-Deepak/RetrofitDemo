package com.dc.retrofitdemo.presentation_layer.ui.model

data class BoundingBox(
    val bottom_row: Double = 0.0,
    val left_col: Double = 0.0,
    val right_col: Double = 0.0,
    val top_row: Double = 0.0
)