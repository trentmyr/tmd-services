package dev.trentmyr.plugins

import dev.trentmyr.models.finaltouch.QuoteRequest
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.logging.*

internal val LOGGER = KtorSimpleLogger("plugins.Routing")
fun Application.configureRouting() {
    routing {
//        get("/") {
//            call.respondText("Hello World!")
//        }
        finalTouchRoutes()
    }
}


fun Routing.finalTouchRoutes() {
    route("/finalTouch") {
        post<QuoteRequest>("/sendQuoteRequest") {
            LOGGER.info(it.toString())
        }
    }
}