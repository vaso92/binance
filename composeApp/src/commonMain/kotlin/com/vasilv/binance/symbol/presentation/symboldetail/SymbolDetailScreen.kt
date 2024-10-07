package com.vasilv.binance.symbol.presentation.symboldetail

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.vasilv.binance.symbol.domain.model.Symbol

class SymbolDetailScreen(val symbol: Symbol) : Screen {
    @Composable
    override fun Content() {
        SymbolDetailContent(symbol)
    }
}