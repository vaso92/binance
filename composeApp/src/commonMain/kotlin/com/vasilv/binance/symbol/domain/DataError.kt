package com.vasilv.binance.symbol.domain

sealed interface DataError : Error {
    enum class Network : DataError {
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        SERIALIZATION,
        UNKNOWN
    }

    enum class Local : DataError {
        DISK_FULL
    }
}