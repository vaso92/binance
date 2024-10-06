package com.vasilv.binance.symbol.presentation.previews.symbollist

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.presentation.symbollist.SymbolListContent

@Composable
@Preview
private fun SymbolListPreview() {
    MaterialTheme {
        Surface {
             SymbolListContent(
                isLoading = false,
                items = listOf(
                    Symbol(
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
                    ), Symbol(
                        askPrice = "ut",
                        askQty = "aptent",
                        bidPrice = "dignissim",
                        bidQty = "persius",
                        closeTime = 5517,
                        count = 8589,
                        firstId = 8039,
                        highPrice = "leo",
                        lastId = 3364,
                        lastPrice = "accusata",
                        lastQty = "dicant",
                        lowPrice = "tale",
                        openPrice = "amet",
                        openTime = 3417,
                        prevClosePrice = "alienum",
                        priceChange = "commune",
                        priceChangePercent = "adolescens",
                        quoteVolume = "his",
                        symbol = "dicunt",
                        volume = "gubergren",
                        weightedAvgPrice = "nominavi"
                    )
                )
            )
        }
    }
}