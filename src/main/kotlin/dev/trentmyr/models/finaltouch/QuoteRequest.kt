package dev.trentmyr.models.finaltouch

import kotlinx.serialization.Serializable

/**
 * SendGrid dynamic template data for the "request for quote" email template
 */
@Serializable
data class QuoteRequest(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val selections: List<String>,
    val description: String
)