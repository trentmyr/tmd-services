package dev.trentmyr.models.sendgrid

import dev.trentmyr.models.sendgrid.templateData.DynamicTemplateData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * SendGrid Personalization data that can be provided to a [SendEmail] model
 */
@Serializable
data class Personalization(
    val to: List<Email>,
    @SerialName("dynamic_template_data") val dynamicTemplateData: DynamicTemplateData
)