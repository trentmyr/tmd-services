package dev.trentmyr.models.finaltouch

import kotlinx.serialization.Serializable

@Serializable
data class QuoteRequest(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val selections: List<String>,
    val description: String
)
