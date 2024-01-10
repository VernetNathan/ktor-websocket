package com.vernet.hive

import com.google.gson.*
import com.hivemq.client.mqtt.datatypes.MqttQos

import com.hivemq.client.mqtt.mqtt3.Mqtt3AsyncClient

import com.hivemq.client.mqtt.mqtt3.Mqtt3Client


import com.google.gson.Gson
import com.hivemq.client.mqtt.mqtt3.message.connect.connack.Mqtt3ConnAck
import com.hivemq.client.mqtt.mqtt3.message.publish.Mqtt3Publish
import com.hivemq.client.mqtt.mqtt3.message.subscribe.suback.Mqtt3SubAck
import com.vernet.config.*
import com.vernet.gestion.Requettes
import com.vernet.modeles.CapteurTemp
import java.net.InetSocketAddress
import java.util.*
import java.util.function.BiConsumer
import java.util.function.Consumer

class Hive {
    private var connectOK = false
    private lateinit var client: Mqtt3AsyncClient
    private lateinit var capteurTemp: CapteurTemp

    init {
        run()
    }


    private fun run() {
        client = Mqtt3Client.builder()
            .serverAddress(InetSocketAddress.createUnresolved(SERVER_URI, PORT))
            .sslWithDefaultConfig()
            .buildAsync()
        connect()

    }

    private fun connect() {
        client!!.connectWith()
            .simpleAuth()
            .username(USER_NAME)
            .password(PASSWORD)
            .applySimpleAuth()
            .send()
            .whenComplete((BiConsumer<Mqtt3ConnAck, Throwable> { mqtt3ConnAck: Mqtt3ConnAck?, throwable: Throwable? ->
                if (throwable != null) println("Echec de connexion")
                else {
                    println("Connexion établie")
                    connectOK = true
                }
            }))
        subscribe()
    }

    fun subscribe() {
        client!!.subscribeWith()
            .topicFilter(TOPIC)
            .callback(Consumer<Mqtt3Publish> { mqtt3Publish: Mqtt3Publish ->
                //RÉCEPTION
                val value = String(mqtt3Publish.payloadAsBytes)
                val gson = Gson()
                capteurTemp = gson.fromJson(value, CapteurTemp::class.java)
                println(value)
                var requette = Requettes()
                requette.ajouterTemp(base64String(capteurTemp.uplinkMessage.frmPayload).toFloat())
            })
            .send()
            .whenComplete((BiConsumer<Mqtt3SubAck, Throwable> { mqtt3SubAck: Mqtt3SubAck?, throwable: Throwable? ->
                if (throwable != null) println("Echec de souscription")
                else {
                    println("Souscription établie")
                    connectOK = true
                }
            }))
    }

    fun base64String(payload: String?): Float {
        val decodedBytes = Base64.getDecoder().decode(payload)
        for (i in decodedBytes.indices) {
            print(decodedBytes[i].toString() + " ")
        }

        var temp: String = decodedBytes[18].toString() + "." + decodedBytes[17].toString()
        return temp.toFloat()
    }
}
