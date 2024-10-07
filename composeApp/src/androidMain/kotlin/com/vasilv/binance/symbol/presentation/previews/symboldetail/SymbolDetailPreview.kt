package com.vasilv.binance.symbol.presentation.previews.symboldetail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.presentation.symboldetail.SymbolDetailContent

@Composable
@Preview
fun SymbolDetailPreview() {
    MaterialTheme {
        Surface {
            SymbolDetailContent(
                symbol = Symbol(
                    askPrice = "diam",
                    askQty = "intellegebat",
                    bidPrice = "eirmod",
                    bidQty = "sadipscing",
                    closeTime = 5245,
                    count = 3706,
                    firstId = 9283,
                    highPrice = "autem",
                    lastId = 5772,
                    lastPrice = "latine",
                    lastQty = "sea",
                    lowPrice = "detracto",
                    openPrice = "suas",
                    openTime = 1630,
                    prevClosePrice = "habitasse",
                    priceChange = "vocibus",
                    priceChangePercent = "lobortis",
                    quoteVolume = "sanctus",
                    symbol = "reprehendunt",
                    volume = "iisque",
                    weightedAvgPrice = "mollis"
                )
            )
        }
    }
}