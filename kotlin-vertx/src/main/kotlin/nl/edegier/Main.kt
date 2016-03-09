package nl.edegier

import io.vertx.core.AbstractVerticle
import io.vertx.kotlin.lang.DefaultVertx
import io.vertx.kotlin.lang.bodyJson
import io.vertx.kotlin.lang.httpServer
import io.vertx.kotlin.lang.json.object_

fun main(args: Array<String>) {
    DefaultVertx {
        deployVerticle(Receiver())
        deployVerticle(Sender())
        httpServer(8080) { request ->
            bodyJson {
                object_(
                        "message" to "Hello World!"
                )
            }
        }
    }
}

class Sender : AbstractVerticle() {
    override fun start(){
        vertx.setPeriodic(1000){
            vertx.eventBus().publish("test-channel","hello world")
        }
    }
}

class Receiver : AbstractVerticle() {
    override fun start() {
        vertx.eventBus().consumer<String>("test-channel"){
            println(it.body());
        }
    }
}