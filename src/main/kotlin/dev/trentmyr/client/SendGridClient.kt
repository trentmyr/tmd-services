package dev.trentmyr.client

import dev.trentmyr.models.sendgrid.templateData.QuoteRequest
import dev.trentmyr.models.sendgrid.templateData.DynamicTemplateData
import dev.trentmyr.models.sendgrid.Email
import dev.trentmyr.models.sendgrid.Personalization
import dev.trentmyr.models.sendgrid.SendEmail
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Very simple SendGrid client, only supports one send operation confined to a single dynamic template
 */
object SendGridClient {
    /** SendGrid API key with send permissions */
    private val apiSendKey = System.getenv("SG_APIKEY_SEND")
//    private val LOGGER = KtorSimpleLogger("client.SendGridClient")

    /** All emails will be sent from this [Email] */
    private val emailSource = Email(
        email = "no-reply@trentmyr.dev",
        name = "TMD Services"
    )

    /** Send a Final Touch request for quote email */
    suspend fun sendRequestForQuote(quoteRequest: QuoteRequest): HttpResponse {
        return httpClient.mailSend(
            dynamicTemplateEmail(
                templateID = "d-d3c1e03840c74200a7bc1d172d2b1e70",
                templateData = quoteRequest,
                recipient = Email("Final Touch Leads", "leads@netorgft14864482.onmicrosoft.com")
            )
        )
    }

    /**
     * Helper function to send an email via SendGrid's /mail/send endpoint
     *
     * **Requires** that the body be some derivative of the [SendEmail] model
     */
    private suspend inline fun <reified T> HttpClient.mailSend(body: T): HttpResponse {
        return post {
            url("https://api.sendgrid.com/v3/mail/send")
            headers {
                bearerAuth(apiSendKey)
            }
            contentType(ContentType.Application.Json)
            setBody(body)
        }
    }

    /**
     * Generate a SendEmail model with the provided dynamic template data
     */
    private fun dynamicTemplateEmail(
        templateID: String,
        templateData: DynamicTemplateData,
        recipient: Email
    ): SendEmail {
        return SendEmail(
            from = emailSource,
            templateID = templateID,
            personalizations = listOf(
                Personalization(
                    to = listOf(recipient),
                    dynamicTemplateData = templateData
                )
            )
        )
    }

}