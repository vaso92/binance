package com.vasilv.binance.symbol.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SymbolsTable")
data class SymbolEntity(
    val cacheTime: Long,
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
    @PrimaryKey
    val symbol: String,
    val volume: String,
    val weightedAvgPrice: String
)