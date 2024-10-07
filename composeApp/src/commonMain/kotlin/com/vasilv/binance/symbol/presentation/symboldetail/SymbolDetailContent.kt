package com.vasilv.binance.symbol.presentation.symboldetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.presentation.constants.Paddings

@Composable
fun SymbolDetailContent(symbol: Symbol) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Paddings.SIDE_PADDING)
            .verticalScroll(scrollState)
    ) {
        NamedPropertyColumn("askPrice", symbol.askPrice)
        NamedPropertyColumn("askQty", symbol.askQty)
        NamedPropertyColumn("bidPrice", symbol.bidPrice)
        NamedPropertyColumn("bidQty", symbol.bidQty)
        NamedPropertyColumn("closeTime", symbol.closeTime.toString())
        NamedPropertyColumn("count", symbol.count.toString())
        NamedPropertyColumn("firstId", symbol.firstId.toString())
        NamedPropertyColumn("highPrice", symbol.highPrice)
        NamedPropertyColumn("lastId", symbol.lastId.toString())
        NamedPropertyColumn("lastPrice", symbol.lastPrice)
        NamedPropertyColumn("lastQty", symbol.lastQty)
        NamedPropertyColumn("lowPrice", symbol.lowPrice)
        NamedPropertyColumn("openPrice", symbol.openPrice)
        NamedPropertyColumn("openTime", symbol.openTime.toString())
        NamedPropertyColumn("prevClosePrice", symbol.prevClosePrice)
        NamedPropertyColumn("priceChange", symbol.priceChange)
        NamedPropertyColumn("priceChangePercent", symbol.priceChangePercent)
        NamedPropertyColumn("quoteVolume", symbol.quoteVolume)
        NamedPropertyColumn("symbol", symbol.symbol)
        NamedPropertyColumn("volume", symbol.volume)
        NamedPropertyColumn("weightedAvgPrice", symbol.weightedAvgPrice)
    }
}

@Composable
fun NamedPropertyColumn(
    name: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = value)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}