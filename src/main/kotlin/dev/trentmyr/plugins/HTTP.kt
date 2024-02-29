package dev.trentmyr.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.defaultheaders.*

fun Application.configureHTTP() {
    install(CORS) {
        allowMethod(HttpMethod.Post)
        allowHeader(HttpHeaders.ContentType)
        allowHost("finaltouchcincy")
        // Local testing only!
//        anyHost()
    }
    install(DefaultHeaders) {
        header("X-Engine", "Ktor") // will send this header with each response
    }
}
