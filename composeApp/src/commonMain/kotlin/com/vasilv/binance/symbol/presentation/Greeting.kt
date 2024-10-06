package com.vasilv.binance.symbol.presentation

import com.vasilv.binance.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}