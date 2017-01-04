package com.polytech.guylplatteau

import java.util.*

object MessageHandler {
    var messages:ArrayList<Message> = ArrayList()

    fun add(message: Message) {
        messages.add(message)
        message.receiver.notify(message)
    }
}