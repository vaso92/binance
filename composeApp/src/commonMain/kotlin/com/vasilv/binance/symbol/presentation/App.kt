package com.vasilv.binance.symbol.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.vasilv.binance.symbol.presentation.symbollist.SymbolListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        SymbolListScreen()
    }
}