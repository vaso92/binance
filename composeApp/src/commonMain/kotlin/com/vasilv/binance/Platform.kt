package com.vasilv.binance

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform