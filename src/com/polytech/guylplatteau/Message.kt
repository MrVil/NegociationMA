package com.polytech.guylplatteau

class Message (val performatif: Performatif, val emmiter: Negociator, val receiver: Negociator, val previous: Message? = null, val price: Double? = null){

    override fun toString(): String {
        return "$performatif:$emmiter:$receiver:$price"
    }
}