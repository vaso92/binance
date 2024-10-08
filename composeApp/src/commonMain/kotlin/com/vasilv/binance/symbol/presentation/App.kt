package com.vasilv.binance.symbol.presentation

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.vasilv.binance.symbol.presentation.symbollist.SymbolListScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext() {
        MaterialTheme {
            Navigator(SymbolListScreen())
        }
    }
}