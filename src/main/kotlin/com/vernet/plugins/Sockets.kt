package com.vernet.plugins

import com.vernet.gestion.Requettes
import com.vernet.modele.Valeurs
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.delay
import java.time.Duration

fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    routing {
        webSocket("/ws/valeur/{id}") { // websocketSession
            var oldValue: String ?= null
            var requettes : Requettes = Requettes()
            while (true){
                var id = call.parameters["id"]?.toIntOrNull()
                if (id == null){
                    send(Frame.Text("Erreur id"))
                    return@webSocket
                }
                else{
                    val valeur:Valeurs?= requettes.lireLesValeurs(id)
                    if (valeur == null){
                        send(Frame.Text("Pas de valeurs"))
                    }
                    else {
                        if (oldValue != valeur.toString()){
                            oldValue = valeur.toString()
                            send(Frame.Text(valeur.toString()))
                        }

                    }
                }
                delay(1000)
            }
        }
        webSocket("/ws") {
            while (true){
                send(Frame.Text("Bonjour"))
                delay(1000)
            }
        }
    }
}
