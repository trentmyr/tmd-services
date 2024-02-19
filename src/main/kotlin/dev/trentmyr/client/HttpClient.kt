package dev.trentmyr.client

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

/**
 * An instance of [HttpClient] for making HTTP requests.
 */
val httpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        json()
    }
}
