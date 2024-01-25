package com.dc.retrofitdemo.presentation_layer.ui.model

data class ModelVersion(
    val app_id: String,
    val created_at: String,
    val id: String,
    val metadata: Metadata,
    val status: StatusX,
    val user_id: String,
    val visibility: VisibilityX
)