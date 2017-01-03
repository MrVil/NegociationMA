package com.polytech.guylplatteau

class Message (val performatif: Performatif, val emmiter: Negociator, val receiver: Negociator, val previous: Message, val price: Int){

    override fun toString(): String {
        return "$performatif:$emmiter:$receiver:$price"
    }
}