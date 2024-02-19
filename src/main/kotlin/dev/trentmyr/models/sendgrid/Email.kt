package dev.trentmyr.models.sendgrid

import kotlinx.serialization.Serializable

/**
 * SendGrid sender or recipient
 */
@Serializable
data class Email(val name: String, val email: String)