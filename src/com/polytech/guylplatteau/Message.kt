package com.polytech.guylplatteau

class Message (val performatif: Performatif, val emmiter: Negociator, val previous: Message, val price: Int){


    override fun toString(): String {
        return "$performatif:$emmiter:${previous.hashCode()}:$price"
    }

    override fun hashCode(): Int {
        var result = performatif.hashCode()
        result = 31 * result + emmiter.hashCode()
        result = 31 * result + previous.hashCode()
        result = 31 * result + price
        return result
    }
}