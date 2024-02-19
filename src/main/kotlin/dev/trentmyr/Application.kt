package dev.trentmyr

import dev.trentmyr.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        module()
    }
    .start(wait = true)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureRouting()
}
