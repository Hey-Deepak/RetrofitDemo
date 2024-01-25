package com.dc.retrofitdemo.presentation_layer.ui.model

data class Region(
    val `data`: DataX = DataX(),
    val id: String = "",
    val region_info: RegionInfo = RegionInfo(),
    val value: Double = 0.0
)