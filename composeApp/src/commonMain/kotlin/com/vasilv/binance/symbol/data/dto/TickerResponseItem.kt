package com.vasilv.binance.symbol.data.dto

import kotlinx.serialization.Serializable

typealias TickerResponse = List<TickerResponseItem>

@Serializable
data class TickerResponseItem(
    val askPrice: String,
    val askQty: String,
    val bidPrice: String,
    val bidQty: String,
    val closeTime: Long,
    val count: Int,
    val firstId: Long,
    val highPrice: String,
    val lastId: Long,
    val lastPrice: String,
    val lastQty: String,
    val lowPrice: String,
    val openPrice: String,
    val openTime: Long,
    val prevClosePrice: String,
    val priceChange: String,
    val priceChangePercent: String,
    val quoteVolume: String,
    val symbol: String,
    val volume: String,
    val weightedAvgPrice: String
)