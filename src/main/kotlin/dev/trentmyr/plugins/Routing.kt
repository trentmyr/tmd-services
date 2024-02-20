package dev.trentmyr.plugins

import dev.trentmyr.client.SendGridClient
import dev.trentmyr.models.finaltouch.QuoteRequest
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*

internal val LOGGER = KtorSimpleLogger("plugins.Routing")
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello, World!")
        }
        finalTouchRoutes()
    }
}

fun Routing.finalTouchRoutes() {
    // TODO: require auth key from client in order to accept request
    route("/finalTouch") {
        post<QuoteRequest>("/sendQuoteRequest") { quoteRequest ->
            LOGGER.info("Processing incoming quote request with data: $quoteRequest")
            val response = SendGridClient.sendRequestForQuote(quoteRequest)
            call.respond(response.status)
        }
    }
}