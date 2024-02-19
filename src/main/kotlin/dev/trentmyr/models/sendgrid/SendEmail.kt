package dev.trentmyr.models.sendgrid

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Simple SendGrid mail/send model
 *
 * Only supports dynamic email templates, cannot send an email without a template defined on the SendGrid website
 */
@Serializable
data class SendEmail(
    val from: Email,
    @SerialName("template_id") val templateID: String,
    val personalizations: List<Personalization>
)