package dev.trentmyr.models.sendgrid.templateData

import kotlinx.serialization.Serializable

/**
 * Required interface for [SendGridClient] to recognize as valid dynamic template data for an email.
 * Any model looking to inherent from this interface must be located in the same package!
 *
 * **Requires** the implementing model be annotated as [Serializable]
 */
@Serializable
sealed interface DynamicTemplateData