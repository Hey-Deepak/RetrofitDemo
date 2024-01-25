package com.dc.retrofitdemo.presentation_layer.ui.model

data class Model(
    val app_id: String,
    val check_consents: List<Any>,
    val created_at: String,
    val id: String,
    val languages: List<Any>,
    val languages_full: List<Any>,
    val model_type_id: String,
    val model_version: ModelVersion,
    val modified_at: String,
    val name: String,
    val toolkits: List<Any>,
    val use_cases: List<Any>,
    val user_id: String,
    val visibility: VisibilityX,
    val workflow_recommended: Boolean
)