package com.vernet

import com.vernet.gestion.Connexion
import com.vernet.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
val environment = applicationEngineEnvironment {
    connector {
        port=8080
        host="0.0.0.0"
    }
    module{

        configureSerialization()
        configureSockets()
        configureRouting()
    }
}
embeddedServer(Netty, environment)
.start(wait = true)
}

