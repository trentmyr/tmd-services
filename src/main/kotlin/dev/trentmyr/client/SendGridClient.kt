package dev.trentmyr.client

import dev.trentmyr.models.finaltouch.QuoteRequest
import dev.trentmyr.models.sendgrid.Email
import dev.trentmyr.models.sendgrid.Personalization
import dev.trentmyr.models.sendgrid.SendEmail
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.util.logging.*

/**
 * Very simple SendGrid client, only supports one send operation confined to a single dynamic template
 */
object SendGridClient {
//    private val LOGGER = KtorSimpleLogger("client.SendGridClient")
    suspend fun sendRequestForQuote(quoteRequest: QuoteRequest): HttpResponse {
        return httpClient.post {
            url("https://api.sendgrid.com/v3/mail/send")
            headers {
                // TODO: do not hardcode api key
                bearerAuth("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")
            }
            contentType(ContentType.Application.Json)
            setBody(requestForQuotePostBody(quoteRequest))
        }
    }

    private fun requestForQuotePostBody(quoteRequest: QuoteRequest): SendEmail {
        return SendEmail(
            from = Email(
                email = "no-reply@trentmyr.dev",
                name = "TMD Services"
            ),
            templateID = "d-d3c1e03840c74200a7bc1d172d2b1e70",
            personalizations = listOf(
                Personalization(
                    to = listOf(
                        // TODO: change to leads@ address
                        Email("Trent Meyer", "self@trentmyr.dev")
                    ),
                    dynamicTemplateData = quoteRequest
                )
            )
        )
    }

}