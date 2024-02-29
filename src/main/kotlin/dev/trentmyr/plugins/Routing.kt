package dev.trentmyr.plugins

import dev.trentmyr.client.SendGridClient
import dev.trentmyr.models.sendgrid.templateData.QuoteRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*

internal val LOGGER = KtorSimpleLogger("plugins.Routing")
fun Application.configureRouting() {
    routing {
        finalTouchRoutes()
    }
}

fun Routing.finalTouchRoutes() {
    // TODO: require auth key from client in order to accept request
    route("/finalTouch") {
        route("/sendQuoteRequest") {
            options {
                call.respond(HttpStatusCode.OK)
            }
            post<QuoteRequest> { quoteRequest ->
//                LOGGER.info("Processing incoming quote request with data: $quoteRequest")
                val response = SendGridClient.sendRequestForQuote(quoteRequest)
                call.respond(response.status)
            }
        }
    }
}